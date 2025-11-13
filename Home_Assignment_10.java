////  MIN STACK 
class MinStack {
    Stack<Long> st  = new Stack<>() ;
    long min = -1 ; 
   
    public MinStack() {
        // constructor.
    }
    
    public void push(int val) {
        long x  = (long)val ;
        if(st.size() ==0)
        {  
          st.push(x);
          min =  x ;
        }
        else if(x >= min)
        {
            st.push(x) ;
        }
        else if(x <= min)
        { 
         st.push(2*x - min);
         min =  x ;
        }
    }
    
    public void pop() {
        
        if(st.size() ==0)
        {  
         return ;
        }
        else if(st.peek() >= min) st.pop();
        else if(st.peek() <= min)
        {
          long oldMin  = 2*min - st.peek() ;
          min  = oldMin ;
          st.pop();
        }    
    }
    
    public int top() { 
        
        if(st.size() ==0)
        {  
            return -1 ;  
        }
        long q =  st.peek();
        if(q >= min)
        {
          return (int)q;
        }
        else if (q <= min) {
            return (int)min ;
        }
       return 0;
    }
    
    public int getMin() {
        if(st.size() == 0) return  -1 ;
        return (int)min;
    }
}

// STACK USING QUEUE 
class MyStack {
   Queue<Integer> q ;
    public MyStack() {
        q  = new LinkedList<>() ;
    }
    // pop  Efficient 
    public void push(int x) {
        if(q.size() == 0) q.add(x) ;
        else
        {
            q.add(x) ;
            for(int i=0; i<q.size()-1; i++){
                q.add(q.remove()) ;
            }
        }
    }
    
    public int pop() {
        return q.remove();
    }
    
    public int top() {
        return q.peek() ;
    }
    
    public boolean empty() {
        if(q.size() == 0) return true ;
        return false;
    }
}


// ASTEROID COLLOSION 
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> st  = new ArrayList<>(); 

        for(int ele : asteroids)
        {
            if(ele >= 0)
            {
              st.add(ele);
            }

            while(st.size() > 0 &&  ele < 0 && st.get(st.size()-1) > 0 && Math.abs(ele) > st.get(st.size()-1)) st.remove(st.size()-1) ;

            if(st.size() > 0 &&  ele < 0 && st.get(st.size()-1) > 0 && Math.abs(ele) == st.get(st.size()-1))  st.remove(st.size()-1);
            
            else if(st.size() == 0 || st.get(st.size()-1) < 0)
            {
                st.add(ele);
            }
        }

        int[] arr  = new int[st.size()];
        for(int i=0; i<st.size(); i++)
        {
            arr[i] = st.get(i);
        }
    return arr ;
    
    }
} 


// NEXT GREAER ELEMNT
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n  = nums2.length; 
        int[]  res = new int[n]; 
        Stack<Integer> st = new Stack<>(); 
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(nums2[n-1], -1);
        st.push(n-1); 

        for(int i=n-2; i>=0; i--)
        {
            while(!st.isEmpty() && nums2[st.peek()] <= nums2[i]) st.pop();

            if(st.isEmpty())
            {
                mp.put(nums2[i], -1);
            }
            else
            {
                mp.put(nums2[i], nums2[st.peek()]);
            }
            st.push(i); 
        }

        int ind = 0; 
        int[] ans = new int[nums1.length];
       
        for(int i=0; i<nums1.length; i++)
        {   
            if(mp.containsKey(nums1[i]))
            {
                ans[ind++] = mp.get(nums1[i]);
            } 
        }
        return ans; 
    }
}

// LEETCODE  85 
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length; 
        int m = matrix[0].length;
        int height[] = new int[m];  
        
        int max = -1; 
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(matrix[i][j] == '1') height[j]++;
                else height[j] = 0; 
            }
            int ans = find(height);
            max = Math.max(ans,max);
        }
        return max;
    }
    public int find(int[] arr)
    {
        Stack<Integer> st = new Stack<>(); 
        int n = arr.length; 
        int[] nse = new int[n]; 
        int[] pse = new int[n]; 

        st.push(n-1); 
        nse[n-1] = n;

        for(int i=n-2; i>=0; i--)
        {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop(); 
           
            if(st.isEmpty())  nse[i] = n; 
            else   nse[i] = st.peek(); 
            st.push(i);
        }

        while(st.size() > 0) st.pop(); 
        

        st.push(0);
        pse[0] = -1; 

        for(int i=1; i<n; i++)
        {
         while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();   
          
            if(st.size() == 0)
            {
                pse[i] = -1; 
            }
            else
            {
                pse[i] = st.peek(); 
            }
            st.push(i);
        }

        int max = -1; 

        for(int i=0; i<n; i++)
        {
            int ans = arr[i]*(nse[i] - pse[i] - 1); 
            max = Math.max(ans, max); 
        }  
        return max; 
    }
}

// DECODE STRING 
