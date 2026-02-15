class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(map.get(ch) != null) {
                if(map.get(ch) == 1) { // only one freq then remove whole char
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1); // decrease freq one by one 
                }
            } else {
                return false;
            }
        }

        return map.isEmpty();


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



    }
}