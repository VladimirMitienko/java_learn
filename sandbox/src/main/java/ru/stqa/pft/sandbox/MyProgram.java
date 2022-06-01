package ru.stqa.pft.sandbox;

public class MyProgram {
    public static void main(String[] args) {
        Point p = new Point(3.4, 5.6);

        System.out.println("Расстояние между двумя точками равна: " + distance(p));
    }
    public static double distance(Point p) {
        return Math.sqrt(p.p1 + p.p2);
        }
}
