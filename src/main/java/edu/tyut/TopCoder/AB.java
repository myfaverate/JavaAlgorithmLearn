package edu.tyut.TopCoder;

public class AB {
    public String createString(int N, int K) {
        /*
            10
            12
            Returns: "BAABBABAAB"
        */
        char[] chars = new char[N];

        return "";
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
