/** Baekjoon Online Judge
*   Problem No. 1463
*   Writed by Rush.K
*   Using BFS by QUEUE
*/

package Basic;

import java.util.LinkedList;
import java.util.Scanner;

class Number { // 수
	int N;
	int result;
	
	public Number(int n, int res) {
		N = n;
		result = res;
	}
}

public class P1463 {

	public static void main(String[] args) {
		//input 
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		if (num < 1 || num > 1000000) { // 범위에 맞지 않으면 프로그램 종료
			return ;
		}

		Number N = new Number(num, 0); // 값을 Number 클래스를 이용해 초기화
		
		int result = Integer.MAX_VALUE; // 결과 값
		LinkedList<Number> queue = new LinkedList<>(); // BFS를 위한 QUEUE
		queue.add(N); // 첫 수 삽입 
		
		while (!queue.isEmpty()) { // 큐가 빌 때까지 반복
			Number Start = queue.pollFirst(); // 값을 가져옴
			if (Start.N == 1) { // 값이 1일 때
				result = Start.result;
				break;
			}
			if (Start.N % 3 == 0) { // 값이 3으로 나누어 떨어질 때
				Number temp = new Number(Start.N / 3, Start.result + 1);
				if (temp.N == 1) {
					result = temp.result;
					break;
				} else {
					queue.add(temp);
				}
			}
			if (Start.N % 2 == 0) { // 값이 2로 나누어 떨어질 때
				Number temp = new Number(Start.N / 2, Start.result + 1);
				if (temp.N == 1) {
					result = temp.result;
					break;
				} else {
					queue.add(temp);
				}
			}
			// 값에서 1을 뺄 때
			Number temp = new Number(Start.N - 1, Start.result + 1);
			if (temp.N == 1) {
				result = temp.result;
				break;
			} else {
				queue.add(temp);
			}
		}
		//output
		System.out.println(result);
	}
}
