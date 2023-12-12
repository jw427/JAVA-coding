class Solution {
    public int solution(String s) {
        int answer = 0; // 출력할 결과
        int length = s.length(); // 문자열 s의 길이
        if (s.charAt(0) == '+') { // 맨 앞에 부호 +가 있을 경우
            for(int i=1; i<s.length(); i++) {
                length--;
                answer += (s.charAt(i)-'0') * Math.pow(10, length-1);
            }
        } else if(s.charAt(0) == '-') { // 맨 앞에 부호 -가 있을 경우
            for(int i=1; i<s.length(); i++) {
                length--;
                answer -= (s.charAt(i)-'0') * Math.pow(10, length-1);
            }
        } else { // 맨 앞에 부호가 없을 경우
            for(int i=0; i<s.length(); i++) {
                answer += (s.charAt(i)-'0') * Math.pow(10, length-1);
                length--;
            }
        }
        return answer;
    }
}
