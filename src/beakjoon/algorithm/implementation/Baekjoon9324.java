package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9324 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());    // 테스트 케이스 개수

        for (int tc = 0; tc < n; tc++) {
            boolean check = true;
            String s = br.readLine();

            int[] arr = new int[26];
            char[] charArray = s.toCharArray();

            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'A';
                arr[index]++;

                // 문자가 3번 나왔다면
                if (arr[index] == 3) {
                    if (i + 1 >= s.length()) {
                        check = false;
                    } else if (charArray[i] != charArray[i + 1]) {
                        check = false;
                        break;
                    } else {
                        arr[index] = 0;
                        i++;
                    }
                }
            }

            if (check) sb.append("OK").append('\n');
            else sb.append("FAKE").append('\n');
        }

        System.out.println(sb);
    }
}
