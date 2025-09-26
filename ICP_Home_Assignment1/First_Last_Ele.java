// Overall Tc: log(N)
class Solution {
    public int first(int[] arr , int target)
    {
        int st = 0 , end = arr.length-1, res  = -1 ; 
      
        while(st <= end)
        {
            int mid  = st + (end-st)/2; 
            if(arr[mid] == target)
            {
                res =  mid; 
                end = mid -1;  
            }
            else if(arr[mid] < target)
            {
               st = mid +1; 
            }
            else
            {
                end  =  mid - 1; 
            }
        }
        return res; 
    }

    public int last(int[]  arr , int target)
    {
        int st = 0, end = arr.length-1, res = -1; 
    
        while(st <= end)
        {
            int mid  = st + (end-st)/2; 
            if(arr[mid] == target)
            {
                res =  mid; 
                st = mid + 1;  
            } 
            else if(arr[mid] < target)
            {
               st = mid +1; 
            }
            else
            {
                end  =  mid - 1; 
            }
        }
        return res; 
    }
    public int[] searchRange(int[] nums, int target) {
     int f  = first(nums, target);   
     int l  =  last(nums, target); 
     return new int[]{f,l};  
    }
}
