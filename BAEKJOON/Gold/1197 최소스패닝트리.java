import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		int[][] edges = new int[E][3];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken()); // 시작 정점
			edges[i][1] = Integer.parseInt(st.nextToken()); // 끝 정점
			edges[i][2] = Integer.parseInt(st.nextToken()); // 가중치
		}
		
		p = new int[V+1];
		for(int i=1; i<=V; i++) {
			p[i] = i;
		}
		
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		int ans = 0;
		int pick = 0;
		
		int idx = 0;
		while(pick<V-1) {
			int px = findset(edges[idx][0]);
			int py = findset(edges[idx][1]);
			
			if(px != py) {
				union(px, py);
				ans += edges[idx][2];
				pick++;
			}
			idx++;
		}
		System.out.println(ans);
	}
	
	static int findset(int x) {
		if(x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		p[y] = x;
	}
}
