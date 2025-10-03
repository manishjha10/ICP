class Solution {
    public boolean exist(char[][] arr, String word) {
        int rows = arr.length;
        int cols = arr[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == word.charAt(0)) {
                    if (sol(arr, i, j, rows, cols, word, 0)) {
                        return true; // found the word
                    }
                }
            }
        }
        return false;
    }

    public static boolean sol(char[][] arr, int cr, int cc, int rows, int cols, String word, int idx) {
        if (idx == word.length()) return true;
        if (cr < 0 || cc < 0 || cr >= rows || cc >= cols || arr[cr][cc] != word.charAt(idx)) 
            return false;

        char ch = arr[cr][cc];  
        arr[cr][cc] = '*';        

        boolean found = sol(arr, cr-1, cc, rows, cols, word, idx+1) ||
                        sol(arr, cr+1, cc, rows, cols, word, idx+1) ||
                        sol(arr, cr, cc-1, rows, cols, word, idx+1) ||
                        sol(arr, cr, cc+1, rows, cols, word, idx+1);

        arr[cr][cc] = ch;        
        return found;
    }
}
