import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 짝의 도움을 받아서...
public class Solution {
	static int N;
	static int[][] cheese;
	static boolean[][] check;
	static int[] dr = {0, 1, 0, -1}; // 우, 하, 좌, 상
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt(); // 치즈의 한 변의 길이
			int min = 101; int max = 0;
			cheese = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					cheese[i][j] = sc.nextInt();
					max = Math.max(max, cheese[i][j]);
					min = Math.min(min, cheese[i][j]);
				}
			}
			int maxlump = 1;
			
			for(int day=min; day<max; day++) {
				int count = 0;
				check = new boolean[N][N];
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(cheese[i][j] > day && !check[i][j]) {
							bfs(i, j, day);
							count++;
						}
					}
				}
				maxlump = Math.max(maxlump, count);
			}
			System.out.println("#"+t+" "+maxlump);
		}
	}
	
	public static void bfs(int r, int c, int day) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {r, c});
		
		while(!queue.isEmpty()) {
			int lump[] = queue.poll();
			int lpr = lump[0];
			int lpc = lump[1];
			
			for(int d=0; d<4; d++) {
				int nr = lpr + dr[d];
				int nc = lpc + dc[d];
				// 범위 벗어날 경우 x
				if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
				// 이미 먹은 곳이거나 체크한 곳일 경우 x
				if(cheese[nr][nc]<=day || check[nr][nc]) continue;
				
				queue.add(new int[] {nr, nc});
				check[nr][nc] = true;
			}
		}
	}
}
