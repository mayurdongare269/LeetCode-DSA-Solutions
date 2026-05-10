class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        StringBuilder sb = new StringBuilder();
        for(String chunk : chunks) {
            sb.append(chunk);
        }

        String s = sb.toString();

        HashMap<String, Integer> map = new HashMap<>();

        int n = s.length();
        int i = 0;

        while(i < n) {
            if(Character.isLowerCase(s.charAt(i))) {
                int start = i;
                i++;

                while(i < n) {
                    char c = s.charAt(i);

                    if(Character.isLowerCase(c)) {
                        i++;
                    } else if(c == '-' && i - 1 >= start && i + 1 < n &&
                             Character.isLowerCase(s.charAt(i-1)) && 
                             Character.isLowerCase(s.charAt(i+1))) {
                        i++;
                    } else {
                        break;
                    }
                }

                String word = s.substring(start, i);
                map.put(word, map.getOrDefault(word, 0) + 1);

                
            } else {
                i++;
            }
        }

        int[] ans = new int[queries.length];
                for(i = 0; i < queries.length; i++) {
                    ans[i] = map.getOrDefault(queries[i], 0);
                }

        return ans;
    }
}
