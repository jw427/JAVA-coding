import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] paper = new int[101][101];
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int r=y; r<y+10; r++) {
				for(int c=x; c<x+10; c++) {
					paper[r][c] = 1;
				}
			}
		}
		
		int count = 0; // 색종이 수
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		for(int i=1; i<=100; i++) {
			for(int j=1; j<= 100; j++) {
				if(paper[i][j] == 1) {
					for(int d=0; d<4; d++) {
						int r = i + dr[d];
						int c = j + dc[d];
						
						if(r >= 1 && r <= 100 && c >= 1 && c <= 100 & paper[r][c] == 0) {
							count++;
						} else if(r < 1 || r > 100 || c < 1 || c > 100) {
							count++;
						}
					}
				}
			}
		}
		System.out.println(count);
	}
}
