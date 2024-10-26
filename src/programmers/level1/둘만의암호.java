package programmers.level1;

public class 둘만의암호 {
  public static String solution(String s, String skip, int index) {
    String answer = "";
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    for (int i = 0; i < skip.length(); i++) {
      char c = skip.charAt(i);

      alphabet = alphabet.replace(String.valueOf(c), "");
    }

    int length = alphabet.length();
    for (int i = 0; i < s.length(); i++) {
      int n = alphabet.indexOf(s.charAt(i));

      n = (n + index) % length;
      answer += alphabet.charAt(n);
    }
    return answer;
  }

  public static void main(String[] args) {
    String s = "aukks";
    String skip = "wbqd";
    int index = 5;

    System.out.println(solution(s, skip, index));
  }
}
