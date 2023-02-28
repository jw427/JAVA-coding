import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	char data;
	Node left, right;
	Node(char data){
		this.data = data;
	}
}

public class Main {
	public static Node root;
	
	public static void Add(char data, char leftData, char rightData) {
		if(root == null) {
			root = new Node(data);
			if(leftData != '.')
				root.left = new Node(leftData);
			if(rightData != '.')
				root.right = new Node(rightData);
		} else { // 루트가 null이 아니라면 탐색
			Search(root, data, leftData, rightData);
		}
	}
	
	public static void Search(Node root, char data, char leftData, char rightData) {
		if(root == null) // 루트가 null이면 종료
			return;
		// 루트의 데이터가 data라면 (위치를 찾았다면)
		else if(root.data == data) {
			if(leftData != '.') root.left = new Node(leftData);
			if(rightData != '.') root.right = new Node(rightData);
		} else { // 찾지 못했다면
			Search(root.left, data, leftData, rightData);
			Search(root.right, data, leftData, rightData);
		}
	}
	
	// 전위순회
	public static void preorder(Node root) {
		// 루트 -> 왼쪽 -> 오른쪽
		System.out.print(root.data);
		if(root.left != null) preorder(root.left);
		if(root.right != null) preorder(root.right);
	}
	
	// 중위순회
	public static void inorder(Node root) {
		// 왼쪽 -> 루트 -> 오른쪽
		if(root.left != null) inorder(root.left);
		System.out.print(root.data);
		if(root.right != null) inorder(root.right);
	}
	
	// 후위순회
	public static void postorder(Node root) {
		// 왼쪽 -> 오른쪽 -> 루트
		if(root.left != null) postorder(root.left);
		if(root.right != null) postorder(root.right);
		System.out.print(root.data);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 노드 개수
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			Add(root, left, right);
		}
		
		preorder(root);
		System.out.println();
		inorder(root);
		System.out.println();
		postorder(root);
	}
}
