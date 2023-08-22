package beakjoon.algorithm.mathematics;
/*
문제
- 철수는 화학 시험을 망치고, 애꿎은 화학 선생님에게 복수를하기로 한다.
  철수는 집에서 만든 자동 로봇팔을 선생님의 책상에 숨겨, 
  선생님이 수업을 시작하려 들어온 순간 숨겨놓은 로봇팔을 이용해 선생님을 혼내주려고한다. 
  철수는 선생님이 늘 애용하는 물컵에 시간이 되면 로봇팔이 소금을 잔뜩 집어넣도록 프로그램을 짜려고한다.
  철수는 현재시각과 선생님이 언제 컵을 사용할지 시간을 알고있지만, 
  수 계산에 정말 약해서 로봇팔에 입력해야할 시간 계산을 못한다. 
  철수가 로봇팔에 알맞은 시간을 입력할수 있도록 도와주자.
입력
- 첫째 줄에는 현재 시각이 hh:mm:ss로 주어진다. 
  시간의 경우 0≤h≤23 이며, 분과 초는 각각 0≤m≤59, 0≤s≤59 이다.
  두 번째 줄에는 소금 투하의 시간이 hh:mm:ss로 주어진다.
출력
- 로봇팔이 소금을 투하할때까지 필요한 시간을 hh:mm:ss로 출력한다. 
  이 시간은 1초보다 크거나 같고, 24시간보다 작거나 같다.
ex 1)
입력          출력
- 20:00:00    - 08:00:00
  04:00:00
ex 2)
입력          출력
- 12:34:56    - 02:01:26
  14:36:22
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon13223 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), ":");
    int h = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());
    int currentTime = (h * 3600) + (m * 60) + s;

    st = new StringTokenizer(br.readLine(), ":");
    int hh = Integer.parseInt(st.nextToken());
    int mm = Integer.parseInt(st.nextToken());
    int ss = Integer.parseInt(st.nextToken());
    int saltTime = (hh * 3600) + (mm * 60) + ss;

    int result = saltTime - currentTime;
    if (result <= 0) result += (24 * 3600);

    String hour = String.format("%02d", result / 3600);
    String minute = String.format("%02d", (result % 3600) / 60);
    String second = String.format("%02d", result % 60);

    System.out.println(hour + ":" + minute + ":" + second);
  }
}
