class Solution {
    public int compress(char[] chars) {

        int n = chars.length;
        int idx = 0;

        for(int i = 0; i < n; i++) {
            int cnt = 1;

            while(i < n-1 && chars[i] == chars[i+1]) {
                cnt++;
                i++;
            }

            chars[idx++] = chars[i];

            if(cnt > 1) {
                String cntstr = String.valueOf(cnt);
                for(char ch : cntstr.toCharArray()) {
                    chars[idx++] = ch;
                }
            }
        
        }

        return idx;




        // StringBuilder sb = new StringBuilder("");
        // int n = chars.length;
        

        // for(int i = 0; i < n; i++) {
        //     int cnt = 1;

        //     while(i < n-1 && chars[i] == chars[i+1]) {
                
        //         cnt++;
        //         i++;
        //     }
        //     sb.append(chars[i]);

        //     if(cnt > 1) {
        //         sb.append(cnt);
        //     }
        // }
        // return sb.length();
    }
}