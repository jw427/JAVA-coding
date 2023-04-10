import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] tri = new int[N+1][N+1];
		int start = 1;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=start; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
			start++;
		}
		int[][] dp = new int[N+1][N+1];
		dp[1][1] = tri[1][1];
		start = 2;
		for(int i=2; i<=N; i++) {
			for(int j=1; j<=start; j++) {
				dp[i][j] = Math.max(dp[i-1][j-1]+tri[i][j], dp[i-1][j]+tri[i][j]);
			}
			start++;
		}
		Arrays.sort(dp[N]);
		System.out.println(dp[N][N]);
	}
}
