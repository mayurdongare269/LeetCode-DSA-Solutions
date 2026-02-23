class Solution { // easy one
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> st = new HashSet<>();
        int n = s.length();

        int tot = (int)Math.pow(2, k); // 1 << k

        for(int i = k; i <= n; i++) {
            String sub = s.substring(i-k, i);

            if(!st.contains(sub)) {
                st.add(sub);
                tot--;
            } 
            
            if(tot == 0) {
                return true;
            }
        }

        return false;
    }
}