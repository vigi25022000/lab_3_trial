package com.greatlearning.q2;

import java.util.HashSet;

public class FindSumPair {

	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	private static TreeNode insertTreeNode(TreeNode root, int data) {
		//base terminal condition
		if(root == null) {
			return new TreeNode(data);
		}
		if(root.data > data) {
			root.left = insertTreeNode(root.left, data);
		}else {
			root.right = insertTreeNode(root.right, data);
		}
		return root;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = null;
		
		root = insertTreeNode(root,40);
		root = insertTreeNode(root,20);
		root = insertTreeNode(root,60);
		root = insertTreeNode(root,10);
		root = insertTreeNode(root,30);
		root = insertTreeNode(root,50);
		root = insertTreeNode(root,70);
		
		int sum = 130; 
		
		boolean result = findSumPair(root,sum);
		
		if(!result) {
			System.out.println("No Such pair Exists");
		}
		
		//Binary Tree as given input
		System.out.println("Tree Constructed");
		//10,20,30,40,50,60,70 = int[]
		//  
		
	}
	// Hashset Created, For every traversal
			// Sum  = 130 = reading element (40) + compliment(90)
			// This compliement is already present in Hashset, If so we will print the pairs
			// If it is not present , we will add reading element into hashset.
			// Iterate over the entire, We will print no pairs exists
			// Arraylist(1000)   43 is present in  this arraylist. O(n)
			// Hashset(1000)  43 is present in  this hashset. 43 -> jgjkfdjh -> O(1)
	private static boolean findSumPair(TreeNode root, int sum) {
		HashSet<Integer> data = new HashSet<Integer>();
		return isPairExists(root,data,sum);
	}

	private static boolean isPairExists(TreeNode root, HashSet<Integer> data, int sum) {
		// Base terminal condition
		if(root == null)
			return false;
		
		int comp = sum - root.data;
		
		if(data.contains(comp)) {
			System.out.println("The sum pair exists for the sum "+sum+" : "+ root.data+ " & "+ comp);
			return true;
		}else {
			data.add(root.data);
		}
		
		return isPairExists(root.left, data, sum) || isPairExists(root.right, data, sum);
	}

	

}