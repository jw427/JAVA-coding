import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int w, h;
	static int[][] map;
	static boolean[][] check;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}; // 8방향
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken()); // 너비
			h = Integer.parseInt(st.nextToken()); // 높이
			if(w == 0 && h == 0) break; // 반복문 종료 조건
			
			map = new int[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}// map 입력 끝
			
			check = new boolean[h][w];
			int count = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] == 1 && !check[i][j]) {
						count++;
						check[i][j] = true;
						bfs(i, j);
					}
				}
			}
			System.out.println(count);
		}
	}
	
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowr = now[0];
			int nowc = now[1];
			for(int d=0; d<8; d++) {
				int nr = nowr + dr[d];
				int nc = nowc + dc[d];
				if(nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc] == 1 && !check[nr][nc]) {
					check[nr][nc] = true;
					q.add(new int[] {nr, nc});
				}
			}
		}
	}
}
