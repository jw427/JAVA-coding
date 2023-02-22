import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> pocketmon = new HashMap<>(); // 키가 숫자
		HashMap<String, Integer> number = new HashMap<>(); // 키가 이름
		
		for(int t=1; t<=N; t++) {
			String s = br.readLine();
			pocketmon.put(t, s);
			number.put(s, t);
		}
		
		for(int i=1; i<=M; i++) {
			String check = br.readLine();
			if(isNumber(check)) // 숫자일 경우
				System.out.println(pocketmon.get(Integer.parseInt(check)));
			else
				System.out.println(number.get(check));
		}
	}
	public static boolean isNumber(String s) {
		for(int i=0; i<s.length(); i++) {
			if(!Character.isDigit(s.charAt(i))) { // 숫자가 아닐 경우
				return false;
			}		
		}
		return true; // 숫자일 경우
	}
	
}
