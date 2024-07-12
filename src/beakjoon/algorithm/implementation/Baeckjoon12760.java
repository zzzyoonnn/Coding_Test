package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baeckjoon12760 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 플레이어의 수
        int m = Integer.parseInt(st.nextToken());   // 가진 카드 수

        List<Integer>[] list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list[i], Collections.reverseOrder());
        }

        int[] score = new int[n];

        for (int j = 0; j < m; j++) {
            int max = -1;

            for (int i = 0; i < n; i++) {
                int num = list[i].get(j);

                if (max < num) max = num;
            }

            for (int i = 0; i < n; i++) {
                if (list[i].get(j) == max) score[i]++;
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            int num = score[i];

            if (max < num) max = num;
        }

        for (int i = 0; i < n; i++) {
            if (max == score[i]) System.out.print(i + 1 + " ");
        }

    }
}
