import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 물품의 수
		int K = sc.nextInt(); // 준서가 버틸 수 있는 무게
		int[] weights = new int[N+1]; // 각 물건의 무게
		int[] cost = new int[N+1]; // 각 물건의 가치
		
		for(int i=1; i<=N; i++) {
			weights[i] = sc.nextInt();
			cost[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N+1][K+1];
		
		for(int i=1; i<=N; i++) {
			for(int w=0; w<=K; w++) {
				if(weights[i] <= w) {
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]]+cost[i]);
				} else
					dp[i][w] = dp[i-1][w];
			}
		}
		System.out.println(dp[N][K]);
	}
}
