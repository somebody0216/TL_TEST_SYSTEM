package pojo;

import java.util.ArrayList;
import java.util.List;

public class practice15 {
    private String name="哈哈";
    private String[] phone=new String[]{"123","234"};
    private List al= new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhone() {
        return phone;
    }

    public void setPhone(String[] phone) {
        this.phone = phone;
    }

    public List getAl() {
        return al;
    }

    public void setAl(List al) {
        this.al = al;
    }
}
