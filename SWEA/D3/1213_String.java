import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			int N = sc.nextInt();
			String s = sc.next(); // 찾을 문자열
			String test = sc.next(); // 검색할 문장
			
			int n = s.length(); // 찾을 문자열 길이
			int m = test.length(); // 문장 문자 개수
			int sum = 0;
			
			for(int i=0; i<=m-n; i++) {
				int count = 0;
				for(int j=0; j<n; j++) {
					if(s.charAt(j) == test.charAt(i+j))
						count++;
				}
				
				if(count == n)
					sum++;
			}
			System.out.printf("#%d %d\n", t, sum);
		}
	}
}
