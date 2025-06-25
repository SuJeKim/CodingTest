import java.io.*;
import java.util.*;

class Node{
	
	char data;
	Node left;
	Node right;
	
	Node(char data){
		this.data = data;
	}
}

public class Main {
	
	private Node root;
	private StringBuilder sb = new StringBuilder();
	
	private void add(char data, char left, char right) {
		if(data == 'A') {
			root = new Node(data);
			if(left != '.') root.left = new Node(left);
			if(right != '.') root.right = new Node(right);
		}else {
			search(root, data, left, right);
		}
	}

	private void search(Node node, char data, char left, char right) {
		if(node == null) return;
		if(node.data == data) {
			if(left != '.') node.left = new Node(left);
			if(right != '.') node.right = new Node(right);
		} else {
			search(node.left, data, left, right);
			search(node.right, data, left, right);
		}
		
	}
	
	// 전위, 후위, 중위
	private void preOrder(Node node) {
		if(node == null)return;
		sb.append(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	private void inOrder(Node node) {
		if(node == null)return;
		inOrder(node.left);
		sb.append(node.data);
		inOrder(node.right);
	}

	private void postOrder(Node node) {
		if(node == null)return;
		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.data);
	}
	
	private void prt() {
		preOrder(root);
		sb.append("\n");
		inOrder(root);
		sb.append("\n");
		postOrder(root);
		System.out.println(sb);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Main tree = new Main();
		int n = Integer.parseInt(br.readLine());
		char[] data;
		while(n --> 0) {
			data = br.readLine().toCharArray();
			tree.add(data[0], data[2], data[4]);
		}
		tree.prt();
	}

}
