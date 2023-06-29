import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 사람의 수
		int[] arr = new int[N+1]; // 줄 선 순서
		int[] H = new int[N+1]; // 자기보다 키가 큰 사람 몇 명 있는지
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			H[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			int num = H[i]; // 키가 i인 사람보다 큰 사람이 왼쪽에 몇 명 있는지
			int count = 0; // 0의 개수
			int idx = 0;
			
			for(int j=1; j<=N; j++) {
				if(arr[j] == 0) {
					if(num == count) {
						arr[j] = i;
						break;
					} else
						count++;
				} else
					continue;
			}
		}
		for(int i=1; i<=N; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
