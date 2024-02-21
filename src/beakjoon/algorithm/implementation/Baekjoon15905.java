package beakjoon.algorithm.implementation;
/*
문제
- 경인지역 6개대학 연합 프로그래밍 경시대회 shake! 는 
  아주대학교, 경희대학교, 성균관대학교, 인하대학교, 한국항공대학교, 한양대학교ERICA가 함께하는 대학교 자체 연합 대회이다. 
  shake! 는 매년 1등 학생에게 사과북 프로 레티나를 비롯하여 5등까지 상장과 상품을 수여하고 있다.
  2018년 올해는 특별히 세계 최고 에듀테크 기업인 ST Unitas와 함께한다. 
  스텔라(STELLA)는 ST Unitas의 인공지능 사원이다. 
  인간을 동경하는 스텔라는 최대한 많은 학생에게 혜택이 돌아가지 못하는 점을 늘 안타까워하였다. 
  혜택을 주기위해 많은 고민을 거듭하던 스텔라는 
  ST Unitas의 전설적인 “스카이에듀 치킨 기프티콘“ 전략을 읽어보고 감명을 받아 이를 따라하기로 결심하였다. 
  너무 많은 치킨으로 회사에 큰 피해를 주면 안 되기에, 
  스텔라는 대회의 5등과 푼 문제 수는 같지만 패널티 차이로 수상하지 못한 학생들에게만 치킨 기프티콘을 보내주고자 한다.
  아쉽게도 2018년의 최신기술로도 인공지능 사원이 직접 프로그래밍을 할 수는 없어서, 여러분들이 스텔라를 도와주어야 한다. 
  shake! 순위는 아래와 같은 방식으로 정해진다고 할 때, 스텔라가 몇 개의 기프티콘을 구매해야 하는지 알아보자.
    각 참가자는 해결한 문제 개수와 패널티 총합을 가진다.
    해결한 문제의 개수가 더 많은 참가자가 더 높은 순위를 가진다.
    해결한 문제의 수가 같을 때, 패널티 총합이 더 작은 참가자가 더 높은 순위를 가진다.
입력
- 첫 줄에 참가자의 수 N(5 ≤ N ≤ 66)이 주어진다. 
  이후 N개의 줄에 걸쳐 각 참가자가 해결한 문제 개수와 패널티 총합이 주어진다. 
  각 참가자가 해결한 문제의 개수는 8개보다 작거나 같은 음이 아닌 정수이며 
  패널티 총합은 100,000보다 작거나 같은 음이 아닌 정수이다. 
  5등 학생은 적어도 한 문제 이상을 해결하였음이 보장되며, 
  한 문제 이상을 푼 학생 중 문제 수와 패널티가 모두 같은 학생은 존재하지 않는다.
출력
- 한 줄에 5등과 해결한 문제 개수가 같지만 수상하지 못하는 학생의 수를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon15905 {
  static int count = 0;
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());    // 참가자 수

    int[] solved = new int[n];
    int[] penalty = new int[n];
    int[] rank = new int[n];
    Arrays.fill(rank, 1);       // 배열을 모두 1로 초기화

    Participant[] participants = new Participant[n];    // 참가자 객체 배열 생성

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      solved[i] = Integer.parseInt(st.nextToken());
      penalty[i] = Integer.parseInt(st.nextToken());
      participants[i] = new Participant(i, solved[i], penalty[i]);  // 참가자 객체 생성 및 배열에 저장
    }
    Arrays.sort(participants);  // 참가자를 해결한 문제 수로 내림차순 정렬

    // 순위를 계산하여 rank 배열에 저장
    for (int i = 0; i < n; i++) {
      rank[participants[i].index] = i + 1;  // 참가자의 인덱스에 해당하는 순위를 저장
    }

    for (int i = 0; i < n; i++) {
      System.out.println(rank[i] + " ");
    }

    System.out.println(Arrays.toString(rank));
    System.out.println(count);
  }

  static class Participant implements Comparable<Participant> {
    int index;
    int solved;
    int penalty;

    // 참가자 객체 생성자
    public Participant(int index, int solved, int penalty) {
      this.index = index;
      this.solved = solved;
      this.penalty = penalty;
    }

    @Override
    public int compareTo(Participant other) {
      if (this.solved != other.solved) {
        // 푼 문제 수로 내림차순
        return Integer.compare(other.solved, this.solved);      // if (this.penalty > other.penalty)
      } else {
        // 푼 문제 수가 같다면, 패널티가 적은 순으로 내림차순 정렬
        count++;
        return Integer.compare(this.penalty, other.penalty);
      }
    }
  }
}
