package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

public class Baekjoon17176 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    HashMap<Character, Integer> cipherText = new HashMap<Character, Integer>();
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());

      if (num == 0) {
        cipherText.put(' ', cipherText.getOrDefault(' ', 0) + 1);
      }
      else if (num >= 1 && num <= 26) {
        cipherText.put((char)('A' + num - 1), cipherText.getOrDefault((char)('A' + num - 1), 0) + 1);
      }
      else {
        cipherText.put((char)('a' + num - 27), cipherText.getOrDefault((char)('a' + num - 27), 0) + 1);
      }
    }
    String str = br.readLine();
    HashMap<Character, Integer> plainText = new HashMap<>();

    for (int i = 0; i < str.length(); i++) {
      plainText.put(str.charAt(i), plainText.getOrDefault(str.charAt(i), 0) + 1);
    }

    for (char c : plainText.keySet()) {
      if (!Objects.equals(plainText.get(c), cipherText.get(c)) || !cipherText.containsKey(c)) {
        System.out.println('n');
        System.exit(0);
      }
    }

    System.out.println('y');
  }
}
