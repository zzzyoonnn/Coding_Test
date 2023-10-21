package programmers.level1;
// 문자열 내 마음대로 정렬하기
import java.util.ArrayList;
import java.util.Collections;

public class Page3_03 {
  public static void main(String[] args) {
    String[] strings = {"sun", "bed", "car"};
    int n = 1;
    String[] answer = new String[strings.length];
    ArrayList<String> list = new ArrayList<>();

    for (int i = 0; i < strings.length; i++) list.add(strings[i].charAt(n) + strings[i]);

    Collections.sort(list);

    for (int i = 0; i < list.size(); i++) answer[i] = list.get(i).substring(1);

    for (int i = 0; i < list.size(); i++) System.out.println(answer[i]);
  }
}
