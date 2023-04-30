package beakjoon.algorithm.arithmetic;
/*
문제
- 동수는 제과점에 과자를 사러 가는데 현재 가진 돈이 모자랄 경우 부모님께 모자란 돈을 받으려고 한다. 
  과자 한 개의 가격이 K, 사려고 하는 과자의 개수가 N이고, 
  현재 가진 돈의 액수를 M이라 할 때 여러분은 동수가 부모님께 받아야 하는 모자란 돈을 계산하려고 한다. 
  예를 들어, 
  과자 한 개의 가격이 30원, 사려고 하는 과자의 개수가 4개, 현재 동수가 가진 돈이 100원이라 할 때, 
  동수가 부모님께 받아야 하는 돈은 20원이다. 
  과자 한 개의 가격이 250원, 사려고 하는 과자의 개수가 2개, 현재 동수가 가진 돈이 140원이라 할 때, 
  동수가 부모님께 받아야 하는 돈은 360원이다. 
  과자 한 개의 가격이 20원, 사려고 하는 과자의 개수가 6개, 현재 동수가 가진 돈이 120원이라 할 때 
  동수가 부모님께 받아야 하는 돈은 0원이다. 
  과자 한 개의 가격이 20원, 사려고 하는 과자의 개수가 10개, 현재 동수가 가진 돈이 320원이라 할 때 
  동수가 부모님께 받아야 하는 돈은 역시 0원이다. 
  과자 한 개의 가격, 사려고 하는 과자의 개수와 동수가 현재 가진 돈의 액수가 주어질 때 
  동수가 부모님께 받아야 하는 돈의 액수를 출력하는 프로그램을 작성하시오. 
입력
- 첫 번째 줄에는 과자 한 개의 가격 K, 사려고 하는 과자의 개수 N, 현재 동수가 가진 돈 M이 각각 공백을 사이에 두고 주어진다. 
  단, K, N은 1,000 이하의 양의 정수이고, M은 10만 이하의 양의 정수이다. (1 ≤ K, N ≤ 1,000, 1 ≤ M ≤ 100,000이다.) 
출력
- 첫 줄에 동수가 부모님께 받아야 하는 돈의 액수를 출력한다.
ex 1)
입력              출력
- 300 4 1000      - 200
ex 2)
입력              출력
- 250 2 140       - 360
ex 3)
입력              출력
- 20 6 120        - 0
ex 4)
입력              출력
- 20 10 320      - 0
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10156 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int sum = a * b;

    if (sum > c) System.out.println(sum - c);
    else System.out.println(0);
  }
}
