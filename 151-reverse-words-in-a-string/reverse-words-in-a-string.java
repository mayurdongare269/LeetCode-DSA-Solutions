class Solution {
    public String reverseWords(String s) {

        // Method = II ; using steps..  TC: O(N) and SC: O(N)


         // Step 1: Create StringBuilder from the input string
        StringBuilder sb = new StringBuilder(s);

        // Step 2: Reverse the entire string
        sb.reverse();

        // Step 3: Convert back to String
        s = sb.toString();

        int n = s.length();

        // Stores the final answer
        StringBuilder ans = new StringBuilder();

        // Traverse the reversed string
        for (int i = 0; i < n; i++) {

            // Stores one extracted word
            StringBuilder word = new StringBuilder();

            // Extract each character of the current word until a space is found
            while (i < n && s.charAt(i) != ' ') {
                word.append(s.charAt(i));
                i++;
            }

            // Reverse the extracted word to restore its original order
            word.reverse();

            // Ignore empty words caused by multiple spaces
            if (word.length() > 0) {

                // Add one space before every word except the first one
                if (ans.length() > 0) {
                    ans.append(" ");
                }

                // Append the current word to the final answer
                ans.append(word);
            }
        }

        // Return the final reversed sentence
        return ans.toString();




        // //Method - I: using split...
        // // Step 1: Trim leading and trailing spaces
        // s = s.trim();
        
        // // Step 2: Split by one or more spaces
        // String[] words = s.split("\\s+"); // here " " not possible beacuase there can be multiple spaces 
        
        // // Step 3: Reverse the array
        // StringBuilder result = new StringBuilder();
        // for(int i = words.length - 1; i >= 0; i--) {
        //     result.append(words[i]);
        //     if(i != 0) result.append(" ");
        // }
        
        // // Step 4: Return the final string
        // return result.toString();
    }
}