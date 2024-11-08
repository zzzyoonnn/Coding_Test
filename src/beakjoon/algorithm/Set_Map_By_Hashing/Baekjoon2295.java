package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.reverseOrder;

public class Baekjoon2295 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        set.add(arr[i] + arr[j]);
      }
    }

    int max = -1;
    for (int i = 0; i < n; i++){
      for (int j = 0; j < n; j++){
        int target = arr[i] - arr[j];
        if (set.contains(target)) {
          max = Math.max(max, arr[i]);
        }
      }
    }

    System.out.print(max);
  }
}
