package programmers.level1;
import java.util.*;

public class Hambuger {
	public int solution(int[] ingredient) {
        int answer = 0;
        // ArrayList 생성
        ArrayList<Integer> al = new ArrayList<>();
        
        // int i의 ingredient를 한칸씩 채워감
        for(int i : ingredient) {
            al.add(i);
        }    
        // System.out.println(al.size());

        for(int x = 3; x < al.size(); x++){
            if(al.get(x) == 1 && al.get(x - 1) == 3 && 
               al.get(x - 2) == 2 && al.get(x - 3) == 1){
                // ArrayList {1,2,3,1} 순서라면 삭제
                al.remove(x);
                al.remove(x - 1);
                al.remove(x - 2);
                al.remove(x - 3);
                // ???
                if(x > 0);
                // x >= 3;
                answer++;
            }   
        }
    return answer;
    }
}
