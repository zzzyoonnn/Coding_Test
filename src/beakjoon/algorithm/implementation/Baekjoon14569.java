package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon14569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 과목 정보 저장
        int N = Integer.parseInt(br.readLine());    // 총 과목의 수

        List<Integer>[] subject = new List[N];
        for (int i = 0; i < N; i++) {
            subject[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());   // 수업시간의 수
            for (int j = 0; j < k; j++) {
                subject[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // 학생 정보 저장
        int M = Integer.parseInt(br.readLine());    // 학생 수
        List<Integer>[] student = new List[M];

        for (int i = 0; i < M; i++) {
            student[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());   // 비어 있는 교시 개수

            for (int j = 0; j < p; j++) {
                student[i].add(Integer.parseInt(st.nextToken()));
            }

            // 추가할 수 있는 과목의 개수
            int count = 0;
            for (int a = 0; a < subject.length; a++) {
                boolean check = true;
                for(int b = 0; b < subject[a].size(); b++) {
                    if (!student[i].contains(Integer.valueOf(subject[a].get(b)))) check = false;
                }

                if(check) count++;
            }
            System.out.println(count);
        }
    }
}
