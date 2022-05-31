package ru.stqa.pft.sandbox;

public class MyProgram {
    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point();
        p1.p1 = 3.4;
        p2.p2 = 5.6;
        System.out.println("Расстояние между двумя точками равна: " + distance(p1, p2));
    }
    public static double distance(Point p1, Point p2) {
            return Math.sqrt(p1.p1 + p2.p2);
        }
}
