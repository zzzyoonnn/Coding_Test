package beakjoon.step_by_step.stage_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class boj5622 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<Character, Integer> dial = setDial();

    int result = 0;
    String s = br.readLine();
    for (int i = 0; i < s.length(); i++) {
      result = result + dial.get(s.charAt(i));
    }
    System.out.print(result);
  }

  private static HashMap<Character, Integer> setDial() {
    HashMap<Character, Integer> dial = new HashMap<>();

    dial.put('A', 3);
    dial.put('B', 3);
    dial.put('C', 3);

    dial.put('D', 4);
    dial.put('E', 4);
    dial.put('F', 4);

    dial.put('G', 5);
    dial.put('H', 5);
    dial.put('I', 5);

    dial.put('J', 6);
    dial.put('K', 6);
    dial.put('L', 6);

    dial.put('M', 7);
    dial.put('N', 7);
    dial.put('O', 7);

    dial.put('P', 8);
    dial.put('Q', 8);
    dial.put('R', 8);
    dial.put('S', 8);

    dial.put('T', 9);
    dial.put('U', 9);
    dial.put('V', 9);

    dial.put('W', 10);
    dial.put('X', 10);
    dial.put('Y', 10);
    dial.put('Z', 10);

    return dial;
  }
}
