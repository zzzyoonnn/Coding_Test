package beakjoon.algorithm.implementation;
/*
문제
- The Vowels are a, e, i, o and u, and possibly y. 
  People disagree on whether y is a vowel or not. 
  Unfortunately for you, you have been tasked with counting the number of vowels in a word. 
  You'll have to count how many vowels there are assuming y is a vowel, and assuming y is not.
입력
- The single line of input contains a string of at least one and at most 50 lowercase letters.
출력
- Output two space-separated integers. 
  The first is the number of vowels assuming y is not a vowel, the second is the number of vowels assuming y is a vowel.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon31306 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();

    int yx = 0;
    int yo = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
        yx++;
        yo++;
      } else if (s.charAt(i) == 'y') yo++;
    }

    System.out.println(yx + " " + yo);
  }
}
