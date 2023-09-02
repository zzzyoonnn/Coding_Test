package beakjoon.step13;
/*
문제
- 정수 B에 0보다 큰 정수인 N을 곱해 정수 A를 만들 수 있다면, A는 B의 배수이다.
  예:
	 10은 5의 배수이다 (5*2 = 10)
	 10은 10의 배수이다(10*1 = 10)
	 6은 1의 배수이다(1*6 = 6)
	 20은 1, 2, 4,5,10,20의 배수이다.
  다른 예:
		  2와 5의 최소공배수는 10이고, 그 이유는 2와 5보다 작은 공배수가 없기 때문이다.
		  10과 20의 최소공배수는 20이다.
		  5와 3의 최소공배수는 15이다.
  당신은 두 수에 대하여 최소공배수를 구하는 프로그램을 작성 하는 것이 목표이다.
입력
- 한 줄에 두 정수 A와 B가 공백으로 분리되어 주어진다.
  50%의 입력 중 A와 B는 1000(103)보다 작다.
  다른 50%의 입력은 1000보다 크고 100000000(108)보다 작다.
  추가: 큰 수 입력에 대하여 변수를 64비트 정수로 선언하시오.
  C/C++에서는 long long int를 사용하고, Java에서는 long을 사용하시오.
출력
- A와 B의 최소공배수를 한 줄에 출력한다.
ex 1)
입력		출력
- 1 1		- 1
ex 1)
입력		출력
- 3 5		- 15
ex 1)
입력		출력
- 1 123		- 123
ex 1)
입력		출력
- 121 199	- 24079
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1934 {
	
	public static void main(String[] agrs) throws IOException {
		// 입력받은 문자열을 Integer 데이터타입으로 변환(기본형 String)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 공백 기준으로 토큰화(한번에 입력받음)
    	StringTokenizer st = new StringTokenizer(br.readLine());
        
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        
        System.out.println(lcm(a, b));
    }
	
	// 최대공약수 GCD(Greatest Common Divisor)
	public static long gcd(long a, long b) {
		if (a % b == 0) return b;	
		// 최대공약수는 두 개의 a, b에 대해서 b와 a % b의 값이 최대공약수와 같으므로 리턴값으로 재귀 사용
		return gcd(b, a % b);
	}
	
	// 최소공배수 LCM(Least Common Multiple)
	public static long lcm(long x, long y) {
		return x * y / gcd(x, y);
	}

}
