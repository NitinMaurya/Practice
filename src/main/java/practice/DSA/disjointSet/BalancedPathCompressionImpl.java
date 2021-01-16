package practice.DSA.disjointSet;

/*
* 	Time Complexity: O(logN)
* */

import java.util.Arrays;

public class BalancedPathCompressionImpl extends DisjointSet {
	int[] size;

	BalancedPathCompressionImpl(int N) {
		super(N);
		size = new int[N];
		Arrays.fill(size, 1);
	}

	@Override
	public boolean find(int a, int b) {
		return root(a) == root(b);
	}

	private int root(int i) {
		while(arr[i] != i) {
			arr[i] = arr[arr[i]]; // set each i to point to its grandparent (thereby halving the length of the path)
			i = arr[i];
		}
		return i;
	}

	@Override
	public void union(int a, int b) {
		int rootA = root(a);
		int rootB = root(b);
		if (size[rootA] < size[rootB]) {
			arr[rootA] = arr[rootB];
			size[rootB] += size[rootA];
		} else {
			arr[rootB] = arr[rootA];
			size[rootA] += size[rootB];
		}
	}
}
