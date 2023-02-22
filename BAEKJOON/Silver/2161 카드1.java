import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Integer> q = new LinkedList<Integer>();
		int N = Integer.parseInt(br.readLine());
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		while(q.size()>1) {
			sb.append(q.poll()).append(" ");
			q.add(q.poll());
		}
		sb.append(q.peek());
		System.out.println(sb);
	}
}
