package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baekjoon20436 {
  // 키보드에서 문자의 위치를 저장하기 위한 pos클래스 정의
  private static class pos {
    int x;
    int y;

    public pos(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static HashMap<Character, pos> l = new HashMap<>();       // key: 문자, value: 자판 위치(한글 자음)
  static HashMap<Character, pos> r = new HashMap<>();       // key: 문자, value: 자판 위치(한글 모음)
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    pos left, right;
    saveMap();

    // 손가락의 위치 저장
    left = l.get(s.charAt(0));
    right = r.get(s.charAt(2));

    int time = 0;

    char c;
    s = br.readLine();
    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);

      if (l.containsKey(c)) {           // 자음일 경우
        pos dirL = l.get(c);
        time += Math.abs(left.x - dirL.x) + Math.abs(left.y - dirL.y) + 1;
        left = dirL;
      } else if (r.containsKey(c)) {    // 모음일 경우
        pos dirR = r.get(c);
        time += Math.abs(right.x - dirR.x) + Math.abs(right.y - dirR.y) + 1;
        right = dirR;
      }
    }

    System.out.println(time);
  }

  // 키보드 정보 저장
  private static void saveMap() {
    l.put('q', new pos(0, 0));
    l.put('w', new pos(0, 1));
    l.put('e', new pos(0, 2));
    l.put('r', new pos(0, 3));
    l.put('t', new pos(0, 4));
    l.put('a', new pos(1, 0));
    l.put('s', new pos(1, 1));
    l.put('d', new pos(1, 2));
    l.put('f', new pos(1, 3));
    l.put('g', new pos(1, 4));
    l.put('z', new pos(2, 0));
    l.put('x', new pos(2, 1));
    l.put('c', new pos(2, 2));
    l.put('v', new pos(2, 3));

    r.put('y', new pos(0, 5));
    r.put('u', new pos(0, 6));
    r.put('i', new pos(0, 7));
    r.put('o', new pos(0, 8));
    r.put('p', new pos(0, 9));
    r.put('h', new pos(1, 5));
    r.put('j', new pos(1, 6));
    r.put('k', new pos(1, 7));
    r.put('l', new pos(1, 8));
    r.put('b', new pos(2, 4));
    r.put('n', new pos(2, 5));
    r.put('m', new pos(2, 6));
  }
}
