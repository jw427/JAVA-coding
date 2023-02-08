import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue card = new LinkedList();
		
		for(int i=1; i<=N; i++) {
			card.offer(i);
		} // queue card에 1부터 N까지 순차적으로 저장
		
		while(N>=2) {
			card.remove(); // 가장 첫 번째 카드 버리기
			N--;
			if(N==1) break;
			
			int first = (int) card.peek(); // card의 첫 번째 값을 변수에 저장
			card.remove(); // 가장 첫 번째 카드 버리기
			card.offer(first); // 버렸던 첫 번째 카드 마지막으로
		}
		
		System.out.println(card.peek());
	}

}
