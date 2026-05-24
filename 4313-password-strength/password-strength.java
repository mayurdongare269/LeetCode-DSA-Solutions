class Solution {
    public int passwordStrength(String password) {
        int n = password.length();

        boolean[] low = new boolean[26];
        boolean[] upp = new boolean[26];
        boolean[] dig = new boolean[10];

        boolean exm  = false;
        boolean  at = false;
        boolean hash = false;
        boolean dol = false;

        int stn = 0;

        for(char ch : password.toCharArray()) {
            if(ch >= 'a' && ch <= 'z') {
                int idx = ch - 'a';

                if(!low[idx]) {
                    low[idx] = true;
                    stn += 1;
                }
            }

            else if(ch >= 'A' && ch <= 'Z') {
                int idx = ch - 'A';

                if(!upp[idx]) {
                    upp[idx] = true;
                    stn += 2;
                }
            }

            else if(ch >= '0' && ch <= '9') {
                int idx = ch - '0';

                if(!dig[idx]) {
                    dig[idx] = true;
                    stn += 3;
                }
            }

            else if(ch == '!') {
                if(!exm) {
                    exm = true;
                    stn += 5;
                }
            }

            else if(ch == '@') {
                if(!at) {
                    at = true;
                    stn += 5;
                }
            }

            else if(ch == '#') {
                if(!hash) {
                    hash = true;
                    stn += 5;
                }
            }

            else if(ch == '$') {
                if(!dol) {
                    dol = true;
                    stn += 5;
                }
            }  
        }

        return stn;

        
    }
}