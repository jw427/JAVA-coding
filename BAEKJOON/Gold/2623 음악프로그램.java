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
	static int N;
	static int[] ent, res;
	static boolean cycle;
	static boolean[] visited, finished;
	static List<Integer>[] adjList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 가수의 수
		int M = Integer.parseInt(st.nextToken()); // 보조 PD의 수
		
		ent = new int[N+1]; // 진입차수 저장배열
		adjList = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int[] inf = new int[num];
			for(int j=0; j<num; j++) {
				inf[j] = Integer.parseInt(st.nextToken());
			}
			for(int j=0; j<num-1; j++) {
				adjList[inf[j]].add(inf[j+1]);
				ent[inf[j+1]]++;
			}
		}
		cycle = false; // 사이클 존재 여부
		visited = new boolean[N+1];
		finished = new boolean[N+1]; // dfs탐색 끝났는지 여부 저장하는 배열
		
		for(int i=1; i<=N; i++) {
			dfs(i);
			if(cycle) break;
		}
		
		if(cycle) { // 사이클이 있을 경우 - 순서 정하는 것 불가능
			System.out.println(0);
		} else {
			res = new int[N];
			topoSort();
			for(int i=0; i<N; i++) {
				System.out.println(res[i]);
			}
		}
	}
	
	static void topoSort() {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			if(ent[i] == 0) q.add(i);
		}
		int idx = 0;
		while(!q.isEmpty()) {
			int node = q.poll();
			res[idx] = node;
			for(int val : adjList[node]) {
				ent[val]--;
				if(ent[val] == 0) q.add(val);
			}
			idx++;
		}
	}
	
	static void dfs(int node) {
		visited[node] = true; // 해당 노드 방문처리
		
		for(int val : adjList[node]) {
			if(!visited[val]) dfs(val);
			// val 노드에 방문했었는데 탐색 끝났다고 처리 안되어있을 경우
			else if(!finished[val]) {
				cycle = true;
				return;
			}
		}
		finished[node] = true;
	}
}
