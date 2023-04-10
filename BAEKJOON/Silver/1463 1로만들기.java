import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		while(true) {
			int start = q.poll();
			if(start == 1) break;
			// 3으로 나누어떨어질 때
			if(start/3 >= 1 && start%3 == 0) {
				if(dp[start/3] == 0) {
					dp[start/3] = dp[start]+1;
				} else {
					dp[start/3] = Math.min(dp[start/3], dp[start]+1);
				}
				q.add(start/3);
			}
			// 2로 나누어떨어질 때
			if(start/2 >= 1 && start%2 == 0) {
				if(dp[start/2] == 0) {
					dp[start/2] = dp[start]+1;
				} else {
					dp[start/2] = Math.min(dp[start/2], dp[start]+1);
				}
				q.add(start/2);
			}
			if(start-1 >= 1) {
				if(dp[start-1] == 0) {
					dp[start-1] = dp[start]+1;
				} else {
					dp[start-1] = Math.min(dp[start-1], dp[start]+1);
				}
				q.add(start-1);
			}
		}
		System.out.println(dp[1]);
	}
}
