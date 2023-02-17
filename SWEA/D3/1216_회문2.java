import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			sc.nextInt();
			char[][] arr = new char[100][100];
			
			for(int i=0; i<100; i++) {
				String s = sc.next();
				for(int j=0; j<100; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			
			int leng = 0; // 회문의 길이
			outer: for(int le=100; le>=1; le--) { // 회문 길이
				// 가로로 이어진 회문 체크
				for(int i=0; i<100; i++) {
					for(int j=0; j<=100-le; j++) {
						int check = 0; // 회문 여부 체크 횟수
						for(int k=0; k<le/2; k++) {
							if(arr[i][j+k] == arr[i][j+le-1-k])
								check++;
						}
						if(check == le/2) { // 회문이 맞다면
							leng = le;
							break outer;
						}
					}
				}
				
				// 세로로 이어진 회문 체크
				for(int j=0; j<100; j++) {
					for(int i=0; i<=100-le; i++) {
						int check = 0;
						for(int k=0; k<le/2; k++) {
							if(arr[i+k][j] == arr[i+le-1-k][j])
								check++;
						}
						if(check == le/2) {
							leng = le;
							break outer;
						}
					}
				}
				
			}
			System.out.printf("#%d %d\n", t, leng);
		}
	}
}
