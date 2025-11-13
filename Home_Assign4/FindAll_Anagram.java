class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n  = s.length(); 
        int m = p.length(); 
        List<Integer> l = new ArrayList<>();  
        if(n < m) return l;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for(char ch : p.toCharArray()) count1[ch - 'a']++;
        
        for(int i=0; i<m; i++)
        {
            count2[s.charAt(i) - 'a']++;
        }
        
        //first window
        if(Arrays.equals(count1, count2)) l.add(0); 

        //  slide window
        for(int i=m; i<n; i++)
        {
            count2[s.charAt(i)- 'a'] ++ ; //add new 
            count2[s.charAt(i-m) - 'a']--;  // remove old

            if(Arrays.equals(count1, count2)) l.add(i-m + 1); 
            // last one add. 
        }
        return l;
    }
}
