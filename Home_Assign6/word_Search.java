class Solution { 
    public boolean valid(char[][] board, int sr, int sc, int er, int ec, String word, int idx)
    {
        if(sr < 0 || sc < 0 || sr > er || sc > ec) 
           return false; 
        if(board[sr][sc] == '*' || board[sr][sc] != word.charAt(idx) ) return false;
        
        if(idx == word.length()-1) 
        {
            return true; 
        }
        
        char ch = board[sr][sc]; 
        board[sr][sc] = '*'; 

        boolean found =       valid(board, sr-1, sc, er, ec, word, idx+1) || 
                              valid(board, sr+1, sc, er , ec, word, idx+1) ||
                              valid(board, sr, sc-1, er, ec, word, idx+1) || 
                              valid(board, sr, sc+1, er, ec, word, idx+1);
        board[sr][sc] = ch; 
        return found; 

    }

    public boolean exist(char[][] board, String word) {
        int n  = board.length; 
        int m = board[0].length; 

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    if(valid(board,i, j, n-1, m-1, word, 0))
                    {
                        return true; 
                    }
                }
            }
        }
        return false;
    }
}
