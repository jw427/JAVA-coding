import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] fly = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					fly[i][j] = sc.nextInt();
				}
			}
			
			int sum = 0; // 파리 합
			int max = 0; // 최댓값 임시 설정
			
			for(int i=0; i<N-M+1; i++) {				
				for(int j=0; j<N-M+1; j++) {
					sum = 0;
					for(int r=i; r<i+M; r++) {
						for(int c=j; c<j+M; c++) {
							sum+=fly[r][c];
						}
					}
					if(max<sum) max=sum;
				}
				
			}
			System.out.printf("#%d %d\n", t, max);
		}
	}
}
