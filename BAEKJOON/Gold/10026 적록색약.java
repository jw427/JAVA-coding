import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static char[][] col;
	static boolean[][] check;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new char[N][N];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				col[i][j] = s.charAt(j);
			}
		}
		
		// 적록색약 아닌 사람
		check = new boolean[N][N];
		int count1 = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(col[i][j] == 'R' && !check[i][j]) {
					bfs1(i, j, 'R');
					count1++;
				} else if(col[i][j] == 'B' && !check[i][j]) {
					bfs1(i, j, 'B');
					count1++;
				} else if(col[i][j] == 'G' && !check[i][j]) {
					bfs1(i, j, 'G');
					count1++;
				}
			}
		}
		// 적록색약인 사람
		check = new boolean[N][N];
		int count2 = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(col[i][j] == 'B' && !check[i][j]) {
					bfs1(i, j, 'B');
					count2++;
				} else if((col[i][j] == 'R' || col[i][j] == 'G') && !check[i][j]) {
					bfs2(i, j, 'R', 'G');
					count2++;
				}
			}
		}
		System.out.println(count1 + " " + count2);
	}
	
	public static void bfs1(int r, int c, char color) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nowr = now[0];
			int nowc = now[1];
			
			for(int d=0; d<4; d++) {
				int nr = nowr + dr[d];
				int nc = nowc + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(col[nr][nc] != color || check[nr][nc]) continue;
				
				q.add(new int[] {nr, nc});
				check[nr][nc] = true;
			}
		}
	}
	
	public static void bfs2(int r, int c, char color1, char color2) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nowr = now[0];
			int nowc = now[1];
			
			for(int d=0; d<4; d++) {
				int nr = nowr + dr[d];
				int nc = nowc + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if((col[nr][nc] != color1 && col[nr][nc] != color2) || check[nr][nc]) continue;
				
				q.add(new int[] {nr, nc});
				check[nr][nc] = true;
			}
		}
	}
}
