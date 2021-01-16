package practice.DSA.disjointSet;

/*
* 	Time Complexity: O(log2N)
* */

import java.util.Arrays;

public class BalancedImpl extends DisjointSet {
	int[] size;

	BalancedImpl(int N) {
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
