package programmers.level0;

import java.util.Arrays;

public class ArrayDouble {
	public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            answer[i] = numbers[i] * 2;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
