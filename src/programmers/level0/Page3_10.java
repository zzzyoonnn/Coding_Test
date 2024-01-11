package programmers.level0;
// 부분 문자열 이어 붙여 문자열 만들기

public class Page3_10 {
  public static void main(String[] args) {
    String[] my_strings = {"progressive", "hamburger", "hammer", "ahocorasick"};
    int[][] parts = {{0, 4}, {1, 2}, {3, 5}, {7, 7}};
    String answer = "";

    for (int i = 0; i < my_strings.length; i++) {
      int s = parts[i][0];
      int e = parts[i][1];
      for (int j = s; j <= e; j++) answer += my_strings[i].charAt(j);
    }

    System.out.println(answer);
  }
}
