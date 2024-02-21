package com.jjw.jse0524;

import java.util.Scanner;

import com.jjw.jse0524.BinarySearchTree.TreeNode;

public class BinarySearchTree2 {
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
	
	// 아래 2개의 메소드 insertKey, delete를 완성하시오.
	
	/**
	 * 교재 p.325 참조
	 * 이원탐색트리의 노드 t에 데이터 x를 추가한다. 순환함수로 작성해야 한다.
	 * @param t 이원탐색트리의 노드. 이 노드 아래에 데이터를 삽입한다.
	 * @param x 삽입하고자 하는 데이터
	 * @return 사입한 이원탐색트리의 부모 노드
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

	
	private void delete(String x) { // 삭제 연산 안함
		
		delete(this.rootNode, x);
		
	}
	
	private TreeNode delete(TreeNode rootNode, String x) {
		
		if(rootNode == null) { return rootNode; }
		
		if(x.compareTo(rootNode.key) < 0) {
			rootNode.left = delete(rootNode.left, x);
		} else if(rootNode.key.compareTo(x) < 0) {
			rootNode.right = delete(rootNode.right, x);
		} 
		
		else {
			if(rootNode.left == null && rootNode.right == null) {
				return null;
			} else if(rootNode.left == null) {
				return rootNode.right;
			} else if(rootNode.right == null) {
				return rootNode.left;
			}
			
//			rootNode.key = findMin(rootNode.right);
			rootNode.right = delete(rootNode.right, rootNode.key);
		}
		
		return rootNode;
	}
	
//	private String findMin(TreeNode rootNode) {
//		String min= rootNode.key;
//
//		while (rootNode.left != null){
//	    	 rootNode = rootNode.left;
//	    	 min = rootNode.key;
//	    }
//		return min;
//	}
}
	
class Main2 {
	
	// 아래 main 메소드는 수정하지 마시오.
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



//
//TreeNode node = rootNode;
//TreeNode parent = rootNode;
//
//boolean isLeft = true;
//
//while(node.key != x) {
//	parent = node;
//	
//	if(x.compareTo(node.key) < 0) {
//		isLeft = true;
//		node = parent.left;
//	} else {
//		isLeft = false;
//		node = parent.right;
//	}
//	
//	if(node == null) {
//		return false;
//	}
//}
//
//TreeNode replacement;
//
//if(node.left == null && node.right == null) {	
//	if(node == rootNode) {
//		rootNode = null;
//	} else if(isLeft) {
//		parent.left = null;
//	} else {
//		parent.right = null;
//	}
//}
//
//else if(node.right == null) {
//	replacement = node.left;
//	
//	if(node == rootNode) {
//		rootNode = replacement;
//	} else if(isLeft) {
//		parent.left = replacement;
//	} else {
//		parent.right = replacement;
//	}
//}
//
//else if(node.left == null) {
//	replacement = node.right;
//	
//	if(node == rootNode) {
//		rootNode = replacement;
//	} else if(isLeft) {
//		parent.left = replacement;
//	} else {
//		parent.right = replacement;
//	}
//}
//
//else {
//	TreeNode rightSubTree = node.right;
//	
//	replacement = getRightMinNode(node.right);
//	
//	if(node == rootNode) {
//		rootNode = replacement;
//	} else if(isLeft) {
//		parent.left = replacement;
//	} else {
//		parent.right = replacement;
//	}
//	
//	replacement.right = rightSubTree;
//	
//	if(replacement == rightSubTree) {
//		replacement.right = null;
//	}
//	
//	replacement.left = node.left;
//
//}
//
//return true;



//private TreeNode getRightMinNode(TreeNode rightChildRoot) {
//    TreeNode parent = rightChildRoot;
//    TreeNode node = rightChildRoot;
//
//    while (node.left != null) {
//        parent = node;
//        node = node.left;
//    }
//
//    parent.left = null;
//    return node;
//}

