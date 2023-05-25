package beakjoon.algorithm.priorityQueue;
/*
문제
- 다솜이는 사람의 마음을 읽을 수 있는 기계를 가지고 있다. 
  다솜이는 이 기계를 이용해서 2008년 4월 9일 국회의원 선거를 조작하려고 한다.
  다솜이의 기계는 각 사람들이 누구를 찍을 지 미리 읽을 수 있다. 
  어떤 사람이 누구를 찍을 지 정했으면, 반드시 선거때 그 사람을 찍는다.
  현재 형택구에 나온 국회의원 후보는 N명이다. 
  다솜이는 이 기계를 이용해서 그 마을의 주민 M명의 마음을 모두 읽었다.
  다솜이는 기호 1번이다. 
  다솜이는 사람들의 마음을 읽어서 자신을 찍지 않으려는 사람을 
  돈으로 매수해서 국회의원에 당선이 되게 하려고 한다. 
  다른 모든 사람의 득표수 보다 많은 득표수를 가질 때, 
  그 사람이 국회의원에 당선된다.
  예를 들어서, 
  마음을 읽은 결과 기호 1번이 5표, 기호 2번이 7표, 기호 3번이 7표 라고 한다면, 
  다솜이는 2번 후보를 찍으려고 하던 사람 1명과, 3번 후보를 찍으려고 하던 사람 1명을 돈으로 매수하면, 
  국회의원에 당선이 된다.
  돈으로 매수한 사람은 반드시 다솜이를 찍는다고 가정한다.
  다솜이가 매수해야하는 사람의 최솟값을 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 후보의 수 N이 주어진다. 
  둘째 줄부터 차례대로 기호 1번을 찍으려고 하는 사람의 수, 
  기호 2번을 찍으려고 하는 수, 
  이렇게 총 N개의 줄에 걸쳐 입력이 들어온다. 
  N은 50보다 작거나 같은 자연수이고, 득표수는 100보다 작거나 같은 자연수이다.
출력
- 첫째 줄에 다솜이가 매수해야 하는 사람의 최솟값을 출력한다.
ex 1)
입력		 출력
- 3         - 2
  5
  7
  7
ex 2)
입력        출력
- 4         - 1
  10
  10
  10
  10
ex 3)
입력        출력
- 1         - 0
  1
ex 4)
입력        출력
- 5         - 4
  5
  10
  7
  3
  8
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Baekjoon1417 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int ans = 0;
    int first = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
    // 우선순위 큐를 생성하고 내림차순으로 정렬된 숫자들저장

    for (int i = 0; i < n - 1; i++) {
      pq.offer(Integer.parseInt(br.readLine()));
      // 우선순위 큐에 숫자 추가
    }
    // 테스트케이스의 개수에 따라 반복
    // 첫번째 숫자를 제외한 나머지 숫자들을 우선순위 큐에 추가

    while (!pq.isEmpty() && first <= pq.peek()) {
      ans++;
      first++;
      pq.offer(pq.poll() - 1);
      // 우선순위 큐에서 가장 큰 값을 꺼내온 후 1을 뺀 값을 다시 큐에 추가
      // 우선순위 큐의 요소들이 1씩 감소
      // 우선순위 큐의 요소들을 정렬된 상태로 유지하면서 처리 가능
    }
    // 우선순위 큐가 비어있지 않고 first가 우선순위 큐의 가장 큰 값보다 작거나 같을 때까지 반복

    bw.write(ans + "\n");
    bw.flush();
    bw.close();
    br.close();
  }
}
