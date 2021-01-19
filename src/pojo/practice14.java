package pojo;

public class practice14 {


    private  String age;
    private  String name;
    private String password;

    @Override
    public String toString() {
        return "practice14{" +
                "age='" + age + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public practice14(String age, String name, String password) {
        this.age = age;
        this.name = name;
        this.password = password;
    }

    public practice14() {
    }
}
