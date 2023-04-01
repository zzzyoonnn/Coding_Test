package beakjoon.algorithm.string;
/*
문제
- N개의 숫자가 공백 없이 쓰여있다.
  이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다.
  둘째 줄에 숫자 N개가 공백없이 주어진다.
출력
- 입력으로 주어진 숫자 N개의 합을 출력한다.
ex 1)
입력		출력
- 1			- 1
  1
ex 2)
입력		출력
- 5			- 15
  54321
ex 3)
입력		출력
- 25		- 7
  7000000000000000000000000
ex 4)
입력		출력
- 11		- 46
  10987654321
*/
import java.io.*;
import java.util.*;

public class Baekjoon11720 {
	public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 띄어쓰기 기준으로 토큰화
        int n = Integer.parseInt(br.readLine());
        
        String[] arr = br.readLine().split("");
        
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
        	sum += Integer.parseInt(arr[i]);
        }
        
        System.out.println(sum);
        
	}
}
