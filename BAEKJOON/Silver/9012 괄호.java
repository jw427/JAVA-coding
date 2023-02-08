import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트 개수 T
		
		for(int i=0; i<T; i++) {
			Stack VPS = new Stack();
			String par = br.readLine(); // 괄호 문자열
			String out = "YES"; // 검사후 출력할 값의 초기값
			// 괄호문자열에서 '('을 만나면 스택에 저장, ')'을 만나면 스택에서 값을 하나씩 꺼낸다.
			for(int j=0; j<par.length(); j++) {
				if(par.charAt(j)=='(') // 만약 괄호문자열의 j번째 값이 '('이면
					VPS.push('('); // 스택에 값 저장
				else if(VPS.isEmpty()) { // 만약 괄호문자열의 j번째 값이 ')'이면서 스택이 비어있으면 더 이상 스택에서 값을 꺼낼 수 없으므로
					out = "NO"; // 괄호문자열은 올바른 괄호문자열이 아니고
					break; // 진행불가이므로 break
				}else // 그 외의 경우 (괄호문자열의 j번째 값이 ')'이면서 스택은 비어있지 않음
					VPS.pop(); // 스택에서 값 하나씩 꺼냄
			} // 반복이 완전히 끝나고 스택이 빈 값일 경우 올바른 괄호문자열
			if(!VPS.isEmpty()) { // 반복이 완전히 끝나고 스택이 비어있지 않은 경우
				out = "NO"; // 올바른 괄호문자열이 아니다.
			}
			System.out.println(out); // VPS인지 여부 출력
		}
	}

}
