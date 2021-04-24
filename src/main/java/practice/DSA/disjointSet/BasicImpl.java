package practice.DSA.disjointSet;

/*
* 	Time Complexity: O(N^2)
* */

public class BasicImpl extends DisjointSet {

	BasicImpl(int N) {
		super(N);
	}

	@Override
	public boolean find(int a, int b) {
		return arr[a] == arr[b];
	}

	@Override
	public void union(int child, int root) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == arr[child]) {
				arr[i] = arr[root];
			}
		}
	}
}
