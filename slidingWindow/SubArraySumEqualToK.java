class Solution {
    public int subarraySum(int[] arr, int k) {
        int n  = arr.length , cnt = 0, sum = 0; 
        Map<Integer, Integer>  mp = new HashMap<>(); 
        mp.put(0,1); 

        for(int i=0; i<n; i++)
        {   
            sum += arr[i];
           if(mp.containsKey(sum-k))
           {
             cnt += mp.get(sum-k);   // count 
           }
           mp.put(sum, mp.getOrDefault(sum,0)+1); 
        }
        return cnt ; 
    }
}
