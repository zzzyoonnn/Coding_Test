package beakjoon.algorithm.implementation;
/*
문제
- King Dragon, the king of Animal Kingdom, passed away this morning. 
  This unfortunate news saddened every animal. 
  Since no one sees any other living dragon nowadays, the government of Animal Kingdom cannot find any successor to King Dragon. 
  But Animal Kingdom cannot operate without a king. 
  The government of Animal Kingdom decided to elect a new king.
  There are nine voters: Armadillo, Buffalo, Cat, Dog, Elephant, Fox, Goat, Hippo and Zebra and two candidates: Tiger and Lion.
  The votes will be anonymously casted tomorrow. 
  The government asked you to write a program to calculate the votes and announce the next king of Animal Kingdom. 
  Note that the next king is the one who receives more than half the votes.
입력
- The input has exactly nine lines. 
  Each of them is a string which is either Tiger or Lion, and it represents a casted vote from an anonymous voter.
출력
- Output one line containing the next king’s name.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon17598 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tiger = 0;
    int lion = 0;

    String s;
    for (int i = 0; i < 9; i++) {
      s = br.readLine();
      if (s.equals("Tiger")) tiger++;
      else if (s.equals("Lion")) lion++;
    }

    System.out.println((tiger > lion) ? "Tiger" : "Lion");
  }
}
