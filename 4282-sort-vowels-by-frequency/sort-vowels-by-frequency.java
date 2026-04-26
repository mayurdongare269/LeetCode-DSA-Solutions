class Solution {
    public String sortVowels(String s) {
        int n = s.length();

        List<Character> vo = new ArrayList<>();
        for(char c : s.toCharArray()) {
            if(isVowel(c)) {
                vo.add(c);
            }
        }

        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> first = new HashMap<>();

        for(int i = 0; i < vo.size(); i++) {
            char c = vo.get(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            first.putIfAbsent(c, i);
        }

        // sort vowels
        Collections.sort(vo, (a, b) -> {
            if(!freq.get(a).equals(freq.get(b))) {
                return freq.get(b) - freq.get(a);
            } 
            return first.get(a) - first.get(b);
        });

        StringBuilder sb = new StringBuilder();
        int idx = 0;

        for(int i = 0; i < n; i++) {
            if(isVowel(s.charAt(i))) {
                sb.append(vo.get(idx++));
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();

        
        // HashMap<Character, Integer> map = new HashMap<>();

        // for(int i = 0; i < n; i++) {
        //     if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
        //         map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        //     }
        // }

        // String ans = "";
        // for(int i = 0; i < n; i++) {
        //     if(!isVowel(s.charAt(i))) {
        //         ans += s.charAt(i);
        //     } else {
        //         int freq = map.get(s.charAt(i));
        //         for(int j = 0; j<freq; j++) {
        //             ans += s.charAt(i);
        //         }
        //     }
        // }
        // return ans;
    }

    public boolean isVowel(char s) {
        if(s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u') {
            return true;
        }
        return false;
    }
}