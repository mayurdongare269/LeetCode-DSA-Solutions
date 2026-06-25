class Solution {
    public String removeStars(String s) {
        // Stack<Character> st = new Stack<>();

        // for(char ch : s.toCharArray()) {
        //     if(!st.isEmpty() && ch == '*') {
        //             st.pop();
        //     } else {
        //         st.push(ch);
        //     }
            
        // }

        // StringBuilder sb = new StringBuilder();

        // while(!st.isEmpty()) {
        //     sb.append(st.pop());
        // }

        // return sb.reverse().toString();

        //Optimal...
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}