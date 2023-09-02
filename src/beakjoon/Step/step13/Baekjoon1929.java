package beakjoon.step13;
/*
문제
- M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) 
  M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
출력
- 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
ex 1)
입력		출력
- 3 16		- 3
			  5
			  7
			  11
			  13
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1929 {
	
	public static void main(String[] agrs) throws IOException {
		// 입력받은 문자열을 Integer 데이터타입으로 변환(기본형 String)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 공백 기준으로 토큰화(한번에 입력받음)
    	StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        // 에라토스테네스 체 방법 이용
        // boolean형 배열 arr을 선언하고 배열의 길이를 b + 1로 함
        boolean arr[] = new boolean[b + 1];
        
        arr[0] = true;	// arr[0]에 true 값 저장
        arr[1] = true;	// arr[1]에 true 값 저장
        
        // 2 ~ b까지 괄호 안의 코드 반복
        for (int i = 2; i <= Math.sqrt(b + 1); i++) {
        	// i * i ~ b까지 괄호 안의 코드 반복
        	for (int j = i * i; j < b + 1; j += i) {
        		// arr[j]에 true 값 저장 <- 에라토스테네스의 체로 i의 배수를 걸려내는 작업
        		arr[j] = true;
        	}
        }
        
        for (int i = a; i < b + 1; i++) {
        	if (arr[i] == false)
        		System.out.println(i);
        }
    }
}
