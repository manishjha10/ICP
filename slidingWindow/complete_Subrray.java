class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> s = new HashSet<>(); 
        for(int e :  nums) s.add(e);
        int k = s.size(); 
        int n  = nums.length;
        if(k == 1)
        {
            return (n*(n+1))/2;
        } 
        int cnt = 0;

        for(int i=0; i<=n-k; i++)
        {  LinkedHashMap<Integer,Integer> mp = new LinkedHashMap<>(); 
           for(int j=i; j<n; j++)
           { 
             mp.put(nums[j],1);
             if(mp.size() == k)
             {
                cnt += 1; 
             }
             
           }
        }
        return cnt ;
    }
}
