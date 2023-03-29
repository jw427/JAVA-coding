import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[] p; // 대표 저장할 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine()); // 별의 개수
		double[][] star = new double[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			star[i][0] = Double.parseDouble(st.nextToken());
			star[i][1] = Double.parseDouble(st.nextToken());
		}
		
		int num = n * (n-1) / 2;
		double[][] edges = new double[num][3];
		
		int idx = 0;
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(i != j) {
					edges[idx][0] = i; // 시작노드
					edges[idx][1] = j; // 끝노드
					edges[idx][2] = Math.sqrt(Math.pow(star[i][0]-star[j][0], 2) + Math.pow(star[i][1]-star[j][1], 2));
					idx++;
				}
			}
		}
		
		Arrays.sort(edges, new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				return Double.compare(o1[2], o2[2]);
			}
		});
		
		p = new int[n];
		for(int i=0; i<n; i++) {
			p[i] = i;
		}
		
		double min = 0;
		int pick = 0;
		
		int index = 0;
		while(pick < n-1) {
			int px = findset((int) edges[index][0]);
			int py = findset((int) edges[index][1]);
			
			if(px != py) {
				union(px, py);
				min += edges[index][2];
				pick++;
			}
			index++;
		}
		
		System.out.printf("%.2f", min);
	}// main
	
	static int findset(int x) {
		if(x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		p[y] = x;
	}
}
