package programmers.level0;
// [PCCE 기출문제] 7번 / 가습기

public class Page1_07 {
  public static int func1(int humidity, int val_set) {
    if (humidity < val_set) return 3;
    return 1;
  }

  public static int func2(int humidity) {
    if (humidity >= 50) return 0;
    else if (humidity >= 40) return 1;
    else if (humidity >= 30) return 2;
    else if (humidity >= 20) return 3;
    else if (humidity >= 10) return 4;
    else return 5;
  }

  public static int func3(int humidity, int val_set) {
    if (humidity < val_set) return 1;
    return 0;
  }
  public static void main(String[] args) {
    String mode_type = "auto";
    int humidity = 23;
    int val_set = 45;

    int answer = 0;

    if (mode_type.equals("auto")) {
      answer = func2(humidity);
    }
    else if (mode_type.equals("target")) {
      answer = func1(humidity, val_set);
    }
    else if (mode_type.equals("minimum")) {
      answer = func3(humidity, val_set);
    }

    System.out.println(answer);
  }
}
