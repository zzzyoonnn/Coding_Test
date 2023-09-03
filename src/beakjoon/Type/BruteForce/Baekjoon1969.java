package beakjoon.Type.BruteForce;
/*
문제
- DNA란 어떤 유전물질을 구성하는 분자이다. 
  이 DNA는 서로 다른 4가지의 뉴클레오티드로 이루어져 있다(Adenine, Thymine, Guanine, Cytosine). 
  우리는 어떤 DNA의 물질을 표현할 때, 이 DNA를 이루는 뉴클레오티드의 첫글자를 따서 표현한다. 
  만약에 Thymine-Adenine-Adenine-Cytosine-Thymine-Guanine-Cytosine-Cytosine-Guanine-Adenine-Thymine로 
  이루어진 DNA가 있다고 하면, “TAACTGCCGAT”로 표현할 수 있다. 
  그리고 Hamming Distance란 길이가 같은 두 DNA가 있을 때, 각 위치의 뉴클오티드 문자가 다른 것의 개수이다. 
  만약에 “AGCAT"와 ”GGAAT"는 첫 번째 글자와 세 번째 글자가 다르므로 Hamming Distance는 2이다.
  우리가 할 일은 다음과 같다. 
  N개의 길이 M인 DNA s1, s2, ..., sn가 주어져 있을 때 
  Hamming Distance의 합이 가장 작은 DNA s를 구하는 것이다. 
  즉, s와 s1의 Hamming Distance + s와 s2의 Hamming Distance + s와 
  s3의 Hamming Distance ... 의 합이 최소가 된다는 의미이다.
입력
- 첫 줄에 DNA의 수 N과 문자열의 길이 M이 주어진다. 
  그리고 둘째 줄부터 N+1번째 줄까지 N개의 DNA가 주어진다. 
  N은 1,000보다 작거나 같은 자연수이고, M은 50보다 작거나 같은 자연수이다.
출력
- 첫째 줄에 Hamming Distance의 합이 가장 작은 DNA 를 출력하고, 
  둘째 줄에는 그 Hamming Distance의 합을 출력하시오. 
  그러한 DNA가 여러 개 있을 때에는 사전순으로 가장 앞서는 것을 출력한다.
ex 1)
입력          출력
- 5 8         - TAAGATAC
  TATGATAC      7
  TAAGCTAC
  AAAGATCC
  TGAGATAC
  TAAGATGT
ex 2)
입력            출력
- 4 10          - ACGTACGTAA
  ACGTACGTAC      6
  CCGTACGTAG
  GCGTACGTAT
  TCGTACGTAA
ex 3)
입력            출력
- 6 10          - AAGTTACCAA
  ATGTTACCAT      12
  AAGTTACGAT
  AACAAAGCAA
  AAGTTACCTT
  AAGTTACCAA
  TACTTACCAA
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Baekjoon1969 {
  static int sum = 0;
  static String result = "";
  static int n, m;
  static String arr[];

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new String[n];
    for (int i = 0; i < n; i++) {
      arr[i] = br.readLine();
    }

    DNA();

    System.out.println(result);
    System.out.println(sum);
  }

  static void DNA() {
    char c = ' ';   // 문자
    int max;

    for (int i = 0; i < m; i++) {
      HashMap<Character, Integer> map = new HashMap<>();
      max = 0;

      for (int j = 0; j < n; j++) {
        String s = arr[j];

        map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        // DNA 서열의 한 열을 순회하면서 각 염기와 그 개수를 계산하고, 이를 HashMap에 저장
        // map.getOrDefault(s.charAt(i), 0)
        // - map에 해당 염기의 개수를 가져오는데, 만약 해당 염기가 아직 map에 등록되어 있지 않으면 기본값 0 
      }

      Iterator<Entry<Character, Integer>> it = map.entrySet().iterator();
      // Iterator를 사용하여 HashMap 순회
      // map.entrySet().iterator()
      // - HashMap의 모든 엔트리(키 - 값 쌍)를 순회하기 위한 Iterator 생성

      while (it.hasNext()) {    // map을 순회하면서 가장 빈도가 높은 염기 찾음
        Entry<Character, Integer> entrySet = it.next();
        int value = entrySet.getValue();
        char key = entrySet.getKey();

        if (max < value) {
          max = value;
          c = key;
        } else if (max == value) {  // 빈도가 같은 염기가 여러 개 있다면, 아스키 코드 값을 비교하여 더 작은 염기 선택
          char temp = key;

          int num1 = Character.getNumericValue(c);
          int num2 = Character.getNumericValue(temp);

          if (num1 > num2) c = temp;
        }
      }
      sum += n - max;
      result += c;
    }
  }
}