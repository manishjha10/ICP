//  NASTYA AND RICE
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n+1];
            for (int i = 1; i <= n; i++) a[i] = Integer.parseInt(st.nextToken());

            int[] peak = new int[n+1];
            for (int i = 2; i <= n-1; i++) {
                if (a[i] > a[i-1] && a[i] > a[i+1]) peak[i] = 1;
            }

            int[] pref = new int[n+1];
            for (int i = 1; i <= n; i++) pref[i] = pref[i-1] + peak[i];

            int bestPeaks = -1;
            int bestL = 1;
            for (int l = 1; l <= n - k + 1; l++) {
                int r = l + k - 1;
                // peaks are indices l+1 .. r-1 => pref[r-1] - pref[l]
                int cnt = pref[r-1] - pref[l];
                if (cnt > bestPeaks) {
                    bestPeaks = cnt;
                    bestL = l;
                }
            }
            out.append((bestPeaks + 1)).append(" ").append(bestL).append("\n");
        }
        System.out.print(out.toString());
    } 


  
}
