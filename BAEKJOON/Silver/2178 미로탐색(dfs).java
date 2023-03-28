import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, min, count;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0, 1, 0, -1}; // 우, 하, 좌, 상
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		visited = new boolean[N][M];
		min = N * M;
		
		maze(0, 0, 1);
		
		System.out.println(min);
	}
	// bfs로 풀어야함! dfs로 하면 시간초과 남
	public static void maze(int r, int c, int cnt) {
		visited[r][c] = true; // 방문처리
		
		if(r==N-1 && c==M-1) {
			min = Math.min(min, cnt);
			return;
		}
		
		if(cnt > min) return;
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1 && !visited[nr][nc]) {
				maze(nr, nc, cnt+1);
			}
		}
	}
}
