public class Person {
    private String name;
    private int age;
    public void setName(String newName) {
        name = newName;
    }

    public void setAge(int newAge) {
        if (newAge >= 0) {
            age = newAge;
        }
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
