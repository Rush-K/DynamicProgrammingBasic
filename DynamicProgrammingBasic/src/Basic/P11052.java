/** Baekjoon Online Judge
*   Problem No. 11052
*   카드 구매하기
*   Writed by Rush.K
*   Using Dynamic Programming Method
*/

package Basic;

import java.util.Scanner;

public class P11052 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // input
		int N = scanner.nextInt();
		
		int[] P = new int[N + 1];
		for (int i = 1; i <= N; i++) P[i] = scanner.nextInt();
		
		int[] result = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				result[i] = Math.max(P[j] + result[i - j], result[i]);
			}
		}
		System.out.println(result[N]); // output
	}
}
