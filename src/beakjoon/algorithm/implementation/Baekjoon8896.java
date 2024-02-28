package beakjoon.algorithm.implementation;
/*
문제
- 상근이는 가위 바위 보를 할 수 있는 로봇을 가지고 있다. 
  게임은 총 k번의 연속적인 라운드로 이루어져 있다.
  각 로봇은 길이가 k인 문자열을 가지고 있고, 이 문자열에 의해서 게임을 하게 된다. 
  각 라운드에서 패배한 로봇은 더 이상 게임을 참여할 수 없고, 남은 로봇끼리 게임을 하게 된다. 
  로봇이 하나만 남은 경우에는 그 로봇이 게임을 승리하게 되고, 게임이 끝난다. 
  k 라운드가 지난 후에 남아있는 로봇이 하나보다 많다면, 게임은 무승부로 끝난다.
  가위는 S, 바위는 R, 보는 P로 나타낼 수 있다. 
  만약, 로봇이 가지고 있는 문자열이 RSPSRSSP 라면, 
  첫 라운드에서 로봇은 주먹을 내고, 둘째 라운드에서는 가위를 낸다. 
  여덟번째 라운드까지 그 로봇이 살아있다면 보를 낸다.
  가위 바위 보 게임에 참여하는 로봇의 수와 각 로봇의 문자열이 주어졌을 때, 게임의 승자를 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 
  각 테스트 케이스의 첫째 줄에는 참여하는 로봇의 수 N이 주어진다. 
  다음 N개 줄에는 각 로봇에 저장되어 있는 문자열이 주어진다. 
  모든 로봇의 문자열의 길이는 k이다. (2 ≤ N ≤ 10, 3 ≤ k ≤ 30) 
  로봇은 주어지는 순서대로 1번부터 번호를 매긴다. 
출력
- 각 테스트 케이스마다, 게임을 승리한 로봇의 번호를 출력한다. 
  k 라운드가 지난 후에도 승자가 없는 경우 (무승부) 에는 0을 출력한다.
 */
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
        list.add(j);    // 리스트에 로봇 번호 추가
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
        char[] rsp = new char[3];   // 가위-바위-보 순서의 배열
        for (int k = 0; k < list.size(); k++) {
          int num = list.get(k);
          char c = map.get(num);
          switch(c) {
            case 'S': rsp[0]++;     // 가위일 경우
            break;
            case 'R': rsp[1]++;     // 바위일 경우
            break;
            case 'P': rsp[2]++;     // 보일 경우
            break;
          }
        }

        for (int k = 0; k < 3; k++) {
          if (rsp[k] != 0) {
            check++;
          }
        }

        // 서로 다른 결과가 3개거나 1개일 경우 다음으로
        if (check == 3 || check == 1) {
          continue;
        } else if (check == 2) {
          if (rsp[2] == 0) {    // 가위-바위
            for (int k = list.size() - 1; k >= 0; k--) {
              int robotNum = list.get(k);
              char robotResult = map.get(robotNum);

              if (robotResult == 'S') {
                list.remove(k);
                map.remove(robotNum);
              }
            }
          } else if (rsp[0] == 0) {     // 바위-보
            for (int k = list.size() - 1; k >= 0; k--) {
              int robotNum = list.get(k);
              char robotResult = map.get(robotNum);

              if (robotResult == 'R') {
                list.remove(k);
                map.remove(robotNum);
              }
            }
          } else if (rsp[1] == 0) {     // 보-가위
            for (int k = list.size() - 1; k >= 0; k--) {
              int robotNum = list.get(k);
              char robotResult = map.get(robotNum);

              if (robotResult == 'P') {
                list.remove(k);
                map.remove(robotNum);
              }
            }
          }
        }

        // 로봇이 한 대만 남은 경우
        if (list.size() == 1) {
          System.out.println(list.get(0) + 1);
          break;
        }
      }

      // 승자가 없는 경우
      if (list.size() > 1) {
        System.out.println(0);
      }
    }
  }
}