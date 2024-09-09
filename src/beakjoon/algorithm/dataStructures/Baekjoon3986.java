package beakjoon.algorithm.dataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon3986 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());  // number of words

    int count = 0;
    String s;
    Stack<Character> stack;
    for (int i = 0; i < n; i++) {
      s = br.readLine();
      if (s.length() % 2 != 0) continue;
      stack = new Stack<Character>();

      stack.push(s.charAt(0));
      for (int j = 1; j < s.length(); j++) {
        if (!stack.isEmpty() && stack.peek() == s.charAt(j)) {
          stack.pop();
        }
        else stack.push(s.charAt(j));
      }

      if (stack.isEmpty()) count++;

    }

    System.out.println(count);
  }
}
