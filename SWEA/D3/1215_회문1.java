import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			int N = sc.nextInt();
			char[][] arr = new char[8][8];
			
			for(int i=0; i<8; i++) {
				String s = sc.next();
				for(int j=0; j<8; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			int count = 0; // 회문 개수
			// 가로로 이어진 회문 체크
			for(int i=0; i<8; i++) {
				for(int j=0; j<=8-N; j++) {
					int check = 0;
					for(int k=0; k<N/2; k++) { // 회문 여부 체크 횟수
						if(arr[i][j+k] == arr[i][j+N-1-k]) {
							check++;
						}
					}
					if(check==N/2) 
						count++;
				}
			}
			// 세로로 이어진 회문 체크
			for(int j=0; j<8; j++) {
				for(int i=0; i<=8-N; i++) {
					int check = 0;
					for(int k=0; k<N/2; k++) { // 회문 여부 체크 횟수
						if(arr[i+k][j] == arr[i+N-1-k][j]) {
							check++;
						}
					}
					if(check==N/2) 
						count++;
				}
			}
			System.out.printf("#%d %d\n", t, count);
		}
	}
}
