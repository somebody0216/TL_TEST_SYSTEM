package pojo;

public class user {
    private String userid;
    private  String password;
    private  String phone;
    private  String email;



        @Override
    public String toString() {
        return "user{" +
                "userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public user(String userid, String password, String phone, String email) {
        this.userid = userid;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public user() {
    }
}
