package practice.DSA.practice;

public class MinStack {
    Node topNode;
    Node minNode;

    static class Node {
        int data;
        Node next;
        Node nextMin;

        public Node(int x){
            this.data = x;
        }
    }

    public void push(int x){
        Node newNode = new Node(x);
        if(topNode == null){
            topNode = newNode;
            minNode = newNode;
        }
        else {
            newNode.next = topNode;
            topNode = newNode;
            if(newNode.data < minNode.data){
                newNode.nextMin = minNode;
                minNode = newNode;
            }
        }
    }

    public void pop(){
        if(minNode == topNode){
            minNode = topNode.nextMin;
        }
        topNode = topNode.next;
    }

    public int top(){
        return topNode.data;
    }

    public int getMin(){
        return minNode.data;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(16);
        stack.push(-1);
        stack.push(3);
        stack.push(23);
        stack.pop();
        System.out.println(stack.top());
        stack.push(30);
        System.out.println(stack.getMin());
    }
}
