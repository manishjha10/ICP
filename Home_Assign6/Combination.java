class Solution {

    public List<List<Integer>> combine(int n, int k) { 
        List<List<Integer>>  res = new ArrayList<>() ;
        List<Integer> l = new ArrayList<>() ;
        helper(n , k ,l , res) ;
        return res ;
    }
    public static void helper(int n , int k ,List<Integer> l,List<List<Integer>>  res){
      
      if(k==0){
        res.add(new ArrayList<>(l));   //  all the elements are add  
        return ;
      }
      if(n==0) return ; //  we not proceed  


      //  pick 
      l.add(n) ;
      helper(n-1,k-1,l,res);
      // not pick [back track] 
      //  list given manullay backtrack 
      l.remove(l.size()-1);
      helper(n-1,k,l, res);

    }
}
