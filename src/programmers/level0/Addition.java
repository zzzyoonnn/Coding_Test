package programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/120802

import java.util.ArrayList;
import java.util.*;

public class Addition {
	public static void main(String[] args) {
        String s = "bbbaaaba";
        String t = "aaabbbba";

        Map <Character, Integer> sMap = new HashMap<>();
        Map <Character, Integer> tMap = new HashMap<>();

        char sChar, tChar;

        for (int i = 0; i < s.length(); i++) {
            boolean checkS = true;
            boolean checkT = true;

            sChar = s.charAt(i);
            tChar = t.charAt(i);

            System.out.println(sChar + " " + tChar);

            System.out.println(sMap);
            System.out.println(sMap);

            if (i > 0) {
                if (s.charAt(i - 1) != sChar) checkS = false;
                if (t.charAt(i - 1) != tChar) checkT = false;
            }

            if (checkS != checkT) {
                //if (sMap.get(sChar) == tMap.get(tChar)) continue;
                System.out.println(false);
            }

            sMap.put(sChar, sMap.getOrDefault(sChar, 0) + 1);
            tMap.put(tChar, tMap.getOrDefault(tChar, 0) + 1);

            if (sMap.get(sChar) != tMap.get(tChar)) {
                System.out.println(false);
            }
        }
        System.out.println(true);
    }
}
