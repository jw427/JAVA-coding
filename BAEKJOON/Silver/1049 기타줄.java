import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 끊어진 기타줄 개수
		int M = Integer.parseInt(st.nextToken()); // 기타줄 브랜드 개수
		
		int[] pack = new int[M]; // 패키지의 가격
		int[] unit = new int[M]; // 낱개로 살 때의 가격
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			pack[i] = Integer.parseInt(st.nextToken());
			unit[i] = Integer.parseInt(st.nextToken());
		}
		
		int pack_num = N / 6; // 살 수 있는 패키지 개수
		int pack_price = Integer.MAX_VALUE; 
		for(int i=0; i<M; i++) {
			int min = Math.min(pack_num * pack[i], (N - N % 6) * unit[i]);
			pack_price = Math.min(min, pack_price);
		}
		
		int unit_num = N % 6; // 살 수 있는 낱개 개수
		int unit_price = Integer.MAX_VALUE;
		for(int i=0; i<M; i++) {
			int min = Math.min(pack[i], unit_num * unit[i]);
			unit_price = Math.min(min, unit_price);
		}
		
		System.out.println(pack_price + unit_price);
	}
}
