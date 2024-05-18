package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon9017 {
  static int n, winnerTeam, winnerScore;
  static StringTokenizer st;

  // savePlayerInfomation에 사용되는 map들
  static HashMap<Integer, Integer> player;
  static HashMap<Integer, Integer> rank;

  // makeNewRank에 사용되는 map들
  static HashMap<Integer, Integer> newRank;
  static HashMap<Integer, Integer> count;

  // saveScoreAndFifthPlayer에 사용되는 map들
  static HashMap<Integer, Integer> score;
  static HashMap<Integer, Integer> fifthPlayer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());        // 테스트 케이스 개수

    for (int tc = 0; tc < t; tc++) {
      n = Integer.parseInt(br.readLine());                  // 참가자 수

      // 주어지는 참가자들의 순위를 저장하기
      player = new HashMap<>();       // 자격을 갖춘 팀(6명)인지 확인하기 위한 map(Key : 팀, Value : 명수)
      rank = new HashMap<>();         // 출전 선수들의 등수 map(Key : 등수, Value : 팀)
      savePlayerInfomation(br, n);

      // 참가자가 여섯 명이 되지 않는 팀은 제외하고 새로운 순위를 생성하기
      newRank = new HashMap<>();      // 새로운 등수 map(Key : 등수, Value : 팀)
      count = new HashMap<>();        // 팀별 선수 등수 계산 횟수 map(Key : 팀, Value : 등수)
      makeNewRank();

      // 상위 4명의 주자들의 점수와 다섯 번째 주자 정보 저장하기
      score = new HashMap<>();        // 팀별 점수를 저장할 map(Key: 팀, Value : 등수)
      fifthPlayer = new HashMap<>();  // 다섯 번째 선수의 등수를 저장할 map(Key : 팀, Value : 등수)
      saveScoreAndFifthPlayer();

      winnerTeam = 0;
      winnerScore = Integer.MAX_VALUE;

      findWinnerTeam();

      System.out.println(winnerTeam);
    }
  }

  public static void savePlayerInfomation(BufferedReader br, int n) throws IOException {
    st = new StringTokenizer(br.readLine());                  // 결승점을 통과한 선수의 팀 정보

    for (int i = 1; i <= n; i++) {
      int m = Integer.parseInt(st.nextToken());       // 결승점을 통과한 선수의 팀

      player.put(m, player.getOrDefault(m, 0) + 1);
      rank.put(i, m);
    }
  }

  public static void makeNewRank() {
    int temp = 1;         // 등수
    for (int i = 1; i <= n; i++) {
      int checkRank = rank.get(i);            // 팀

      if (player.get(checkRank) == 6) {       // 해당 팀의 소속 인원이 6명이라면
        count.put(checkRank, 0);
        newRank.put(temp, checkRank);         // newRank에 Key : 등수, Value : 팀 저장
        temp++;
      }
    }
  }

  public static void saveScoreAndFifthPlayer() {
    for (int i : newRank.keySet()) {      // newRank(Key : 등수, Value : 팀)
      int team = newRank.get(i);

      if (count.get(team) < 4) {                 // 상위 4명의 주자까지
        count.put(team, count.get(team) + 1);
        score.put(team, score.getOrDefault(team, 0) + i);
      } else if (count.get(team) == 4) {          // 다섯 번째 주자 정보 저장하기
        count.put(team, count.get(team) + 1);
        fifthPlayer.put(team, i);     // 현재 팀의 정보와 5번째 선수의 등수 저장
      }
    }
  }

  public static void findWinnerTeam() {
    for (int i : score.keySet()) {
      if (winnerScore > score.get(i)) {       // i팀의 점수가 현재 우승한 팀의 점수보다 작다면
        winnerScore = score.get(i);           // 우승한 점수를 i팀의 점수로 변경
        winnerTeam = i;                       // 우승한 팀을 i로 변경
      } else if (winnerScore == score.get(i)) {           // 우승한 팀과 i팀의 점수가 같다면 다섯번째 선수의 등수로 비교
        int preFifth = fifthPlayer.get(winnerTeam);
        int nowFifth = fifthPlayer.get(i);

        if (nowFifth < preFifth) {
          winnerScore = score.get(i);
          winnerTeam = i;
        }
      }
    }
  }
}
