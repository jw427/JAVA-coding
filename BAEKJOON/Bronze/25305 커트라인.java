import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int k = sc.nextInt();
		int[] x = new int[N];
		
		for(int i=0; i<N; i++) {
			x[i] = sc.nextInt();
		}
		
		for(int i=0; i<N-1; i++) {
			int idx = i;
			for(int j=i+1; j<N; j++) {
				if(x[idx] < x[j])
					idx = j;
			}
			
			int temp = x[i];
			x[i] = x[idx];
			x[idx] = temp;
		}
		System.out.println(x[k-1]);
	}
}
