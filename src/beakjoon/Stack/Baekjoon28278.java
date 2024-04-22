package beakjoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon28278 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack();
    StringBuilder sb = new StringBuilder();

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      int num = Integer.parseInt(st.nextToken());

      switch (num) {
        case 1 :
          int temp = Integer.parseInt(st.nextToken());
          stack.push(temp);
          break;
        case 2 :
          if (stack.isEmpty()) sb.append(-1).append('\n');
          else {
            sb.append(stack.pop()).append('\n');
          }
          break;
        case 3 :
          sb.append(stack.size()).append('\n');
          break;
        case 4 :
          if (stack.isEmpty()) sb.append(1).append('\n');
          else sb.append(0).append('\n');
          break;
        case 5 :
          if (stack.isEmpty()) sb.append(-1).append('\n');
          else sb.append(stack.peek()).append('\n');
      }
    }
    System.out.println(sb);
  }
}
