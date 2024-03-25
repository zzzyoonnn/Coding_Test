package beakjoon.algorithm.Set_Map_By_Hashing;
/*
문제
- Term frequency–Inverse document frequency (tf-idf) is a numerical statistic 
  which reflects the importance of words in a document collection. 
  It is often used in information retrieval system. 
  The number of times a word appears in the document (word frequency) is one of the major factors to acquire tf-idf. 
  You are asked to write a program to find the most frequent word in a document. 
입력
- The first line contains an integer n (1≤ n ≤ 1000) which determines the number of words. 
  The following n lines include the list of words, one word per line. 
  A word contains only lower-case letters and it can contain up to 20 characters. 
출력
- Print out the word that has the highest frequency and its frequency, separated by a single space. 
  If you get more than 2 results, choose only the one that comes later in the lexicographical order. 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baekjoon9612 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());        // the number of words

    HashMap<String, Integer> map = new HashMap<>();

    String s;
    int max = 0;
    String freq = "";

    for (int i = 0; i < n; i++) {
      s = br.readLine();

      map.put(s, map.getOrDefault(s, 0) + 1);

      if (max < map.get(s)) {
        max = map.get(s);
        freq = s;
      }
      if (max == map.get(s) && freq.compareTo(s) < 0) {
        // compareTo : 같으면 0, 사전순으로 내림차순이면 음수, 오름차순이면 양수를 반환
        freq = s;
      }
    }

    System.out.println(freq + " " + max);
  }
}
