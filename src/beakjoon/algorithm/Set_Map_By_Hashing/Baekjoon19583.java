package beakjoon.algorithm.Set_Map_By_Hashing;
/*
문제
- 보영이는 알고리즘 동아리 HI-ARC를 운영하고 있다.
  보영이와 운영진 일동은 20년도에 입학하는 신입생들을 맞이하기 위해 열심히 준비를 해왔으나, 
  전염병의 유행이 악화된 나머지 정부에서는 “사회적 거리두기”를 선언했고 
  그에 따라 학교에서는 교내 모든 동아리에 오프라인 모임을 자제하라는 공지를 하기에 이르렀다. 
  오프라인에서 모임을 자제하라는 권고가 나온 어려운 상황에도 불구하고, 
  보영이는 기지를 발휘하여 개강총회를 미튜브 스트리밍으로 대체하는 결정을 하게 된다.
  하지만, 미튜브 스트리밍으로 개강총회를 하게 될 경우, 아래와 같은 문제가 있었다.
    1. 누가 개강총회에 왔는지 알 수 없다.
    2. 누가 개강총회 자리에 끝까지 남아있었는지 알 수 없다.
    3. 어떤 사람이 개강총회 스트리밍을 단순히 틀어놓기만 했는지 알 수 없다.
  이런 문제를 해결하기 위해서, 다음과 같이 출석부를 관리하기로 결심했다.
    1. 개강총회를 시작하기 전에, 학회원의 입장 확인 여부를 확인한다. 
       학회원의 입장 여부는 개강총회가 시작한 시간 이전에 대화를 한 적이 있는 학회원의 닉네임을 보고 체크한다. 
        개강총회를 시작하자마자 채팅 기록을 남긴 학회원도 제 시간에 입장이 확인된 것으로 간주한다.
    2. 개강총회를 끝내고 나서, 스트리밍을 끝낼 때까지 학회원의 퇴장 확인 여부를 확인한다. 
       학회원의 퇴장 여부는 개강총회가 끝나고 스트리밍이 끝날 때까지 대화를 한 적이 있는 학회원의 닉네임을 보고 체크한다. 
       개강총회가 끝나자마자 채팅 기록을 남겼거나, 
       개강총회 스트리밍이 끝나자마자 채팅 기록을 남긴 학회원도 제 시간에 퇴장이 확인된 것으로 간주한다.  
  단, 00:00부터는 개강총회를 시작하기 전의 대기 시간이며, 
  개강총회 스트리밍 끝난 시간 이후로 남겨져 있는 채팅 기록은 다른 스트리밍 영상의 채팅 기록으로 간주한다.
  이 때, 입장부터 퇴장까지 모두 확인된 학회원은 전부 몇 명인가?
입력
- 첫번째 줄에는 개강총회를 시작한 시간 S, 개강총회를 끝낸 시간 E, 개강총회 스트리밍을 끝낸 시간 Q가 주어진다. (00:00 ≤ S < E < Q ≤ 23:59)
  각 시간은 HH:MM의 형식으로 주어진다.
  두번째 줄부터는 HI-ARC에서 방송하는 스트리밍 영상의 채팅 기록들이 시간순으로 주어지는데, (시간) (학회원 닉네임)의 형태로 주어진다. 
  학회원의 닉네임은 알파벳 대소문자와 숫자, 그리고 특수 기호(., _, -)로만 구성된 문자열이며 최대 20글자이다.
  모든 채팅 기록은 개강총회가 일어난 날에 발생한 채팅 기록이다. 
  즉 00:00~23:59의 시간만 주어진다. 
  채팅 기록은 10만 줄을 넘지 않는다.
출력
- 출석이 확인된 학회원의 인원 수를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon19583 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String start = st.nextToken();      // 개강 총회를 시작한 시간
    String end = st.nextToken();        // 개강 총회를 종료한 시간
    String quit = st.nextToken();       // 개강 스트리밍을 종료한 시간

    HashSet<String> set = new HashSet<>();

    int count = 0;
    String time;            // 채팅 시간
    String nickname;        // 채팅자
    String time_line;       // 채팅 기록
    while ((time_line = br.readLine()) != null && !time_line.isEmpty()) {
      st = new StringTokenizer(time_line);

      time = st.nextToken();
      nickname = st.nextToken();


      if (time.compareTo(start) <= 0) {     // 개강총회 시작 직전까지 대화를 했다면 set에 닉네임 추가
        set.add(nickname);
      }

      if (time.compareTo(end) >= 0 && time.compareTo(quit) <= 0) {  // 개강총회 끝난 직후부터 개강 스트리밍 종료 직전까지
        if (set.contains(nickname)) {   // 개강총회 시작 직전까지 대화를 했었다면
          count++;                      // 확인된 학회원이므로 확인 횟수 추가
          set.remove(nickname);         // 여러번 말 할 수 있으므로 set에서 닉네임 삭제
        }
      }
    }
    System.out.println(count);
  }
}
