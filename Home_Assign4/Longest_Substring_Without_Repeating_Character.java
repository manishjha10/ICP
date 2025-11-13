class Solution {
    public int lengthOfLongestSubstring(String s) {
      int[] arr = new int[256];
      int max  = Integer.MIN_VALUE;
      int left = 0, right = 0; 

      while(right < s.length())
      {
        char ch = s.charAt(right); 
        arr[ch]++; 
        
        while(arr[ch] > 1)
        {
          // left 
            arr[s.charAt(left)]-=1;
            left ++ ;
        }
        max = Math.max(max, right - left +1);
        right ++ ;
      } 
      return max;  
    }
}
