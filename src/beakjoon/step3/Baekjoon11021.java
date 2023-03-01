package beakjoon.step3;
/*
문제
- 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
  각 테스트 케이스는 한 줄로 이루어져 있으며,
  각 줄에 A와 B가 주어진다. (0 < A, B < 10)
출력
- 각 테스트 케이스마다 "Case #x: "를 출력한 다음, A+B를 출력한다.
  테스트 케이스 번호는 1부터 시작한다.
ex 1)
입력			출력
- 5				- Case #1: 2
  1 1			  Case #2: 5
  2 3			  Case #3: 7
  3 4			  Case #4: 17
  9 8			  Case #5: 7
  5 2
*/        
import java.io.*;
import java.util.*;

public class Baekjoon11021 {
	// BufferedReader를 사용할 경우 예외처리 즉, throws IOException을 해야 함
	public static void main(String[] args) throws IOException {
		// BufferedReader를 이용하여 값 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // print 관련 메서드를 사용하기 위해 BufferedReader 대신 PrintWriter를 사용
        // BufferedOutputStream은 BufferedWriter와 비슷한 역할(출력 내용을 버퍼링, 버터가 찰 때마다 출력으로 내보냄)
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        
        // 테스트 케이스 갯수
        // readLine() : 입력 값으로 들어온 데이터를 한 줄로 읽어서 String으로 바꾸는 메소드
        //				무조건 한줄만 읽음
        //	Enter키 사용 시 입력 종료
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
        	// 띄어쓰기를 기준으로 입력받은 값들을 분리하고 Enter키 사용 시 입력 종료
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	// StringTokenizer로 분리된 토큰들을 하나씩 읽으면서 a, b에 입력
        	// String으로 읽었으니 Integer로 바꾸기 위해 parseInt 수행
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	pw.printf("Case #%d: %d\n", i + 1, a + b);
        }
        // BufferedReader를 다 사용했으니, close()를 통해 InputStream을 닫고 자원 해제
        br.close();
        
        pw.flush();
        pw.close();
	}
}
