package top.gonghaojing.controller;

public class Result {
    private int id;
    private Object data;
    private String msg;

    public Result(int id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

    public Result() {
    }

    public Result(int id, Object data) {
        this.id = id;
        this.data = data;
    }

    public Result(int id, Object data, String msg) {
        this.id = id;
        this.data = data;
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
