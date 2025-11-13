class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(); 
        int n2 = s2.length(); 
        int[] count1 = new int[26];
        int[] count2 = new int[26]; 
        
        if(n1 > n2) return false; 

        for(char ch : s1.toCharArray()) count1[ch-'a']++;
        for(int i=0; i<n1; i++)
        {
            char ch = s2.charAt(i);
            count2[ch-'a']++ ;
        } 
        if(check(count1, count2)) return true; 

        for(int i=n1; i<n2; i++)
        {
            count2[s2.charAt(i)-'a']++;
            
            count2[s2.charAt(i-n1) - 'a']--;

            if(check(count1, count2)) return true;
        }
        
        return false; 
    } 
    public boolean check(int[] a1, int[] a2)
    {
        for(int i=0; i<a1.length; i++)
        {
            if(a1[i] != a2[i]) return false;
        }
        return true; 
    }
}
