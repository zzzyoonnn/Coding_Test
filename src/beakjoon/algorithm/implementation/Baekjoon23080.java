package beakjoon.algorithm.implementation;
/*
문제
- 고대 그리스의 옛 나라인 스파르타의 군대에서는 비밀메시지를 전하는 방법으로 스키테일 암호를 사용했다.
  스키테일 암호는 스키테일(Scytale)이라고 하는 정해진 굵기의 원통형 막대에 
  종이로 된 리본을 위에서 아래로 감은 다음 옆으로 메시지를 적는 방식으로 메세지를 암호화한다. 
  리본을 풀어 길게 늘어선 글을 읽으면 무슨 뜻인지 전혀 알 수 없지만, 
  암호화할 때와 같은 굵기의 막대에 감으면 내용을 알 수 있게 된다.
  다음은 굵기 3의 막대를 사용하여 "iupc" 라는 문자열을 암호화하는 예시이다.
  굵기가 X인 막대에 리본을 감고 세로로 글자 X개를 적으면 막대를 한바퀴 돌아오게 된다. 
  이 막대는 굵기가 3이므로, 세로로 3글자를 적으면 막대를 한바퀴 돌아올 것이다.
  암호화하는 문자열을 리본의 가장 왼쪽 끝 부분을 포함하는 가로 한 줄만 사용하여 쓰고, 남은 공간은 아무 문자로나 채운다.
  마지막으로 막대에서 리본을 풀면 암호화가 완료된다.
  스키테일 암호로 암호화한 문자열과 막대의 굵기가 주어진다. 
  암호를 해독해 보자!
입력
- 첫 번째 줄에 막대의 굵기 K가 주어진다. 
  두 번째 줄에 알파벳 소문자만으로 구성된 암호문 S가 주어진다.
출력
- 첫 번째 줄에 암호문을 해독한 결과를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon23080 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(br.readLine());    // 막대의 굵기
    String s = br.readLine();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      if (i % k == 0) sb.append(s.charAt(i));
    }

    System.out.println(sb);
  }
}
