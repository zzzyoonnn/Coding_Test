package programmers.level0;

import java.util.HashMap;
import java.util.Map;

public class AdditionOfFractions {
    public static void main(String[] args) {
        int n = 16;

        while (n > 2) {

            if (n % 2 != 0) System.out.println("false");

            n /= 2;
        }

        System.out.println("true");
    }
}
