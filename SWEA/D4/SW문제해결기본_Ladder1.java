import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int T=1; T<11; T++) {
			sc.nextInt();
			int[][] lad = new int[102][102];
			for(int i=1; i<=100; i++) {
				for(int j=1; j<=100; j++) {
					lad[i][j] = sc.nextInt();
				}
			}
			
			int c=0; // 시작 열번호
			for(int i=1; i<=100; i++) {
				if(lad[100][i]==2)
					c=i;
			}
			// 행 하나씩 줄여나가기
			for(int i=99; i>1; i--) {
				if(lad[i][c-1]==0 && lad[i][c+1]==0)
					continue;
				else if(lad[i][c+1]==1) {
					c++;
					while(lad[i][c+1]==1) {
						c++;
					}
				} else if(lad[i][c-1]==1) {
					c--;
					while(lad[i][c-1]==1) {
						c--;
					}
				}
			}
			System.out.printf("#%d %d\n", T, c-1);
		}
	}
}
