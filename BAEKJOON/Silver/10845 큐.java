import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] queue; // queue 요소 담을 배열
	public static int first=0; // 첫 번째 요소 index
	public static int last=0; // 마지막 요소 index (기존 index에서 +1한 값)
	
	// 정수를 queue에 넣는 push
	public static void push(int X) {
		queue[last]=X;
		last++; // 요소가 추가될 때마다 마지막 요소의 index는 증가함
	}
	
	// queue에서 가장 앞에 있는 정수를 빼고 그 수를 출력하는 pop
	public static int pop() {
		if(first==last)
			return -1; // queue에 정수가 없다는 것은 첫번째 index와 마지막 index가 같다는 뜻
		else {
			int res = queue[first]; // 첫 번째 요소 저장
			queue[first]=0; // queue 가장 앞에 있는 요소를 빼내는 것이므로 첫 번째 요소를 0으로 바꿈
			first++; // 첫 번째 요소는 그 다음번째 요소로 바뀌기 때문
			return res;
		}
	}
	
	// queue에 들어 있는 정수 개수 출력하는 size
	public static int size() {
		return last-first;
	}
	
	// queue가 비어있는지 확인하는 empty
	public static int empty() {
		if(first==last) {
			return 1;
		}else
			return 0;
	}
	
	// queue의 가장 앞에 있는 정수 출력하는 front, pop과 다르게 그 수를 빼지 않음
	public static int front() {
		if(first==last)
			return -1;
		else
			return queue[first];
	}
	
	// queue의 가장 뒤에 있는 정수 출력하는 back
	public static int back() {
		if(first==last)
			return -1;
		else
			return queue[last-1]; // last는 기존 마지막 index에 +1한 값이기 때문
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 명령의 수
		queue = new int[N]; // queue에는 최대 N개의 원소가 들어갈 수 있음
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " "); // 각 줄마다 입력한 문자열을 " "을 기준으로 분리
			
			switch(st.nextToken()) {
			
			case "push":
				push(Integer.parseInt(st.nextToken())); // push 다음에 오는 숫자를 queue에 넣기
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
				
			case "front":
				sb.append(front()).append("\n");
				break;
				
			case "back":
				sb.append(back()).append("\n");
				break;
			}
		}
		
		System.out.println(sb);
	}

}
