public class Solution {
    public bool CheckString(string s) {
        int n = s.Length;

        int cnt_a = 0;
        for(int i = 0; i < n; i++) {
            if(s[i] == 'a') {
                cnt_a++;
            }
        }

        for(int i = 0; i < cnt_a; i++) {
            if(s[i] != 'a') {
                return false;
            }
        }

        return true;
    }
}