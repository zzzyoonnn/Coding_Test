package beakjoon.algorithm.string;
/*
문제
- 알파벳 대소문자로 된 단어가 주어지면, 
  이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 
  단, 대문자와 소문자를 구분하지 않는다.
입력
- 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 
  주어지는 단어의 길이는 1,000,000을 넘지 않는다.
출력
- 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 
  단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
ex 1)
입력			출력
- Mississipi	- ?
ex 2)
입력			출력
- zZa			- Z
ex 3)
입력			출력
- z				- Z
ex 4)
입력			출력
- baaa			- A
*/
import java.io.*;
import java.util.*;

public class Baekjoon1157 {
	public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] arr = new int[26];	// 알파벳의 갯수 : 26
    	String st = br.readLine();	// 문자열 배열 읽음
    	st = st.toUpperCase();    		
    	
        for (int i = 0; i < st.length(); i++) { // 문자열을 순회하면서 각 알파벳의 빈도수 계산
            char ch = st.charAt(i);
            arr[ch - 'A']++;
        }
    	
    	int max = -1;
    	char ch = 0;
    	
    	for (int i = 0; i < arr.length; i++) {	// 가장 많이 나온 문자 찾기
    		if (arr[i] > max) {
    			max = arr[i];
    			ch = (char) (i + 'A');
    		} else if (arr[i] == max) {
    			ch = '?';
    		}
    	}
    	System.out.println(ch);
    }
}
