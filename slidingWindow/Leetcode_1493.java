class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0 , right = 0;
        int n = nums.length; 
        int cnt0 = 0, cnt1 = 0, max = -5, j=0;  
        boolean flag = false;
         

         //  only 1 zero delete in windoe: subarray with k size : variable
        while(right < n){
           if(nums[right] == 1)
           {
            cnt1 ++; 
           }
           else if(nums[right] == 0)
           {
            cnt0 ++ ;
           }

           while(cnt0 > 1){
              
              if(nums[left] == 0) cnt0 --; 
              left ++ ; 
              flag = true; 
           }
           max = Math.max(max, right-left);
           right ++ ;
        }

        if(cnt0 == 0 && n==cnt1)
        {
           return n-1; 
        }
        else if(!flag && cnt0 == 1)
        {
            max = cnt1 ;
        }
        return max; 


    }
}


// class Solution {
//     public int longestSubarray(int[] nums) {
//         // Variable SW : Subarray is not fixed. 

//         int i=0 , j=0 , max = 0 , zeros= 0 , k=1 , n = nums.length;

//         while(j < n)
//         {
//             if(nums[j] == 0) zeros ++;
            
//             while(zeros > k)
//             { 
//               if(nums[i] == 0) zeros -- ;  
//               i++; 
//             }
//             max = Math.max(max , j-i); //  we only find the 1 length.
//             j++;
//         }
//         return max;
//     }
// }
