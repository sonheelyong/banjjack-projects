package com.green.vo;

public class NoteVo {

    private int _id;
    private String content;
    private String recept;
    private String send;
    private String time;

    public NoteVo(int _id, String content, String recept, String send, String time) {
        this._id = _id;
        this.content = content;
        this.recept = recept;
        this.send = send;
        this.time = time;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRecept() {
        return recept;
    }

    public void setRecept(String recept) {
        this.recept = recept;
    }

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MsgVo{" +
                "_id=" + _id +
                ", content='" + content + '\'' +
                ", recept='" + recept + '\'' +
                ", send='" + send + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
