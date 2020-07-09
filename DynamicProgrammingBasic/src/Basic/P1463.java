/** Baekjoon Online Judge
*   Problem No. 1463
*   Writed by Rush.K
*   Using BFS by QUEUE
*/

package Basic;

import java.util.LinkedList;
import java.util.Scanner;

class Number {
	int N;
	int result;
	
	public Number(int n, int res) {
		N = n;
		result = res;
	}
}

public class P1463 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		if (num < 1 || num > 1000000) {
			return ;// TODO Auto-generated method stub
		}

		Number N = new Number(num, 0);
		
		int result = Integer.MAX_VALUE;
		LinkedList<Number> queue = new LinkedList<>();
		queue.add(N);
		
		while (!queue.isEmpty()) {
			Number Start = queue.pollFirst();
			if (Start.N == 1) {
				result = Start.result;
				break;
			}
			if (Start.N % 3 == 0) {
				Number temp = new Number(Start.N / 3, Start.result + 1);
				if (temp.N == 1) {
					result = temp.result;
					break;
				} else {
					queue.add(temp);
				}
			}
			if (Start.N % 2 == 0) {
				Number temp = new Number(Start.N / 2, Start.result + 1);
				if (temp.N == 1) {
					result = temp.result;
					break;
				} else {
					queue.add(temp);
				}
			}
			Number temp = new Number(Start.N - 1, Start.result + 1);
			if (temp.N == 1) {
				result = temp.result;
				break;
			} else {
				queue.add(temp);
			}
		}
		System.out.println(result);
	}

}
