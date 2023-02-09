import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] stack; // stack 요소 담을 배열
	public static int size = 0; // stack 요소의 개수
	
	// 정수를 stack에 넣는 push
	public static void push(int X) {
		stack[size]=X;
		size++;
	}
	
	// stack에서 가장 위에 있는 정수를 빼고 그 수를 출력하는 pop
	public static int pop() {
		if(size==0) {
			return -1; // stack에 정수 없을 경우 -1 출력
		}
		else {
			int res = stack[size-1]; // size(가장 위에 있는)번째 요소 (배열에서 n번째 요소 index는 n-1)
			stack[size-1]=0; // stack안에 가장 위에 있는 수를 빼내는 것이므로
			size--; // 가장 위에 있는 정수 빼내므로 요소가 1개 줄어듦
			return res;
		}
	}
	
	// stack에 들어 있는 정수 개수 출력하는 size
	public static int size() {
		return size;
	}
	
	// stack이 비어있는지 확인하는 empty
	public static int empty() {
		if(size==0)
			return 1;
		else
			return 0;
	}
	
	// stack 가장 위에 있는 정수 출력하는 top, pop과 다르게 그 수를 빼지 않음
	public static int top() {
		if(size==0)
			return -1;
		else {
			return stack[size-1];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 명령의 수
		stack = new int[N]; // stack에는 최대 N개의 원소가 들어갈 수 있음 (N번 반복하기 때문)
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " "); // 각 줄마다 입력한 문자열을 " "을 기준으로 분리
			
			switch(st.nextToken()) {
			
			case "push":
				push(Integer.parseInt(st.nextToken())); // push 다음에 오는 숫자를 stack에 넣기
				break;
				
			case "pop":
				sb.append(pop()).append("\n");
				break;
				
			case "size":
				sb.append(size()).append("\n");
				break;
				
			case "empty":
				sb.append(empty()).append("\n");
				break;
				
			case "top":
				sb.append(top()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

}

// 검색, 참고하여 
