package clone;

/**
 * @author zyh
 * @date 2020/5/12
 */
public class Car implements Cloneable {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Car clone() {
        Car c = null;
        try {
            c = (Car)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public String toString() {
        return "Car{" + "name='" + name + '\'' + '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Car a = new Car("aa");
        Car b = a.clone();
        b.setName("bb");
        System.out.println(a);
        System.out.println(b);
    }
}
