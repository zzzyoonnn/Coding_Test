package programmers.level2;

public class SameAddition {
	public int solution(int[] queue1, int[] queue2) {
        // int answer = -2;
        // return answer;
		
/*

두 큐의 합 같게 만들기

각 큐의 모든 원소들의 합 구하고 /2 하기
각 큐의 가장 큰 수를 찾기
ex 1) queue1 = [3, 2, 7, 2]
	 queue2 = [4, 6, 5, 1] 라면
	 
	 queue1과 queue2의 원소의 합이 30이므로 각 큐의 합이 15여야 한다.
	
	queue1의 원소의 합 = 14
	queue2의 원소의 합 = 16
	
	15보다 -1 +1이므로 각각 1씩 차이나는 원소를 옮긴다.
	queue1의 첫번째 원소가 3인데 마침 queue2에 4가 있으므로
	각각 변경하게 되면 각 큐의 합이 15가 된다.
	
	따라서 [4, 2, 7, 2] [3, 6, 5, 1]가 되어 각 원소의 합이 15가 되고
	result는 2가 된다.
	
	-> 만일 3이나 4가 큐의 초기가 아니라 중간에 있었다면 더 많은 이동을 해야했을 것
		좀 더 생각해보기 ~.~
	
ex 2) queue1 = [1, 2, 1, 2]
	 queue2 = [1, 10, 1, 2] 라면
	 
	 queue1과 queue2의 원소 합이 20이므로 각 큐의 합이 10이어야 한다.
	 
	 queue1의 원소의 합 = 6
	 queue2의 원소의 합 = 14
	 
	 10을 하나의 큐에 넣어야 하므로 1, 10을 queue1로 옮긴다.
	 이때 result는 2가 된다.
	 queue1[1, 2, 1, 2, 1, 10]이 되는데
	 이때 10은 하나의 큐 안에 단독으로 존재해야 하므로
	 queue1의 [1, 2, 1, 2, 1]은 모두 queue2로 이동한다.
	 이때 result는 +5가 되고
	 queue1 = [10], queue2 = [1, 1, 2, 1, 2, 1, 2, 1]가 된다
	 
	 result = 7
	 
	 -> 각 큐 안에 먼저 원하는 값의 원소가 존재하는지
	    if문을 돌려 원소 탐색을 후 원소 이동을 하는 것도 한 방법일듯!
	    이 예시의 경우 queue2에 원하는 값인 10이 존재하였기에
	    10까지 이동 후 다른 queue의 10 전까지의 원소 이동만 시켜주었음 되었음
	 
	 
ex 3) queue1 = [1, 1]
	 queue2 = [1, 5] 라면
	 
	 queue1과 queue2의 합이 8이므로 각 큐의 합이 4여야 한다.
	 
	 그러나 queue2의 5가 이미 4보다 크므로
	 각 큐의 합을 같게 만들 수 없으므로
	 
	 result = -1
	 
	 -> 각 큐의 합보다 큰 원소가 존재할 시 result = -1를 출력하는
	 	if문으로 시작하는 것도 한 방법일듯!
	
	=> ex3의 원하는 각 큐의 합보다 큰 원소가 존재하는 지를 먼저 판별하여
		result = -1을 출력하는 if문을 먼저 실행 후,
		ex2의 만들길 원하는 큐의 합에 해당하는 원소가
		단독으로 존재하는지 판별하는 if문을 실행 하는 게 좋을 것 같음!
		
		ex1의 경우 좀 더 생각해보기..
		
* 각 큐의 합 구하기

public static void main(String[] args) {

	int sum1 = 0;	// queue1의 합
	int sum2 = 0;	// queue2의 합

	for(int i = 0; i < queue1.length; i++)
		sum+= arr[i];
		
	for(int j = 0; j < queue2.length; j++)
		sum+= arr[j];
	
*/
		
   
}
