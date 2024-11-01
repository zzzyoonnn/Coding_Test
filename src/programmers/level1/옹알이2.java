package programmers.level1;

public class 옹알이2 {
  public static int solution(String[] babbling) {
    int answer = 0;

    String[] arr = {"aya", "ye", "woo", "ma"};

    for (int i = 0; i < babbling.length; i++) {
      if (babbling[i].contains("ayaaya") || babbling[i].contains("yeye") || babbling[i].contains("woowoo") || babbling[i].contains("mama")) continue;


      for (int j = 0; j < arr.length; j++) {
        if (babbling[i].contains(arr[j])) babbling[i] = babbling[i].replace(arr[j], "0");
      }
    }

    for (int i = 0; i < babbling.length; i++) {
      babbling[i] = babbling[i].replace("0", "");
      if (babbling[i].equals("")) answer++;
    }

    return answer;
  }

  public static void main(String[] args) {
    String[] babbling = {"aya", "yee", "u", "maa"};
//    String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

    System.out.print(solution(babbling));
  }
}
