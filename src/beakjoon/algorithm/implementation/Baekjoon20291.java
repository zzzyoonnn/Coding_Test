package beakjoon.algorithm.implementation;
/*
문제
- 친구로부터 노트북을 중고로 산 스브러스는 노트북을 켜자마자 경악할 수밖에 없었다. 
  바탕화면에 온갖 파일들이 정리도 안 된 채 가득했기 때문이다. 
  그리고 화면의 구석에서 친구의 메시지를 확인할 수 있었다.
    바탕화면의 파일들에는 값진 보물에 대한 정보가 들어 있어. 
    하나라도 지우게 된다면 보물은 물론이고 다시는 노트북을 쓸 수 없게 될 거야. 
    파일들을 잘 분석해서 보물의 주인공이 될 수 있길 바랄게. 
    힌트는 “확장자”야.
  화가 났던 스브러스는 보물 이야기에 금세 화가 풀렸고 보물의 정보를 알아내려고 애썼다. 
  하지만 파일이 너무 많은 탓에 이내 포기했고 보물의 절반을 보상으로 파일의 정리를 요청해왔다. 
  스브러스의 요청은 다음과 같다.
    파일을 확장자 별로 정리해서 몇 개씩 있는지 알려줘
    보기 편하게 확장자들을 사전 순으로 정렬해 줘
  그럼 보물의 절반을 얻어내기 위해 얼른 스브러스의 노트북 파일 정리를 해줄 프로그램을 만들자!
입력
- 첫째 줄에 바탕화면에 있는 파일의 개수 N이 주어진다. (1<=N<=50,000)
  둘째 줄부터 N개 줄에 바탕화면에 있는 파일의 이름이 주어진다. 
  파일의 이름은 알파벳 소문자와 점(.)으로만 구성되어 있다. 
  점은 정확히 한 번 등장하며, 파일 이름의 첫 글자 또는 마지막 글자로 오지 않는다. 
  각 파일의 이름의 길이는 최소 3, 최대 100이다.
출력
- 확장자의 이름과 그 확장자 파일의 개수를 한 줄에 하나씩 출력한다. 
  확장자가 여러 개 있는 경우 확장자 이름의 사전순으로 출력한다.
ex 1)
입력          출력
- 8           - icpc 2
  sbrus.txt     spc 2
  spc.spc       txt 3
  acm.icpc      world 1
  korea.icpc
  sample.txt
  hello.world
  sogang.spc
  example.txt
 */
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Baekjoon20291 {
  public static void main(String[] agrs) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    // Map, TreeMap은 데이터를 키-값 쌍으로 관리하는 자료구조 제공
    // TreeMap은 키를 기준으로 정렬된 상태 유지하며 확장자와 해당 확장자의 빈도를 저장하기 위한 Map 생성
    Map<String, Integer> map = new TreeMap<>();

    // 확장자 빈도 계산
    for (int i = 0; i < n; i++) {
      String s = sc.next();
      String exist = s.substring(s.indexOf(".") + 1);   // . 이후 끝까지 추출
      if (map.containsKey(exist)) { // containsKey : 주어진 키가 맵 내에 존재하는지 여부를 판단하는데 사용
        int tmp = map.get(exist);
        map.replace(exist, ++tmp);
      } else {
        map.put(exist, 1);
      }
    }

    for (String key : map.keySet()) {
      // 현재 순회 중인 키인 key와 이 키에 매핑된 값을 map.get(key)로 출력 -> 키와 값의 쌍을 출력
      System.out.println(key + " " + map.get(key));
    }
  }
}