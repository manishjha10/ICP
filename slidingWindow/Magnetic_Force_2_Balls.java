package BinarySearch_OnAnswers;
import java.util.*;

public class Magnetic_Force_Between_Two_Balls {
    public static int maxDistance(int[] position, int m) {
        // maximum [ans]

        Arrays.sort(position);
        int lo = 0;
        int hi = position[position.length -1];

        long ans = 0;

        while(lo <= hi)
        {
            int mid = lo + (hi-lo)/2;

            if(position(position, mid, m))
            {
                ans = mid ;
                lo = mid + 1;    // maximum
            }
            else
            {
                hi = mid-1;
            }
        }
        return (int)ans;
    }

    public static boolean position(int[] arr , long mid , int k)
    {
        int cp = arr[0];
        k-=1;

        for(int i=1; i<arr.length; i++)
        {
            if(mid <= Math.abs(arr[i] - cp))
            {
                k--;
                cp = arr[i];
                if(k == 0) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5}; 
        int k = 3; 
        int ans = maxDistance(arr, k);
        System.out.println(ans);
    }
}
