// TC:O(N) , SC: O(N)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length ;
        Stack<Integer> st = new Stack<>() ;
        int[] nge = new int[n];
        
        st.push(n-1);
        nge[n-1] = n ;
        for(int i = n-2 ;i>=0;i--){

        // step1: pop 
        while(st.size() > 0 && nums[st.peek()] <= nums[i]) st.pop() ;

        // Step2 : answer  
        if(st.size() == 0) nge[i] = n;
        else nge[i] = st.peek();

         // step3: push
         st.push(i);

        }
        int j = 0, l= 0;
        int[] res  = new int[n-k+1]; 
        for(int i=0 ;i <= n-k ;i++){
            // enter the loop to find the maximum window starting at i 
           if(j < i){
            j = i ;
           }
          
          while(nge[j] < i+k){
            j = nge[j];
          }
          res[l++] =  nums[j];
        }
        return res  ;
    }
}
