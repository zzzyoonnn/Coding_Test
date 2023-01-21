package beakjoon.step1;
/*
문제
- 두 정수 A와 B를 입력받은 다음, A-B를 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)
출력
- 첫째 줄에 A-B를 출력한다.
ex 1)
입력          출력
- 3 2        - 1
*/
import java.io.*;
import java.util.*;

public class Beakjoon1001 {
	public static void main(String[] args) throws IOException{
        int a, b;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        
        System.out.println(a - b);
    }
}
