import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int V, E;
	static int[] ent;
	static int[] res; // 결과 값 저장할 배열
	static List<Integer>[] adjList;
	
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
			
			res = new int[V];
			topoSort();
			System.out.print("#"+t+" ");
			for(int val : res) {
				System.out.print(val+" ");
			}
			System.out.println();
		}
	}
	
	public static void topoSort() {
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=V; i++) {
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
}
