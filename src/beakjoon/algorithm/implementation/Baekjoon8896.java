package beakjoon.algorithm.implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class Baekjoon8896 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());    // 테스트 케이스 갯수
    for (int i = 1; i <= t; i++) {
      LinkedList<Integer> list = new LinkedList<>();    // 로봇 리스트

      int n = Integer.parseInt(br.readLine());  // 로봇 갯수
      String[] robot = new String[n];           // 로봇의 가위바위보

      for (int j = 0; j < n; j++) {
        robot[j] = br.readLine();
        list.add(i);    // 리스트에 로봇 번호 추가
      }

      for (int j = 0; j < robot[0].length(); j++) {     // 가위바위보 횟수만큼
        HashMap<Integer, Character> map = new HashMap<>();

        for (int k = 0; k < list.size(); k++) {
          int num = list.get(k);    // 리스트에 있는 로봇 번호
          char result = robot[num].charAt(j);   // 해당 로봇이 낸 가위바위보
          map.put(num, result);
        }

        // 맵에 저장된 가위바위보 결과로 서로 다른 결과가 있는지 확인
        int check = 0;  // 서로 다른 결과의 수
        char[] rcp = new char[3];   // 가위-바위-보 순서의 배열
        for (int k = 0; k < list.size(); k++) {
          int num = list.get(j);
          char c = map.get(num);
          switch(c) {
            case 'S': rcp[0]++;     // 가위일 경우
            break;
            case 'R': rcp[1]++;     // 바위일 경우
            break;
            case 'P': rcp[2]++;     // 보일 경우
            break;
          }
        }

      }
    }
  }
}