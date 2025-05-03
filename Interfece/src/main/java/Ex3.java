
interface Figure{

    double PI = 3.14;

    double getArea();
    double getPerimeter();
    void show();
}

class Square implements Figure {
    int side;

    public Square(int side){
        this.side = side;
    }

    @Override
    public double getArea() {
        return Math.pow(side, 2);
    }

    @Override
    public double getPerimeter() {
        return side * 4;
    }

    @Override
    public void show() {
        System.out.println("Side of the square: " + side);
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println("Area: " + getArea());
    }
}

class Triangle implements Figure{

    public enum TypeOfTriangle {
        Isoscel, Equilateral, Scalene;
    }

    int side1, side2, side3;

    public Triangle(int side1, int side2, int side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public TypeOfTriangle getTypeOfTriangle(){
        if (side1 == side2 && side2 == side3)
            return TypeOfTriangle.Equilateral;
        else if (side1 == side2 || side2 == side3 || side1 == side3)
            return TypeOfTriangle.Isoscel;
        else
            return TypeOfTriangle.Scalene;
    }

    public void printTypeOfTriangle(){
        System.out.println(getTypeOfTriangle());
    }


    @Override
    public double getArea() {
        double p = getSemiPerimeter();
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));

    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public double getSemiPerimeter(){
        return getPerimeter() / 2;
    }

    @Override
    public void show() {
        System.out.println("Sides of the triangle: " + side1 + ", " + side2 + ", " + side3);
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println("Semiperimeter: " + getSemiPerimeter());
        System.out.println("Area: " + getArea());
    }
}

class Rectangle implements Figure{

    int side1, side2;

    public Rectangle(int side1, int side2){
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double getArea() {
        return side1 * side2;
    }

    @Override
    public double getPerimeter() {
        return (side1 + side2) * 2;
    }

    @Override
    public void show() {
        System.out.println("Sides of the rectangle: " + side1 + " " + side2);
        System.out.println("Perimter: " + getPerimeter());
        System.out.println("Area: " + getArea());
    }
}

public class Ex3{

    public static void main(String[] args) {

        Triangle triangle = new Triangle(4, 4, 2);
        triangle.printTypeOfTriangle();
        System.out.println(triangle.getArea());
        System.out.println(triangle.getPerimeter());
        triangle.show();

    }
}

