package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static StringBuilder sb = new StringBuilder();
	static int[] S;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) {
				break;
			}
			S = new int[k];
			for(int i=0; i<k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			arr = new int[6];
			lotto(0, 0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void lotto(int at, int depth) {
		if(depth == 6) {
			for(int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=at; i<k; i++) {
			arr[depth] = S[i];
			lotto(i+1, depth+1);
		}
	}
}
