package 완전탐색;

import java.io.*;
import java.util.StringTokenizer;

public class PerfectSearch {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();

        resolve(1);

        System.out.println(sb.toString());
    }

    static int N, M;

    static int[] selected;

    /**
     * 입력을 받는 함수
     */
    static void input() {
        FastReader fastReader = new FastReader();

        N = fastReader.nextInt();
        M = fastReader.nextInt();

        selected = new int[M + 1];
    }

    /**
     * 문제 풀이 함수
     * @param k
     */
    static void resolve(int k) {

        if (k == M + 1) {
            for (int i = 1; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
        } else {
            for (int candidate = 1; candidate < N; candidate++) {
                selected[k] = candidate;
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
