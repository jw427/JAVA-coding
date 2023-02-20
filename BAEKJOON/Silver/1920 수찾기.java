import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
			int key = Integer.parseInt(st.nextToken());
			if(binary(key)) System.out.println(1);
			else System.out.println(0);
		}
	}
	
	public static boolean binary(int key) {
		int start = 0;
		int end = N-1;
		
		while(start <= end) {
			int middle = (start + end)/2;
			if(A[middle] == key) return true;
			else if(A[middle]<key) start = middle+1;
			else end = middle-1;
		}
		return false;
	}
}
