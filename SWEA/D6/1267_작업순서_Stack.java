import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static int V, E;
	static int[] ent; // 진입차수 저장배열
	static boolean[] visited; // 방문배열
	static List<Integer>[] adjList; // 인접리스트
	static Stack<Integer> stack;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			V = sc.nextInt(); // 정점의 개수 (1부터 V까지)
			E = sc.nextInt(); // 간선의 개수
			adjList = new ArrayList[V+1];
			for(int i=0; i<=V; i++) {
				adjList[i] = new ArrayList<>();
			}
			ent = new int[V+1];
			
			for(int i=0; i<E; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				adjList[A].add(B);
				ent[B]++;
			}
			
			stack = new Stack<>();
			visited = new boolean[V+1];
			
			for(int i=1; i<=V; i++) {
				if(ent[i] == 0) topoSort(i);
			}
			System.out.print("#"+t+" ");
			while(!stack.isEmpty()) {
				System.out.print(stack.pop()+" ");
			}
			System.out.println();
		}
	}
	// 진입 차수가 0인 노드 dfs탐색
	public static void topoSort(int node) {
		visited[node] = true;
		for(int val : adjList[node]) {
			if(!visited[val])
				topoSort(val);
		}
		stack.push(node);
	}
}
