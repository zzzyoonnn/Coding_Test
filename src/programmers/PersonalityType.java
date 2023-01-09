package programmers;

import java.util.HashMap;
import java.util.Map;

public class PersonalityType {
static class Solution {
    public String solution(String[] survey, int[] choices) {

    	// Map명령어를 이용하여 키 값고 value 값을 받는다.
        Map<String, Integer> character = init_character();

        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];
            if (choice == 4) continue;
            String[] surveySplit = survey[i].split("");

            // switch문을 이용하여 1. 문자열을 입력받아 2. 문자열을 나누고 3. 성격 점수를 받는다.
            addScore(character, surveySplit, choice);
        }
        return getResult(character);
    }

    public String getResult(Map<String, Integer> character) {
        StringBuilder sb = new StringBuilder();

        // 입력 받은 문자열을 나눔
        insert_result(character, sb, "R", "T");
        insert_result(character, sb, "C", "F");
        insert_result(character, sb, "J", "M");
        insert_result(character, sb, "A", "N");

        return sb.toString();
    }

    // 결과 삽입 																		전자		 후자
    private void insert_result(Map<String, Integer> character, StringBuilder sb, String first, String second) {
        // 첫번째의 값이 두번째 값보다 점수가 높다면
    	if (character.get(first) >= character.get(second)) {
    		// append
    		// - 인수로 전달된 값을 문자열로 변환한 후, 해당 문자열의 마지막에 추가 -> 이어 붙임
            sb.append(first);
        } else {
            sb.append(second);
        }
    }

    // 검사지 질문 7개 선택지 switch
    public void addScore(Map<String, Integer> character, String[] surveySplit, int choice) {

    	switch (choice) {
    		// 앞 글자 점수 넣기
            case 1 : character_put(character, surveySplit[0], 3);
            case 2 : character_put(character, surveySplit[0], 2);
            case 3 : character_put(character, surveySplit[0], 1);
            // 점수 없음
            case 4 : return;
            // 뒷 글자 점수 넣기
            case 5 : character_put(character, surveySplit[1], 1);
            case 6 : character_put(character, surveySplit[1], 2);
            case 7 : character_put(character, surveySplit[1], 3);
            default : break;
        }
    }

    private void character_put(Map<String, Integer> character, String str, int i) {

    	// replace 함수
    	// - replace([기존문자],[바꿀문자])
    	// - 자신이 바꾸고 싶은 문자로 문자열 치환
    	
    	// => ???
        character.replace(str, character.get(str)+i);
    }

    public HashMap<String, Integer> init_character () {

        return new HashMap<>(){{
            put("R", 0);
            put("T", 0);
            put("C", 0);
            put("F", 0);
            put("J", 0);
            put("M", 0);
            put("A", 0);
            put("N", 0);
            }};
        }

    }
}
