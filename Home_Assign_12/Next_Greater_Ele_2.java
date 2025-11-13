class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[]  res = new int[nums.length];
         
        int n = nums.length ;
        Stack<Integer> st  = new Stack<>() ;
        res[n-1] = -1; //  2 last add  
        st.push(res[n-1]) ;

        for(int i=2*n-1 ;i>=0 ;i--){
          // 1) pop
          while(st.size() > 0 && st.peek() <=  nums[i%n]) {
            st.pop() ;
          }

          // answer  
          if(st.size() == 0) res[i%n] =-1 ;
          else{
            res[i%n] = st.peek() ;
          }

          // push 
          st.push(nums[i%n]) ;

        }
         return res  ; 
    }
}
