package HomeWork1;

public class Square extends Figure{
    private double side;

    public Square(double side){
        this.side = side;
    }

    @Override
    double getPerimeter() {
        return side*4;
    }
}
