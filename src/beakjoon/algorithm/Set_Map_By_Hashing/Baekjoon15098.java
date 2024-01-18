package beakjoon.algorithm.Set_Map_By_Hashing;
/*
문제
- There is a game in which you try not to repeat a word while your opponent tries to see if you have repeated one.
  "THE RAIN IN SPAIN" has no repeats.
  "IN THE RAIN AND THE SNOW" repeats THE.
  "THE RAIN IN SPAIN IN THE PLAIN" repeats THE and IN.
  Write a program to test a phrase.
입력
- Input is a line containing words separated by single spaces, where a word consists of one or more uppercase letters. 
  A line contains no more than 80 characters.
출력
- The output is "yes" if no word is repeated, and "no" if one or more words repeat.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon15098 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    HashSet<String> set = new HashSet<>();

    boolean check = false;

    while (st.hasMoreTokens()) {
      String word = st.nextToken();
      if (set.contains(word)) {
        check = true;
        break;
      }
      set.add(word);
    }

    if (check) System.out.println("no");
    else System.out.println("yes");
  }
}
