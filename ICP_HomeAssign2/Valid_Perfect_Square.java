import java.util.Scanner ;
class Solution {
    public boolean isPerfectSquare(int num) {
        long st = 0;
        long end = num ;
        
        while(st <= end){
            long mid = st + (end-st)/2 ;
            long  val = mid *mid ;
            if(val == num) {
                return true ;
            }else if(val > num){
                end = mid - 1 ;
            }else {
                st = mid +  1 ;
            }
        }
        return false ;
    }
