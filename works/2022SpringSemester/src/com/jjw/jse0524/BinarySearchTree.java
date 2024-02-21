package com.jjw.jse0524;

import java.util.Scanner;

class BinarySearchTree {
	class TreeNode {
		String key;
		TreeNode left;
		TreeNode right;
	}
	
	private TreeNode rootNode;
	
	public void insert(String x) {
		rootNode = insertKey(rootNode, x);
	}
	
	public TreeNode find(String x) {
		TreeNode t = rootNode;
		int result;
		
		while (t != null) {
			if ((result = x.compareTo(t.key)) < 0) {
				t = t.left;
			} else if (result == 0) {
				return t;
			} else {
				t = t.right;
			}
		}
		
		return t;
	}
	
	private void printNode(TreeNode n) {
		if (n != null) {
			System.out.print("(");
			printNode(n.left);
			System.out.print(n.key);
			printNode(n.right);
			System.out.print(")");
		}
	}
	
	public void print() {
		printNode(rootNode);
		System.out.println();
	}
	
	// �Ʒ� 2���� �޼ҵ� insertKey, delete�� �ϼ��Ͻÿ�.
	
	/**
	 * ���� p.325 ����
	 * �̿�Ž��Ʈ���� ��� t�� ������ x�� �߰��Ѵ�. ��ȯ�Լ��� �ۼ��ؾ� �Ѵ�.
	 * @param t �̿�Ž��Ʈ���� ���. �� ��� �Ʒ��� �����͸� �����Ѵ�.
	 * @param x �����ϰ��� �ϴ� ������
	 * @return ������ �̿�Ž��Ʈ���� �θ� ���
	 */
	private TreeNode insertKey(TreeNode t, String x) {
		
		if(t == null) {
			TreeNode newNode = new TreeNode();
			newNode.key = x;
			return newNode;
		} else if(x.compareTo(t.key) < 0) {
			t.left = insertKey(t.left, x);
			return t;
		} else if(x.compareTo(t.key) > 0){
			t.right = insertKey(t.right, x);
			return t;
		} else {
			return t;
		}
		
	}

	
//	private boolean delete(String key) { // ���� ���� ����
//		
//		TreeNode node = rootNode;
//		TreeNode parent = rootNode;
//		
//		boolean isLeft = true;
//		
//		while(node.key != key) {
//			parent = node;
//			
//			if(key.compareTo(node.key) < 0) {
//				isLeft = true;
//				node = parent.left;
//			} else {
//				isLeft = false;
//				node = parent.right;
//			}
//			
//			if(node == null) {
//				return false;
//			}
//		}
//		
//		TreeNode replacement;
//		
//		if() {
//			
//		}
//		
//	}

}
	
class Main {
	
	// �Ʒ� main �޼ҵ�� �������� ���ÿ�.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BinarySearchTree tree = new BinarySearchTree();
		
		while (scan.hasNext()) {
			String command = scan.next();
			
			if (command.equals("I")) {
				String data = scan.next();
				tree.insert(data);
			} else if (command.equals("P")) {
				tree.print();
			}
		}
		scan.close();
	}
	
}