package beakjoon.algorithm.implementation;
/*
문제
- You know a family with three children. 
  Their ages form an arithmetic sequence: 
    the difference in ages between the middle child and youngest child is the same 
    as the difference in ages between the oldest child and the middle child. 
  For example, 
  their ages could be 5, 10 and 15, since both adjacent pairs have a difference of 5 years.
  Given the ages of the youngest and middle children, what is the age of the oldest child?
입력
- The input consists of two integers, each on a separate line. 
  The first line is the age Y of the youngest child (0 ≤ Y ≤ 50). 
  The second line is the age M of the middle child (Y ≤ M ≤ 50).
출력
- The output will be the age of the oldest child.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon6749 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int youngest = Integer.parseInt(br.readLine());
    int middle = Integer.parseInt(br.readLine());

    System.out.println(middle + (middle - youngest));
  }
}
