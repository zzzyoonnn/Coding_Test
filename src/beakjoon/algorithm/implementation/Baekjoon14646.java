package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon14646 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 메뉴의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = -1;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 2 * n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (set.contains(num)) {
                set.remove(num);
            }
            else {
                set.add(num);
                max = Math.max(max, set.size());
            }
        }

        System.out.println(max);
    }
}
