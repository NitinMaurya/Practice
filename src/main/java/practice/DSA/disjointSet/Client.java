package practice.DSA.disjointSet;

import practice.DSA.leetcode.ArrayUtils;

public class Client {
	public static void main(String[] args) {
		System.out.println("*********Basic********");
		DisjointSet disjointSet = new BasicImpl(10);
		disjointSet.union(2, 1);
		disjointSet.union(4, 3);
		disjointSet.union(8, 4);
		disjointSet.union(9, 3);
		disjointSet.union(6, 5);
		System.out.println("isConnected(0,7) = " + disjointSet.find(0,7));
		System.out.println("isConnected(8,9) = " + disjointSet.find(8,9));
		ArrayUtils.print(disjointSet.arr);


		System.out.println("*********Improved********");
		disjointSet = new ImprovedImpl(6);
		disjointSet.union(1, 0);
		disjointSet.union(0, 2);
		disjointSet.union(3, 4);
		disjointSet.union(1, 4);
		ArrayUtils.print(disjointSet.arr);


		System.out.println("*********Balanced********");
		disjointSet = new BalancedImpl(6);
		disjointSet.union(0, 1);
		disjointSet.union(1, 2);
		disjointSet.union(3, 2);
		ArrayUtils.print(disjointSet.arr);


		System.out.println("*********BalancedAndPathCompressed********");
		disjointSet = new BalancedImpl(6);
		disjointSet.union(0, 1);
		disjointSet.union(1, 2);
		disjointSet.union(3, 2);
		ArrayUtils.print(disjointSet.arr);

	}
}
