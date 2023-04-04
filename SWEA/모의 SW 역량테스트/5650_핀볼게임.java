import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		
		int[] dr = {-1, 1, 0, 0}; // 상하좌우
		int[] dc = {0, 0, -1, 1};
		
		int[] one = {1, 3, 0, 2}; // 1번
		int[] two = {3, 0, 1, 2}; // 2번
		int[] three = {2, 0, 3, 1}; // 3번
		int[] four = {1, 2, 3, 0}; // 4번
		int[] five = {1, 0, 3, 2}; // 5번
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine().trim()); // 게임판 한 변의 길이
			int[][] map = new int[N+2][N+2];
			// 범위 외의 위치 5번 블록으로
			for(int i=0; i<N+2; i++) {
				map[0][i] = map[i][0] = map[N+1][i] = map[i][N+1] = 5;
			}
			
			int[][] wormhole = new int[10][3];
			int idx=0;
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] >= 6) { // 웜홀일 경우
						wormhole[idx][0] = i; // 행
						wormhole[idx][1] = j; // 열
						wormhole[idx][2] = map[i][j]; // 웜홀 번호
						idx++;
					}
				}
			}// 게임판 입력
			int max = 0;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][j] == 0) {
						for(int d=0; d<4; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							int count = 0;
							int dir = d; // 블록 부딪힐 때마다 방향 바꿔줘야 하기 때문에 방향 변수 추가
							while(true) {
								if(map[nr][nc] == -1) break;
								if(nr == i && nc == j) break;
								
								// 빈 공간일 경우 계속 이동
								if(map[nr][nc] == 0) {
									nr += dr[dir];
									nc += dc[dir];
								} else if(map[nr][nc] == 1) {
									count++;
									dir = one[dir];
									nr += dr[dir];
									nc += dc[dir];
								} else if(map[nr][nc] == 2) {
									count++;
									dir = two[dir];
									nr += dr[dir];
									nc += dc[dir];
								} else if(map[nr][nc] == 3) {
									count++;
									dir = three[dir];
									nr += dr[dir];
									nc += dc[dir];
								} else if(map[nr][nc] == 4) {
									count++;
									dir = four[dir];
									nr += dr[dir];
									nc += dc[dir];
								} else if(map[nr][nc] == 5) {
									count++;
									dir = five[dir];
									nr += dr[dir];
									nc += dc[dir];
								// 웜홀인 경우 -> 다른 웜홀로 이동해야 함
								} else if(map[nr][nc] >= 6) {
									for(int k=0; k<10; k++) {
										// 웜홀 번호가 일치하면서, 다른 웜홀일 경우
										if(wormhole[k][2] == map[nr][nc] && (wormhole[k][0] != nr || wormhole[k][1] != nc)){
											nr = wormhole[k][0] + dr[dir];
											nc = wormhole[k][1] + dc[dir];
											break;
										}
									}
								}
							}// while 끝
							max = Math.max(max, count);
						}
					}
				}
			}
			System.out.println("#"+t+" "+max);
//			for(int i=0; i<N+2; i++) {
//				for(int j=0; j<N+2; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
		}
	}
}
