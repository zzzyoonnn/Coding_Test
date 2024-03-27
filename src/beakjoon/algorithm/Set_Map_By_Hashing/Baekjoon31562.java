package beakjoon.algorithm.Set_Map_By_Hashing;
/*
문제
- 윤수와 정환은 「전주 듣고 노래 맞히기」라는 게임을 할 예정이다. 
  「전주 듣고 노래 맞히기」는 주어진 노래의 전주를 듣고 
  먼저 제목을 맞히는 사람이 점수를 얻어 최종적으로 점수가 더 많은 사람이 이기는 게임이다. 
  절대 음감을 가진 윤수는 노래의 첫 네 음만 듣고도 어떤 노래든 바로 맞힐 수 있다. 
  따라서, 정환은 윤수를 이기기 위해 첫 세 음만으로 노래를 맞히게 해주는 프로그램을 만들려고 한다. 
  우선 정환이 알고 있는 노래 제목, 음이름 등을 데이터로 만든 뒤 프로그램을 구현하기 시작했다. 
  예를 들어, 다음은 TwinkleStar(반짝반짝 작은 별)의 악보 중 일부이다.
  위 악보를 박자와 관계없이 음이름으로 표현하면 CCGGAAG가 된다.
  윤수를 이기기 위해서는 이 프로그램이 첫 세 음인 CCG만으로 노래 제목인 TwinkleStar를 출력할 수 있어야 한다. 
  또한, 세상의 모든 노래를 아는 윤수와 다르게 정환은 음을 아는 노래가 N개뿐이다. 
  그래서 프로그램에 N개의 노래의 정보를 저장해 놓을 것이다. 
  만약 저장된 노래 중 입력한 첫 세 음으로 시작하는 노래가 여러 개 있어 
  무슨 노래인지 정확히 알 수 없는 경우 ?를 출력하고, 입력한 첫 세 음에 맞는 저장된 노래가 없을 경우 !를 출력한다.
  정환을 도와서 첫 세 음만으로 본인이 음을 아는 노래를 맞히는 프로그램을 완성하자. 
  이 프로그램은 대문자와 소문자를 구분한다.
입력
- 첫 번째 줄에 정환이 음을 아는 노래의 개수 N, 정환이 맞히기를 시도할 노래의 개수 M이 공백으로 구분되어 주어진다.
  두 번째 줄부터 N개의 줄에 걸쳐 노래 제목의 길이 T, 영어 대소문자로 이루어진 문자열 노래 제목 S, 
  해당 노래에서 처음 등장하는 일곱 개의 음이름 a1, a2, a3, a4, a5, a6, a7이 공백으로 구분되어 주어진다.
  N+2번째 줄부터 M개의 줄에 걸쳐 정환이 맞히기를 시도할 노래의 첫 세 음의 음이름 b1, b2, b3가 공백으로 구분되어 주어진다.
  주어지는 음이름은 각각 C, D, E, F, G, A, B 중 하나이다. 
  같은 제목이 두 번 이상 주어지지 않는다.
출력
- 정환이 맞히기를 시도할 각 노래에 대하여 프로그램에 저장된 노래와 첫 
  세 음이 동일한 노래가 하나만 있다면 해당 노래의 제목을, 두 개 이상이면 ?을, 없다면 !을 한 줄에 하나씩 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon31562 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());   // 음을 아는 노래의 개수
    int m = Integer.parseInt(st.nextToken());   // 맞히길 시도할 노래의 개수

    HashMap<String, String> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      String name = st.nextToken();
      String a = "";
      for (int j = 0; j < 3; j++) {
        a += st.nextToken();
      }

      if (map.containsKey(a)) map.put(a, "?");
      else map.put(a, name);
    }

    for (int i = 0; i < m; i++) {
      String s = br.readLine();
      s = s.replaceAll(" ", "");
      System.out.println(map.get(s) != null ? map.get(s) : "!");
    }
  }
}
