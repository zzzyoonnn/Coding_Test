package beakjoon.step12;
/*
문제
- N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
입력
- 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 
  둘째 줄부터 N개의 줄에는 수가 주어진다. 
  이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 
  수는 중복되지 않는다.
출력
- 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
ex 1)
입력		출력
- 5			- 1
  5			  2
  2			  3
  3			  4
  4			  5
  1
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2750 {
	
	public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력받은 문자열을 Integer 데이터타입으로 변환(기본형 String)
        // n 은 테스트 케이스 갯수
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        // Arrys.sort()
        // 자바에서 기본으로 제공되는 메소드
        // 자체 정렬 알고리즘을 구현할 필요 없이 sort() 안에 배열을 넣어주면
        // 자동으로 배열이 정렬되어 나옴
        
        for (int val : arr) {
        	System.out.println(val);
        }
	}
}
