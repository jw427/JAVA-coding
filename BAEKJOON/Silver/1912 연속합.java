import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		
		dp[0] = num[0];
		int max = dp[0]; // 첫번째 값으로 초기화
		
		for(int i=1; i<n; i++) {
			// 직전까지의 누적값+현재수, 현재수 중 큰 값 - 연속된 수를 선택한다는 조건이 있기 때문
			dp[i] = Math.max(dp[i-1]+num[i], num[i]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
