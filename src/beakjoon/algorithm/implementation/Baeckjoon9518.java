package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baeckjoon9518 {
    static int r, s;
    static char[][] arr;
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1}, dy = {1, 1, 1, 0, -1, -1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new char[r][s];
        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int stand = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                if (arr[i][j] == 'o') {
                    stand += dfs(i, j, 4);
                }
            }
        }

        int seat = stand;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                if (arr[i][j] == '.') {
                    int sum = dfs(i, j, 8);

                    seat = Math.max(seat, stand + sum);
                }
            }
        }

        System.out.println(seat);
    }
    static int dfs(int x, int y, int direction) {
        int sum = 0;

        for (int k = 0; k < direction; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && ny >= 0 && nx < r && ny < s) {
                if (arr[nx][ny] == 'o') {
                    sum++;
                }
            }
        }
        return sum;
    }

}


