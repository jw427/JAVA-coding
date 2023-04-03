import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, W;
	static int[] time, ent, res;
	static List<Integer>[] adjList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 건물의 개수
			int K = Integer.parseInt(st.nextToken()); // 건물간의 건설순서 규칙의 총 개수
			
			time = new int[N+1]; // 건설에 걸리는 시간 저장할 배열
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			ent = new int[N+1]; // 진입차수 저장할 배열
			adjList = new ArrayList[N+1]; // 인접리스트
			for(int i=0; i<=N; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				adjList[X].add(Y);
				ent[Y]++;
			}
			int W = Integer.parseInt(br.readLine()); // 승리하기 위해 건설해야 할 건물의 번호
			res = new int[N+1]; // 건물 제작하는데 걸리는 최소시간 저장할 배열
			
			topoSort();
//			System.out.println(Arrays.toString(ent));
			System.out.println(res[W]);
		}
	}
	
	static void topoSort() {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			if(ent[i] == 0) {
				q.add(i);
				res[i] = time[i];
			}
		}
		
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int val : adjList[node]) {
				ent[val]--;
				res[val] = Math.max(res[val], res[node]+time[val]);
				if(ent[val] == 0) q.add(val);
			}
		}
	}
}
