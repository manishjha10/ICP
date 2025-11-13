class Solution { 
    static void helper(int[] arr  , List<List<Integer>> ll , List<Integer> l , int index  , int tar)
    {
       if(index ==  arr.length)
       { 
        //  it is ensure add the list should be in leaf 
        if(tar  == 0){
        ll.add(new ArrayList<>(l));}
        return ;
       }

      // incl ele
       if(arr[index] <=  tar){
       l.add(arr[index]) ;
       helper(arr, ll, l , index , tar -  arr[index]);  //  tar should dec
       l.remove(l.size()-1) ;// to backtrack
       }


      // not pick  
      helper(arr , ll , l , index+1 , tar);
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

       List<List<Integer>> res = new ArrayList<>(); 
       List<Integer> l = new ArrayList<>();
       Arrays.sort(candidates);
      
        helper(candidates , res , l , 0 , target); //  arraylist
        return res ;
    }
}
