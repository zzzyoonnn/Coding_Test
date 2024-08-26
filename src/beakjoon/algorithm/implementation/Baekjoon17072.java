package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 세로
        int m = Integer.parseInt(st.nextToken());   // 가로

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                    int red = Integer.parseInt(st.nextToken());
                    int green = Integer.parseInt(st.nextToken());
                    int blue = Integer.parseInt(st.nextToken());

                    int num = pixel(red, green, blue);

                    if (num < 510000) sb.append('#');
                    else if (num < 1020000) sb.append('o');
                    else if (num < 1530000) sb.append('+');
                    else if (num < 2040000) sb.append('-');
                    else sb.append('.');
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static int pixel(int red, int green, int blue) {
        return (2126 * red) + (7152 * green) + (722 * blue);
    }
}
