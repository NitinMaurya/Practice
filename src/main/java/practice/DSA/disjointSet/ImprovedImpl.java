package practice.DSA.disjointSet;

/*
* 	Time Complexity: O(N)
* */

public class ImprovedImpl extends DisjointSet {

	ImprovedImpl(int N) {
		super(N);
	}

	@Override
	public boolean find(int a, int b) {
		return root(a) == root(b);
	}

	private int root(int i) {
		while(arr[i] != i) {
			i = arr[i];
		}
		return arr[i];
	}

	@Override
	public void union(int a, int b) {
		int rootA = root(a);
		int rootB = root(b);
		arr[rootA] = rootB;
	}
}
