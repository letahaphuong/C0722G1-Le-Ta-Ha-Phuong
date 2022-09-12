package ss5_access_modifier_static_method_static_property.excersice.circle;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.getArea();
        System.out.println(circle.getRadius() + circle.getArea());
    }
}
