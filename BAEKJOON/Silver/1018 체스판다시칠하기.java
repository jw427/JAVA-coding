import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] chess = new char[N][M];
		// 배열 chess에 색 넣기
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				chess[i][j] = s.charAt(j);
			}
		}
		int min = N*M;
		int sum = 0, sum1 = 0, sum2 = 0; // 다시 칠해야 할 칸의 개수
		for(int i=0; i<N-8+1; i++) { // 행
			for(int j=0; j<M-8+1; j++) { // 열
				sum = 0; sum1 = 0; sum2 = 0;
				for(int r=0; r<8; r++) {
					for(int c=0; c<8; c++) {
						if((r+c)%2==0) {
							if(chess[i+r][j+c]=='B')
								sum1++;
							else if(chess[i+r][j+c]=='W')
								sum2++;
						}else {
							if(chess[i+r][j+c]=='W')
								sum1++;
							else if(chess[i+r][j+c]=='B')
								sum2++;
						}
					}
				}
				if(sum1>sum2)
					sum = sum2;
				else if(sum1<sum2)
					sum = sum1;
				else
					sum = sum1;
				if(sum<min) min = sum;
			}
		}
		System.out.println(min);
	}
}
