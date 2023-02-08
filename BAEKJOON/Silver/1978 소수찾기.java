package Math;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int sum = 0;
		for(int i=0; i<N; i++) {
			int S = sc.nextInt();
			int count=0;
			if(S==1)
				continue;
			for(int j=2; j<S; j++) {
				if(S%j==0)
					count++;
			}
			if(count==0)
				sum++;
		}
		System.out.println(sum);
	}

}
