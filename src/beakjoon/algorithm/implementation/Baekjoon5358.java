package beakjoon.algorithm.implementation;
/*
문제
- The PLU football coach must submit to the NCAA officials the names of all players 
  that will be competing in NCAA Division II championship game. 
  Unfortunately his computer keyboard malfunctioned and interchanged the letters ‘i’ and ‘e’. 
  Your job is to write a program that will read all the names and print the names with the correct spelling.
입력
- The file contains a list of names, and each name will be on a separate line.
출력
- Print the same list of names with every ‘i’ replaced with an ‘e’, 
  every ‘e’ replaced with an ‘i’, 
  every ‘I’ replaced with an ‘E’, 
  and every ‘E’ replaced with an ‘I’.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5358 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str;
    StringBuilder sb;

    while ((str = br.readLine()) != null) {
      sb = new StringBuilder();
      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == 'i') sb.append('e');
        else if (str.charAt(i) == 'e') sb.append('i');
        else if (str.charAt(i) == 'I') sb.append('E');
        else if (str.charAt(i) == 'E') sb.append('I');
        else sb.append(str.charAt(i));
      }
      System.out.println(sb);
    }
  }
}
