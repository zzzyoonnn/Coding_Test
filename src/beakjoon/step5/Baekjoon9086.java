package beakjoon.step5;
/*
문제
- 문자열을 입력으로 주면 문자열의 첫 글자와 마지막 글자를 출력하는 프로그램을 작성하시오.
입력
- 입력의 첫 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 10)가 주어진다.
  각 테스트 케이스는 한 줄에 하나의 문자열이 주어진다.
  문자열은 알파벳 A~Z 대문자로 이루어지며 
  알파벳 사이에 공백은 없으며 문자열의 길이는 1000보다 작다.
출력
- 각 테스트 케이스에 대해서 주어진 문자열의 첫 글자와 마지막 글자를 연속하여 출력한다.
ex 1)
입력				출력
- 3					- AE
  ACDKJFOWIEGHE		  00
  O					  AB
  AB
*/        
import java.io.*;
import java.util.*;

public class Baekjoon9086 {
	// BufferedReader를 사용할 경우 예외처리 즉, throws IOException을 해야 함
	public static void main(String[] args) throws IOException {
		// BufferedReader를 이용하여 값 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        // 테스트 케이스 갯수
        // readLine() : 입력 값으로 들어온 데이터를 한 줄로 읽어서 String으로 바꾸는 메소드
        //				무조건 한줄만 읽음
        //	Enter키 사용 시 입력 종료
        int n = Integer.parseInt(br.readLine());
        
        // StringBuilder 객체 선언
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
        	String s = br.readLine();
        	// append : 문자열을 StringBuilder 객체의 끝에 추가
        	sb.append(s.charAt(0));
        	sb.append(s.charAt(s.length() - 1) + "\n");
        }
        System.out.println(sb);
        br.close();
        
	}
}
