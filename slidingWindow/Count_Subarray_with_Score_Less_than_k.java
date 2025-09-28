class Solution {
    public long countSubarrays(int[] nums, long k) {
       int n  = nums.length; 
       int left = 0, right = 0;
       long count = 0, sum = 0; 

       while(right < n)
       {
         sum += nums[right];  //  expand
         
         while(sum * (right - left + 1) >= k)  //  shrink  
         {
            sum -= nums[left++]; 
         }

         count += (right - left + 1); 
         right ++ ;
       } 
        return count;
    }
}
