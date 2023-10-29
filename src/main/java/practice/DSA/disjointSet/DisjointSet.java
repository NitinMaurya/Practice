package practice.DSA.disjointSet;

/*
 *	Disjoint Set or Union find Data Structure:
 * 		Used for problems like connected components in a graph.
 *
 *  	find(a,b) => checks if a and b are connected
 *
 * 		Union(a,b) => connects a and b
 * */
public abstract class DisjointSet {
	protected int[] arr;

	DisjointSet(int N) {
		this.arr = new int[N];
		initialize(arr);
	}

	private void initialize(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
	}

	abstract boolean find(int child, int root);

	abstract void union(int child, int root);
}
