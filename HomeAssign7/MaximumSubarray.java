class Solution {
    public int maxSubArray(int[] nums) { 
     
     int sum = 0 ;
     int pre  =  Integer.MIN_VALUE ; 
    
     for(int i=0; i<nums.length; i++){
        sum  += nums[i] ;  

        if(sum  > pre){
            pre = sum  ;
        }

        if(sum  < 0) {
            sum  = 0 ;
        }
     }   

    return pre ;

    }
}
