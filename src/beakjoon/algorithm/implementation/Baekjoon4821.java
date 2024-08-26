package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Baekjoon4821 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = 0;

        while (true) {
            total = Integer.parseInt(br.readLine());

            if (total == 0) break;

            HashSet<Integer> set = new HashSet<Integer>();

            String[] strArr = br.readLine().split(",");

            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].contains("-")) {
                    int low = Integer.parseInt(strArr[i].split("-")[0]);
                    int high = Integer.parseInt(strArr[i].split("-")[1]);

                    if (low > high) continue;

                    for (int j = low; j <= high; j++) {
                        if (j > total) continue;
                        set.add(j);
                    }
                } else if (Integer.parseInt(strArr[i]) <= total) {
                    set.add(Integer.parseInt(strArr[i]));
                }
            }

            System.out.println(set.size());
        }
    }
}
