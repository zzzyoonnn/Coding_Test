package beakjoon.algorithm.Set_Map_By_Hashing;
/*
문제
- 하이비는 오늘도 주식 시장에 돈을 투자했다가 돈을 잃고 말았다. 
  매일 돈을 잃고만 있는 하이비를 보며 안타까워하던 유틸은 
  주식 시뮬레이션 프로그램이 담긴 USB를 전달하며 투자 연습을 해보라고 제안했다.
  하이비는 집에 도착해 컴퓨터에 USB를 꽂았다. 주식 시뮬레이션 프로그램을 실행해 보니 7가지 메뉴가 나타났다. 
  각 메뉴는 다음과 같다.
    1 A B: 회사 A의 주식을 B주 산다. 현재 보유하고 있는 현금으로 회사 A의 주식을 B주 살 수 없다면 한 주도 사지 않는다.
    2 A B: 회사 A의 주식을 B주 판다. 현재 보유하고 있는 회사 A의 주식이 SA주일 때, SA = 0이라면 아무 일도 일어나지 않는다. 
           B >= SA라면 SA주를 모두 판다.
    3 A C: 회사 A의 주가가 C원 올랐다. C < 0인 경우 주가가 |C|원 떨어진 것이다.
    4 D C: D번 그룹에 속하는 회사들의 주가가 C원 올랐다. C < 0인 경우 주가가 |C|원 떨어진 것이다.
    5 D E: D번 그룹에 속하는 회사들의 주가가 E% 올랐다. E < 0인 경우 주가가 |E|% 떨어진 것이다.
    6: 현재 하이비가 보유하고 있는 현금을 출력한다.
    7: 현재 하이비가 보유하고 있는 주식들을 전부 팔았을 때, 보유하고 있는 현금의 총합을 출력한다.
  또한 프로그램 매뉴얼에 따르면 다음과 같은 특징이 있다.
    처음에 하이비가 보유하고 있는 주식은 없다.
    회사 이름은 대소문자를 구별한다.
    주식 시뮬레이션 프로그램에서 주식을 사거나 팔 때의 단위는 10 원이다. 
    5번 메뉴의 경우 변동률에 따라 회사들의 주가를 반영하고 난 뒤 일의 자리에서 버림한다.
    모든 시점에 대해 각 회사의 주가 Pi는 0 <= Pi <= 2 * 10^9 (1 <= i <= N) 임이 보장된다.
    모든 시점에 대해 하이비가 보유하고 있는 주식들을 전부 팔았을 때, 보유하고 있는 현금의 총합이 2 * 10^12 원을 초과하지 않음이 보장된다.
    1번, 2번, 3번 메뉴 입력에서 A는 주식 시장에 상장한 회사임이 보장된다.
    4번 또는 5번 메뉴 입력에서 D번 그룹에 속하는 회사가 하나 이상 존재한다.
    6번 또는 7번 메뉴 입력은 최소 한 번 이상 주어진다.
  하이비는 다양한 데이터를 넣어보면서 주식 시뮬레이션을 해보기 시작했다. 
  그런데 한 가지 문제가 있었다. 
  6번 또는 7번 메뉴를 선택하면 현금이 출력되어야 하는데, 프로그램을 잘못 구현했는지 전부 ???로만 뜨는 것이었다.
  하이비는 유틸에게 전화를 걸어 프로그램에 문제가 있다고 이야기했다. 
  그러자 유틸은 입력한 데이터를 전부 주면, 6번 또는 7번 메뉴를 선택했을 때의 결과를 알려주겠다고 했다. 
  하지만 유틸은 지금 다른 프로그램을 만들고 있느라 너무 바빠 여러분에게 이 일을 대신 처리해 줄 수 있겠냐고 부탁했다. 
  유틸을 도와주도록 하자!
입력
- 첫 번째 줄에 주식 시장에 상장한 회사의 개수 N, 하이비가 보유하고 있는 현금 M, 메뉴 입력의 개수 Q가 공백으로 구분되어 주어진다. 
  (1 <= N <= 100; 10^6 <= M <= 10^7; 1 <= Q <= 500) 
  두 번째 줄부터 N개의 줄에 걸쳐 회사가 속하는 그룹의 번호 G, 회사 이름 H, 
  시뮬레이션 시작 시점에서 회사 1주의 가격 P가 공백으로 구분되어 주어진다. 
  회사 이름은 영어 알파벳 대소문자로 구성된 길이 30 이하의 문자열이며, 같은 회사 이름이 두 번 이상 등장하지 않는다. 
  (1 <= G <= 100; 0 <= P <= 30,000; P는 10의 배수) 
  그다음 줄부터 Q개의 줄에 걸쳐 메뉴 입력이 주어진다. (1 <= B <= 100; -5,000 <= C <= 5,000; 1 <= D <= 100; -30 <= E <= 30; C는 10의 배수) 
  입력에서 주어지는 모든 수는 정수이다.
출력
- 6번, 7번 메뉴 입력의 결과를 한 줄에 하나씩 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Baekjoon31001 {
  static int n;
  static long m;

  static HashMap<String, Integer> stock = new HashMap<>();      // Key : 회사 이름, Value : 주가
  public static ArrayList<ArrayList<String>> group = new ArrayList<>();         // Key : 회사 이름, Value : 그룹 이름
  static HashMap<String, Integer> owned = new HashMap<>();      // 보유하고 있는 주식, Key : 회사 이름, Value : 보유 주식 수

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());       // 주식 시장에 상장한 회사의 개수
    m = Integer.parseInt(st.nextToken());       // 하이비가 보유하고 있는 현금
    int q = Integer.parseInt(st.nextToken());       // 메뉴 입력의 개수

    for (int i = 0; i <= 100; i++) group.add(new ArrayList<>());

    int g, p;
    String h;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      g = Integer.parseInt(st.nextToken());     // 그룹의 번호
      h = st.nextToken();                       // 회사 이름
      p = Integer.parseInt(st.nextToken());     // 초기 주가

      stock.put(h, p);
      group.get(g).add(h);
    }

    int menu;
    String a;
    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      menu = Integer.parseInt(st.nextToken());

      switch(menu) {
        case 1:
          buy(st.nextToken(), Integer.parseInt(st.nextToken()));
          break;
        case 2:
          sell(st.nextToken(), Integer.parseInt(st.nextToken()));
          break;
        case 3:
          up(st.nextToken(), Integer.parseInt(st.nextToken()));
          break;
        case 4:
          groupPriceUp(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
          break;
        case 5:
          groupPercentUp(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
          break;
        case 6:
          System.out.println(m);
          break;
        case 7:
          System.out.println(allSell());
          break;
      }
    }
  }

  private static void buy(String name, int num) {
    long price = stock.get(name) * (long)num;

    if (m < price) {    // 현재 보유하고 있는 현금으로 name회사의 주식을 num주 살 수 없다면
      return;           // 매수 X
    }

    m -= price;         // 매수
    owned.put(name, owned.getOrDefault(name, 0) + num);     // 보유 주식 수 갱신
  }

  private static void sell(String name, int num) {
    long price = stock.get(name);   // name회사의 주가

    if (!owned.containsKey(name)) {     // name회사의 주식을 보유하지 않음
      return;
    }

    int haveStock = owned.get(name);

    if (num >= haveStock) {         // 보유 주식 수보다 더 팔고 싶으면
      m += haveStock * price;
      owned.put(name, 0);           // 전량 매도

    } else {        // num주 매도
      m += num * price;
      owned.put(name, haveStock - num);
    }
  }

  private static void up(String name, int value) {    // name회사의 주가 value원 상승
    if (!stock.containsKey(name)) return;

    stock.replace(name, stock.get(name) + value);
  }

  private static void groupPriceUp(int groupNum, int value) {       // groupNum에 속하는 회사들의 주가 value원 상승
    for (String name : group.get(groupNum)) {
      stock.put(name, stock.get(name) + value);
    }
  }

  private static void groupPercentUp(int groupNum, int per) {       // // groupNum에 속하는 회사들의 주가 per% 상승
    for (String name : group.get(groupNum)) {
      double price = stock.get(name);
      double temp = stock.get(name) * ((Math.abs(per) / 100.0));

      if (per > 0) price += temp;   // 주가 상승
      else price -= temp;           // 주가 하락

      price = ((int)price / 10) * 10;

      stock.put(name, (int)price);
    }
  }

  private static long allSell() {
    Iterator<String> own = owned.keySet().iterator();       // 보유한 주식 탐색
    long sum = m;

    while (owned != null && own.hasNext()) {
      String name = own.next();
      long price = stock.get(name);

      sum += price * owned.get(name);
    }

    return sum;
  }
}
