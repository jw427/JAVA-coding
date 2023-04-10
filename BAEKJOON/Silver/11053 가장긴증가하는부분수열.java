import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 수열 A의 크기
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		dp[0] = 1;
		for(int i=1; i<N; i++) {
			for(int j=0; j<=i-1; j++) {
				if(A[i] > A[j]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
			if(dp[i] == 0) dp[i] = 1;
		}
		Arrays.sort(dp);
		System.out.println(dp[N-1]);
	}
}
