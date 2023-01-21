package algorithm.TimeComplexity;
// 시간 복잡도 유형
// - 빅-오메가(Ω(n)) : 최선일 때(best case)의 연산 횟수를 나타낸 표기법, 1
// - 빅-세타(θ(n)) : 보통일 때(average case)의 연산 횟수를 나타낸 표기법, N/2
// - 빅-오(O(n)) : 최악일 때(worst case)의 연산 횟수를 나타낸 표기법, N

// 시간 복잡도 예제 코드
public class Example {
	public static void main(String[] args) {
		// 1 ~ 100 사이 값 랜덤 선택
		int findNumber = (int)(Math.random() * 100);
		for (int i = 0; i < 100; i++) {
			if (i == findNumber) {
				System.out.println(i);
				break;
			}
		}
	}
}
