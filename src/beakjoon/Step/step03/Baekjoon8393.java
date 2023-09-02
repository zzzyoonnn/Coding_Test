package beakjoon.step03;
/*
문제
- n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.
출력
- 1부터 n까지 합을 출력한다.
ex 1)
입력
- 3
출력
- 6
*/
import java.io.*;
import java.util.*;

public class Baekjoon8393 {
	public static void main(String[] args) throws IOException {
        int a;
        int sum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        a = Integer.parseInt(br.readLine());
        
        for(int i = 1; i < a + 1; i++) {
        	sum += i;
        }
        System.out.println(sum);
    }
}
