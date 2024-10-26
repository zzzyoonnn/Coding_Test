package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 개인정보수집유효기간 {
  private static StringTokenizer st;
  public static int[] solution(String today, String[] terms, String[] privacies) {
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < terms.length; i++) {
      st = new StringTokenizer(terms[i]);

      String grade = st.nextToken();
      int period = Integer.parseInt(st.nextToken());

      map.put(grade, period);
    }

    st = new StringTokenizer(today, ".");
    int todayYear = Integer.parseInt(st.nextToken());
    int todayMonth = Integer.parseInt(st.nextToken());
    int todayDay = Integer.parseInt(st.nextToken());

    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < privacies.length; i++) {
      st = new StringTokenizer(privacies[i]);

      String s = st.nextToken();
      String type = st.nextToken();
      st = new StringTokenizer(s, ".");

      int year = Integer.parseInt(st.nextToken());
      int month = Integer.parseInt(st.nextToken()) + map.get(type);

      if (month > 12) {
        year += month / 12;
        month = month % 12;
      }

      if (month == 0) {
        year--;
        month = 12;
      }

      int day = Integer.parseInt(st.nextToken());

      if (year < todayYear) list.add(i + 1);
      else if (year == todayYear && month < todayMonth) list.add(i + 1);
      else if (year == todayYear && month == todayMonth && day <= todayDay) list.add(i + 1);
    }

    int[] answer = list.stream().mapToInt(i -> i).toArray();

    return answer;
  }

  public static void main(String[] args) {
//    String today = "2022.05.19";
//    String[] terms = {"A 6", "B 12", "C 3"};
//    String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

//    String today = "2020.01.01";
//    String[] terms = {"Z 3", "D 5"};
//    String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

    String today = "2009.12.28";
    String[] terms = {"A 13"};
    String[] privacies = {"2008.11.03 A"};

    System.out.println(Arrays.toString(solution(today, terms, privacies)));
  }
}
