import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] ent, res;
	static List<Integer>[] adjList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 과목의 수
		int M = Integer.parseInt(st.nextToken()); // 선수 조건의 수
		adjList = new ArrayList[N+1]; // 인접리스트
		for(int i=0; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		ent = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			adjList[A].add(B);
			ent[B]++;
		}// 선수과목 정보 입력 끝
		res = new int[N+1]; // 최소 몇 학기 걸리는지 저장하는 배열
		topoSort();
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(res[i]).append(" ");
		}
		System.out.println(sb);
	}
	
	public static void topoSort() {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			// i번 과목의 선수과목이 없을 경우
			if(ent[i] == 0) {
				q.add(i);
				res[i] = 1;
			}
		}
		
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int val : adjList[node]) {
				ent[val]--;
				res[val] = Math.max(res[val], res[node]+1);
				if(ent[val] == 0) {
					q.add(val);
				}
			}
		}
	}
}
