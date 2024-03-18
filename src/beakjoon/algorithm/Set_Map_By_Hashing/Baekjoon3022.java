package beakjoon.algorithm.Set_Map_By_Hashing;
/*
문제
- N children are eating lunch at the table. 
  Children take turns in taking food from the table. 
  Some of the children haven't yet been taught proper manners so they jump at the food without giving the others a chance. 
  If at any point a child takes a piece of food, 
  and that child had already taken more food than the other children all together (not including the new piece of food), 
  then the mother will warn that child to behave. 
  You will be given the order in which the children take food. 
  Write a program that calculates how many times the mother has to warn the children. 
입력
- The first line of input contains an integer N (1 ≤ N ≤ 100), how many pieces of food the children take. 
  Each of the following N lines contains the name of a child that took one piece of food. 
  The names will be strings of at most 20 lowercase letters of the English alphabet. 
출력
- Output the number of warnings on a single line. 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baekjoon3022 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    HashMap<String, Integer> map = new HashMap<>();

    String name;
    int count = 0;
    for (int i = 0; i < n; i++) {
      name = br.readLine();

      // 이 전에 집은 쿠키의 개수보다 더 많다면 경고
      // 현재 집은 것은 포함하지 않으므로(not including the new piece of food)
      // map을 갱신하기 전에 수행한다.
      if (i - map.getOrDefault(name, 0) < map.getOrDefault(name, 0)) {      // 이 전에 집은 쿠키의 개수 < 현재 집은 쿠키의 개수
        count++;
      }

      map.put(name, map.getOrDefault(name, 0) + 1);

    }
    System.out.println(count);
  }
}
