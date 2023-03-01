package beakjoon.step4;
/*
문제
- 총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 정수의 개수 N(1 ≤ N ≤ 100)이 주어진다.
  둘째 줄에는 정수가 공백으로 구분되어져있다. 
  셋째 줄에는 찾으려고 하는 정수 v가 주어진다. 
  입력으로 주어지는 정수와 v는 -100보다 크거나 같으며, 100보다 작거나 같다.
출력
- 첫째 줄에 입력으로 주어진 N개의 정수 중에 v가 몇 개인지 출력한다.
ex 1)
입력						출력
- 11						- 3
  1 4 1 2 4 2 4 2 3 4 4
  2
ex 1)
입력						출력
- 11						- 0
  1 4 1 2 4 2 4 2 3 4 4
  5
*/
import java.io.*;
import java.util.*;

public class Baekjoon10807 {
	public static void main(String[] args) throws IOException {
		// BufferedReader를 이용하여 값 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 정수의 개수
        // Enter로 읽어들임
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        // 주어진 정수
        // Enter 쳤을 시 값이 입력 됨
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 입력된 값들을 arr에 넣음
        // 띄어쓰기를 기준으로 각 배열에 값이 들어간다.
        for (int i = 0; i < arr.length; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 찾으려는 정수
        int findNum = Integer.parseInt(br.readLine());
        int count = 0;
        
        // arr[0]부터 끝까지 확인해보며 findNum과 같은 수가 있을 시
        // count가 1씩 증가
        for (int j = 0; j < arr.length; j++) {
        	if (arr[j] == findNum) {
        		count++;
        	}
        }
        System.out.println(count);
    }
}
