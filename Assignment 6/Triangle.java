public class Triangle {

    double side1;
    double side2;
    double side3;

    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {

        if(side1 + side2 < side3) {
            throw new IllegalTriangleException("Sum of side 1 and side 2 is less than side 3");
        }else if(side1 + side3 < side2) {

            throw new IllegalTriangleException("Sum of side 1 and side 3 is less than side 2");
        }else if (side2 + side3 < side1) {

            throw new IllegalTriangleException("Sum of side 2 and side 3 is less than side 1");

        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    public String toString() {
        return  getClass().getName() +
                " side 1=" + side1 +
                ", side 2=" + side2 +
                ", side 3=" + side3;
    }
}

