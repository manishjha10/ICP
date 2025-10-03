

class Solution { 
    public void helper(int[] arr, int target, List<List<Integer>> res, List<Integer> temp, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue; // Skip duplicates
            
            if (arr[i] > target) break; // No need to proceed if the element is greater than target
            
            temp.add(arr[i]);
            helper(arr, target - arr[i], res, temp, i + 1);
            temp.remove(temp.size() - 1); // Backtrack
        }
    }  

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }
}
