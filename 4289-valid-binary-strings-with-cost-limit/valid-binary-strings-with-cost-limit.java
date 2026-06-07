class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> ans = new ArrayList<>();

        backtrack(0, n, k, 0, new StringBuilder(), ans);

        return ans;
    }

    public void backtrack(int pos, int n, int k, int cost, StringBuilder curr, List<String> ans) {

        // pruning ... condition
        if(cost > k) {
            return;
        }

        // BC
        if(pos == n) {
            ans.add(curr.toString());
            return;
        }

        // 1st choice : put '0'
        curr.append('0');
        backtrack(pos+1, n, k, cost, curr, ans);
        curr.deleteCharAt(curr.length()-1);

        // 2nd chose: put '1'
        if(curr.length() == 0 || curr.charAt(curr.length() - 1) != '1') {
            curr.append('1');

            // cost increase by currrent index
            backtrack(pos + 1, n, k, cost+pos, curr, ans);

            curr.deleteCharAt(curr.length()-1);
        }
    }

}