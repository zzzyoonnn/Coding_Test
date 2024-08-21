package beakjoon.algorithm.implementation;

import java.io.*;
import java.util.*;

public class Baeckjoon20301 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();

        // O(n)
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int index = 0;
        int count = 0;
        boolean check = true;   // true -> forward. flase -> reverse

        while (!list.isEmpty()) {   // run 'n' times
            if (check) {
                index = (index + k - 1) % list.size();  // O(1)
            } else {
                index = (index - (k % list.size()) + list.size()) % list.size();    // O(1)
            }

            System.out.println(list.remove(index));
            count++;

            if (count % m == 0) {   // O(1)
                check = !check;
            }
        }
    }
}
