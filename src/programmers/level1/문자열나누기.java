package programmers.level1;

public class 문자열나누기 {
  public static int solution(String s) {
    int answer = 0;
    char x = s.charAt(0);
    int[] count = new int[2];   // count[0] = x, count[1] = others

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (count[0] == 0) {
        x = s.charAt(i);
        count[0]++;
        continue;
      }

      if (c == x) count[0]++;
      else {
        count[1]++;

        if (count[0] == count[1]) {
          answer++;
          count = new int[2];
        }
      }
    }

    if (count[0] != 0 || count[1] != 0) answer++;

    return answer;
  }

  public static void main(String[] args) {
//    String s = "banana";
//    String s = "abracadabra";
    String s = "aaabbaccccabba";

    System.out.println(solution(s));
  }
}
