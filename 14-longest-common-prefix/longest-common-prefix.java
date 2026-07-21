class Solution {
    // 2 approached sort and one optimal...

    public String longestCommonPrefix(String[] strs) {
        // M-I: sorting TC: O(n log n + m) - easy one

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        int i = 0;

        while (i < first.length() && i < last.length()) {

            if (first.charAt(i) == last.charAt(i))
                i++;
            else
                break;
        }

        return first.substring(0, i); // here no i+1 bz start from zero... 


        // //M-II: optimal TC:(O(n x m)) -not understanded
        // String prefix = strs[0];

        // for (int i = 1; i < strs.length; i++) {

        //     while (!strs[i].startsWith(prefix)) {

        //         prefix = prefix.substring(0, prefix.length() - 1);

        //         if (prefix.isEmpty())
        //             return "";
        //     }
        // }

        // return prefix;


    }
}