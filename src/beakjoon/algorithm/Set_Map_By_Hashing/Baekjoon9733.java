package beakjoon.algorithm.Set_Map_By_Hashing;
/*
문제
- 꿀벌이 하는 일은 다음과 같이 분류할 수 있다.
  휴식(Re), 순찰(Pt), 방청소(Cc), 꽃가루 먹기(Ea), 새끼 돌보기(Tb), 벌집 짓기와 관리(Cm), 외부 활동(Ex)
  한 꿀벌이 1시간 동안 한 일이 주어졌을 때, 각각을 몇 번 했고, 비율이 어떻게 되는지 구하는 프로그램을 작성하시오.
입력
- 입력은 꿀벌이 한 일이 공백과 줄바꿈으로 구분되어서 주어진다. 
  최대 24개의 일을 한다.
출력
- 각각의 일을 한 횟수와 비율을 공백으로 구분하여 출력한다. 
  출력은 {Re,Pt,Cc,Ea,Tb,Cm,Ex} 순서대로 하며, 비율은 소수점 둘째 자리까지 출력한다. 
  주어진 목록에 없는 일은 출력하지 않는다.
  입력의 마지막 줄에는 "Total <total> 1.00"을 출력하며, <total>은 꿀벌이 한 일의 개수이다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon9733 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    String[] work = {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"};

    Map<String, Integer> map = new HashMap<>();

    for (String s : work) {
      map.put(s, 0);
    }

    String str;
    double total = 0;

    while ((str = br.readLine()) != null) {
      String[] arr = str.split(" ");
      total += arr.length;

      for (int i = 0; i < arr.length; i++) {
        if (map.containsKey(arr[i])) {
          map.put(arr[i], map.get(arr[i]) + 1);
        }
      }
    }

    for (int i = 0; i < work.length; i++) {
      System.out.printf("%s %d %.2f\n", work[i], map.get(work[i]), map.get(work[i])/total);
    }

    System.out.printf("%s %d %.2f\n","Total", (int)total, 1.00);
  }
}