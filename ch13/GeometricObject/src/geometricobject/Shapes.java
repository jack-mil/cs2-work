package geometricobject;

class Circle extends GeometricObject {
    private double radius = 0;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.pow(this.radius, 2) * Math.PI;
    }
}

class Rectangle extends GeometricObject {
    private double width = 0;
    private double length = 0;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double getArea() {
        return this.width * this.length;
    }
}