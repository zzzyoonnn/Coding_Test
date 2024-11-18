package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon25497 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    char[] arr = br.readLine().toCharArray();
    Stack<Character> lStack = new Stack<Character>();
    Stack<Character> sStack = new Stack<Character>();

    int count = 0;

    for (int index = 0; index < arr.length; index++) {
      if (arr[index] >= '0' && arr[index] <= '9') {
        count++;
        continue;
      }

      if (arr[index] == 'L') lStack.push(arr[index]);
      if (arr[index] == 'S') sStack.push(arr[index]);

      if (arr[index] == 'R') {
        if (!lStack.isEmpty()) {
          char top = lStack.pop();
          if (top == 'L') count++;
        } else break;
      }

      if (arr[index] == 'K') {
        if (!sStack.isEmpty()) {
          char top = sStack.pop();
          if (top == 'S') count++;
        } else break;
      }
    }

    System.out.print(count);
  }
}
