package quarter.one.level.one.lesson.five;

public class Person {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println("Person: " + name + "\n"
                + "position: " + position + "\n"
                + "email: " + email + "\n"
                + "phone: " + phone + "\n"
                + "salary: " + salary + "\n"
                + "age: " + age + "\n");
    }
}
