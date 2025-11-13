class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> l = new ArrayList<>(); 
        
        Stack<Integer> st = new Stack<>(); 
        int n = arr.length; 
        st.push(0);
        l.add(1);
        
        for(int i=1 ; i<n; i++)
        {
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop(); 
            }
            
            if(st.empty())
            {   l.add(i+1);
               
            }
            else{
                l.add(i-st.peek()); 
            }
            
            st.push(i); 
        }
        return l ;
    }
}
