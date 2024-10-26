package programmers.level1;

public class 크기가작은부분문자열 {
  public static int solution(String t, String p) {
    int answer = 0;

    int tl = t.length();
    int pl = p.length();
    long pn = Long.parseLong(p);

    for (int i = 0; i < tl - pl + 1; i++) {
      String s = t.substring(i, i + pl);

      long sn = Long.parseLong(s);

      if (sn <= pn) answer++;
    }

    return answer;
  }

  public static void main(String[] args) {
//    String t = "3141592";
//    String p = "271";

//    String t = "500220839878";
//    String p = "7";

    String t = "10203";
    String p = "15";

    System.out.println(solution(t, p));
  }
}
