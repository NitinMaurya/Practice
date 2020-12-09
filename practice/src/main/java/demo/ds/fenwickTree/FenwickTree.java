package demo.ds.fenwickTree;

/*

Used to find the sum of the array for the given indices. ex- getSum(arr, i, j)
Majority used when there are lot of frequent updates are happening in the array and also to find the sum of array
at the same time.
Contains three main methods:
-> getSum(arr, i) [O(log(n))] : find the sum of elements from index 0 to i of the array.
-> updateTree(arr, i, val) [O(log(n))] : update the index i with the given value val in the fenwick tree.
-> constructTree(arr) [O(nlog(n))] : creates the fenwick tree of given array arr.

Total space complexity: [O(n)]
*/
public interface FenwickTree{
    int getSum(int index);

    int getSum(int startIndex, int endIndex);

    void updateTree(int arraySize, int index, int value);

    void print();
}
