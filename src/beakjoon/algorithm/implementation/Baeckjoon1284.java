package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baeckjoon1284 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while (true) {
            s = br.readLine();

            if (s.equals("0")) break;

            int length = s.length();

            int sum = 2;
            for (int i = 0; i < length; i++) {
                int n = s.charAt(i) - '0';

                switch (n) {
                    case 1:
                        sum += 2;
                        break;
                    case 0:
                        sum += 4;
                        break;
                    default:
                        sum += 3;
                        break;
                }
            }

            sum += (length - 1);
            System.out.println(sum);
        }
    }
}
