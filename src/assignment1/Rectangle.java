package assignment1;
public class Rectangle {

    public static double calculateArea(double len, double width){
        return len * width;
    }

    public static void main(String[] args) {
        System.out.println(calculateArea(4.0, 5.9));
    }
}
