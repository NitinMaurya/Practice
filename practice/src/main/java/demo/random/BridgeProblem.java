package demo.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BridgeProblem {

    static class Point{
        private int x;
        private int y;
        private double originDistance;

        Point(int x, int y){
            this.x = x;
            this.y = y;
            this.originDistance = Math.sqrt((x*x) + (y*y));
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public double getOriginDistance() {
            return originDistance;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int xi = 0;
        int yi = 0;
        List<Point> points = new ArrayList<>();
        for(int i = 0; i < 2*n; i++){
            xi = scanner.nextInt();
            yi = scanner.nextInt();
            points.add(new Point(xi, yi));
        }
        double sum = 0.0;
        points.sort((o1, o2) -> (int) (o1.getOriginDistance() - o2.getOriginDistance()));
        Point[] pointsArray = points.toArray(new Point[0]);
        for(int i = 1; i < pointsArray.length; i+=2){
            sum = sum + distance(pointsArray[i-1], pointsArray[i]);
        }
        System.out.println(sum);
    }

    private static double distance(Point pointX, Point pointY) {
        int a = (pointY.getX() - pointX.getX());
        int b = (pointY.getY() - pointX.getY());
        return Math.sqrt(a*a + b*b);
    }
}
