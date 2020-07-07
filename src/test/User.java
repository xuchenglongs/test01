package test;

public class User implements Comparable<User> {

    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public int compareTo(User o) {
        if (o == null) {
            return 0;
        }
        if (this.getAge() - o.getAge() == 0) {
            return 0;
        }
        return this.getAge()-o.getAge()>0?1:-1;
    }
}
