class Solution {
    public boolean isAnagram(String s1, String s2) {
        // HashMap<Character, Integer> map = new HashMap<>();

        // for(int i = 0; i < s.length(); i++) {
        //     map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        // }

        // for(int i = 0; i < t.length(); i++) {
        //     char ch = t.charAt(i);
        //     if(map.get(ch) != null) {
        //         if(map.get(ch) == 1) { // only one freq then remove whole char
        //             map.remove(ch);
        //         } else {
        //             map.put(ch, map.get(ch) - 1); // decrease freq one by one 
        //         }
        //     } else {
        //         return false;
        //     }
        // }

        // return map.isEmpty();


        //M2: 

        // s = s.toLowerCase();
        // t = t.toLowerCase();

        // if(s.length() == t.length()) {
        //     char[] s1 = s.toCharArray();
        //     char[] s2 = t.toCharArray();

        //     Arrays.sort(s1);
        //     Arrays.sort(s2);

        //     return Arrays.equals(s1, s2);
        // } else {
        //     return false; 
        // }
        //no return at last 
        //beacuse There is no way for the program to reach the end of the method. So Java is satisfied.

        //M3:
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 != n2) return false;

        int[] word = new int[256];
        for(int i = 0; i < n1; i++) {
            word[s1.charAt(i)]++;
        }

        for(int i = 0; i < n1; i++) {
            word[s2.charAt(i)]--;

            if(word[s2.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }
}