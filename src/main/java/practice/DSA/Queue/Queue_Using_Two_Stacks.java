package practice.DSA.Queue;

import java.io.*;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*

  MyQ is Queue data structure which is implemented using two Stacks.
  The benefit of this approach is that we can implement sliding window like algorithms with fixed window.
  
  Pair<Integer, Integer> = Pair of actual element and the next min/max element.
*/

record Pair<F, S>(F key, S value) {

    public F getKey() {
        return key;
    }

    public S getValue() {
        return value;
    }

}

class MyQ {
    Stack<Pair<Integer, Integer>> inbox = new Stack<>();
    Stack<Pair<Integer, Integer>> outbox = new Stack<>();
    
    public void add(int value) {
        if (inbox.isEmpty()) {
            inbox.push(new Pair<>(value, value));
        } else {
            inbox.push(new Pair<>(value, Math.max(value, inbox.peek().getValue())));
        }
    }
    
    public void remove() {
        if (outbox.isEmpty()) {
            while(!inbox.isEmpty()) {
                Pair<Integer, Integer> element = inbox.pop();
                int max = outbox.isEmpty() 
                    ? element.getKey() 
                    : Math.max(element.getKey(), outbox.peek().getValue());
                    
                outbox.push(new Pair<>(element.getKey(), max));
            }
        }
        outbox.pop();
    }
    
    public int getMax() {
        if (inbox.isEmpty() || outbox.isEmpty()) {
            return inbox.isEmpty() ? outbox.peek().getValue() : inbox.peek().getValue();
        } else {
            return Math.max(inbox.peek().getValue(), outbox.peek().getValue());
        }
    }
    
    public void print() {
        System.out.println("Inbox: " + inbox);
        System.out.println("Outbox: " + outbox);
    }
}

class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY queries
     */

    public static List<Integer> solve(List<Integer> arr, List<Integer> queries) {
        return queries.stream()
        .map(q -> calculate(arr, q))
        .collect(Collectors.toList());
    }
    
    public static int calculate(List<Integer> array, int segmentSize) {
        MyQ q = new MyQ();        
        for ( int i = 0; i < segmentSize; i++) {
            q.add(array.get(i));
        }
        
        int min = q.getMax();
        
        for ( int i = segmentSize; i < array.size(); i++) {
            q.remove();
            q.add(array.get(i));
            min = Math.min(min, q.getMax());
        }
                
        return min;
    }

}

public class Queue_Using_Two_Stacks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> queries = IntStream.range(0, q).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.solve(arr, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
