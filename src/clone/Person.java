package clone;

import java.io.Serializable;

/**
 * @author zyh
 * @date 2020/5/12
 */
public class Person implements Serializable {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" + "age=" + age + ", name='" + name + '\'' + '}';
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
