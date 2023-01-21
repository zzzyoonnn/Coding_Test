package algorithm.TimeComplexity;

// n개의 수가 주어졌을 때 오름차순 정렬하는 프로그램 작성
// 연산 횟수가 N의 제곱인 경우
public class OperationsNsquare {
	public static void main(String[] args) {
		int n = 10000;
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("연산 횟수 : " + cnt++);
			}
		}
	}
}