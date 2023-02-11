package beakjoon.individual;
/*
문제
- 모든 자리가 1로만 이루어져있는 두 자연수 A와 B가 주어진다.
  이때, A와 B의 최대 공약수를 구하는 프로그램을 작성하시오.
  예를 들어, A가 111이고,
  B가 1111인 경우에 A와 B의 최대공약수는 1이고,
  A가 111이고, B가 111111인 경우에는 최대공약수가 111이다.
입력
- 첫째 줄에 두 자연수 A와 B를 이루는 1의 개수가 주어진다. 입력되는 수는 263보다 작은 자연수이다.
출력
- 첫째 줄에 A와 B의 최대공약수를 출력한다. 정답은 천만 자리를 넘지 않는다.
ex 1)
입력		출력
- 3 4		- 1
ex 1)
입력		출력
- 3 6		- 111
ex 1)
입력										출력
- 500000000000000000 500000000000000002		- 11
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon1850 {
	
	public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());	// String arr = br.readLine();
        															// String[] numbers = arr.split(" ");
        
        long a = Long.parseLong(st.nextToken());	// Long.parseLong(numbers[0]);
        long b = Long.parseLong(st.nextToken());	// Long.parseLong(numbers[1]);
        long gcd = getGCD(Math.max(a, b), Math.min(a, b));
        
        for (long i = 0; i < gcd; i++) {
        	bw.write("1");	// 1의 개수의 최대 공약수가 결과 수의 1의 개수
        }					// 따라서 A와 B의 GCD를 구한 후 이 수만큼의 1을 출력하면 됨
        
        bw.flush();	// 버퍼에 데이터가 가득 차 있건 아니건, 버퍼에서 강제로 밀어내도록 하는 메서드
        bw.close();	// close()를 호출하여 스트림을 닫으면 그 스트림을 다시 이용하여 파일에 쓰는 것이 불가능
        
    }
	
	public static long getGCD(long a, long b) {
		if (a % b == 0) return b;	// 최대공약수는 두 개의 a, b에 대해서 b와 a % b의 값이 최대공약수와 같으므로 리턴값으로 재귀 사용
		return getGCD(b, a % b);
	}
}
