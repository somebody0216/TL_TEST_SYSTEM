package pojo;

public class test {
    private String t_type;
    private  String c_id;
    private  String t_topic;
    private  String creat_time;

    public test(String t_type, String c_id, String t_topic, String creat_time) {
        this.t_type = t_type;
        this.c_id = c_id;
        this.t_topic = t_topic;
        this.creat_time = creat_time;
    }

    @Override
    public String toString() {
        return "test{" +
                "t_type='" + t_type + '\'' +
                ", c_id='" + c_id + '\'' +
                ", t_topic='" + t_topic + '\'' +
                ", creat_time='" + creat_time + '\'' +
                '}';
    }

    public String getT_type() {
        return t_type;
    }

    public void setT_type(String t_type) {
        this.t_type = t_type;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getT_topic() {
        return t_topic;
    }

    public void setT_topic(String t_topic) {
        this.t_topic = t_topic;
    }

    public String getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(String creat_time) {
        this.creat_time = creat_time;
    }

    public test() {
    }
}
