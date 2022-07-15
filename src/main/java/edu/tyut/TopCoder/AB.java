package edu.tyut.TopCoder;

public class AB {
    public String createString(int N, int K) {
        /*
                                      01234 56789
            10, 12      "BAABBABAAB"->ABBBB ABBBB
            17, 14		"ABBBB ABBBB BAAAA AA->BABB BBBBB BBBBB BB
            20, 20		"AABBBBBBBBBBAAAAAAAA"->ABBBB BBBBB BBBBB BBBAB
            24, 102		"AAAAAAAABBBBBBABBBBBBAAA"->AAAAA BBBBB BABBB BBBBB BBBB
            K=102-(24-(1))  79
            K=K-(24-(2))  57
            简单点
            3, 2		"ABB"
            2, 0		"BA"
        */

        // 过滤
        if (((N & 1) == 0) && ((N / 2) * (N / 2) < K)) return "";
        else if (((N & 1) != 0) && ((N / 2) * (N / 2 + 1) < K)) {
            return "";
        }

        char[] chars = new char[N];
        for (int i = 0; i < N; i++) {
            chars[i] = 'B';
        }
        if (N > K) {
            chars[N - K - 1] = 'A';
            return new String(chars);
        }
        int i=0;
        int tmp = K;
        while (true) {
            if (N > K) { // 24,102
                chars[N - K - 1 + i] = 'A'; // 24, 102 AAAAA BBBBB BABBB BBBBB BBBB
                return new String(chars);
            }else {
                chars[i]='A';
                N--;
                K=tmp-N*(i+1);
                i++;
            }
        }
    }
    // K=K-N+1; // 24, 102		"AAAAAAAABBBBBBABBBBBBAAA"->AAAAABBBBBBABBBBBBBBBBBB

    public int ABNum(String str) {
        int result = 0;
        int len = str.length();
        int left = 0;
        int right = len - 1;
        while (left < len && str.charAt(left) != 'A') {
            left++;
        }
        while (left < len) {
            while (left < right) {
                if (str.charAt(left) == 'A' && str.charAt(right) == 'B') {
                    result++;
                }
                right--;
            }
            left++;
            right=len-1;
        }
        return result;
    }

    public static void main(String[] args) {
        AB ab = new AB();
//        System.out.println(ab.createString(3, 3));
//        System.out.println(ab.createString(7, 16));
//        System.out.println(ab.createString(14, 67));
//        System.out.println(ab.createString(16, 97));
//        System.out.println(ab.createString(25, 242));
//        System.out.println(ab.createString(30, 273));
//        System.out.println(ab.createString(34, 458));
//        System.out.println(ab.createString(35, 481));
//        System.out.println(ab.createString(36, 452));
//        System.out.println(ab.createString(47, 744));
//        System.out.println(ab.createString(49, 601));
//        System.out.println(ab.createString(50, 626));
//        System.out.println(ab.createString(50, 1225));
//        System.out.println(ab.createString(50, 1220));
//        System.out.println(ab.createString(50, 636));
//        System.out.println(ab.createString(5, 7));
//        System.out.println(ab.createString(5, 8));
        System.out.println("++++++++++++++++++++++++++++++++");
//        System.out.println(ab.createString(10, 12));
//        System.out.println(ab.createString(17, 14));
//        System.out.println(ab.createString(20, 20));
        System.out.println(ab.createString(20, 22));
        System.out.println(ab.createString(24, 102));
        System.out.println("================================");
        /*
            10, 12      "BAABBABAAB"->ABBBB ABBBB  ABBBBABBBB
            17, 14		"ABBBB ABBBB BAAAA AA->BBABB BBBBB BBBBB BB
            20, 20		"AABBBBBBBBBBAAAAAAAA"->ABBBB BBBBB BBBBB BBABB
            24, 102		"AAAAAAAABBBBBBABBBBBBAAA"->AAAAA BBBBB BABBB BBBBB BBBB
        */
        System.out.println(ab.ABNum("BAABBABAAB"));
        System.out.println(ab.ABNum("ABBBBABBBBBAAAAAA"));
        System.out.println(ab.ABNum("AABBBBBBBBBBAAAAAAAA"));
        System.out.println(ab.ABNum("BBBBBBABBBBBBBBBBBB")); // 19 12

    }

    public String createString1(int N, int K) {
        for (int cntB = 0; cntB <= N; cntB++) {
            char[] a = new char[N];
            for (int i = 0; i < cntB; i++) {
                a[i] = 'B';
            }
            for (int i = cntB; i < N; i++) {
                a[i] = 'A';
            }
            int cur = 0;
            while (true) {
                if (cur == K) {
                    return new String(a);
                }
                int pos = -1;
                for (int i = 0; i + 1 < N; i++) {
                    if (a[i] == 'B' && a[i + 1] == 'A') {
                        pos = i;
                        break;
                    }
                }
                if (pos == -1) {
                    break;
                }
                cur++;
                a[pos] = 'A';
                a[pos + 1] = 'B';
            }
        }
        return "";
    }
}
