package practice.DSA.segmentTree;

public interface SegmentTree {

    void build(int[] array);

    void update(int[] array, int index, int newValue);

    int query(int[] array, int left, int right);

    void print();
}
