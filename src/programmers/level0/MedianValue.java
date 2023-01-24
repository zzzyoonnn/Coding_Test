package programmers.level0;

import java.util.Arrays;

public class MedianValue {
	public int solution(int[] array) {
		// 자동으로 오름차순 정렬
		Arrays.sort(array);
		
		int answer = array[array.length / 2];
		return answer;
	}
}
