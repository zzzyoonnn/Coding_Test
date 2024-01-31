package beakjoon.algorithm.implementation;
/*
문제
- Ron is cooking chili using an assortment of peppers.
  The spiciness of a pepper is measured in Scoville Heat Units (SHU). 
  Ron's chili is currently not spicy at all, but each time Ron adds a pepper, 
  the total spiciness of the chili increases by the SHU value of that pepper.
  The SHU values of the peppers available to Ron are shown in the following table:
    Pepper Name Scolville Heat Units
    Poblano 1500
    Mirasol 6000
    Serrano 15500
    Cayenne 40000
    Thai    75000
    Habanero    125000
  Your job is to determine the total spiciness of Ron's chili after he has finished adding peppers.
입력
- The first line of input will contain a positive integer N, representing the number of peppers Ron adds to his chili. 
  The next N lines will each contain the name of a pepper Ron has added. 
  Each pepper name will exactly match a name that appears in the table above. 
  Note that more than one pepper of the same name can be added.
출력
- The output will consist of a positive integer T, representing the total spiciness of Ron's chili.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon28249 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int t = 0;

    String s;
    for (int i = 0; i < n; i++) {
      s = br.readLine();
      if (s.equals("Poblano")) t += 1500;
      else if (s.equals("Mirasol")) t += 6000;
      else if (s.equals("Serrano")) t += 15500;
      else if (s.equals("Cayenne")) t += 40000;
      else if (s.equals("Thai")) t += 75000;
      else if (s.equals("Habanero")) t += 125000;
    }

    System.out.println(t);
  }
}
