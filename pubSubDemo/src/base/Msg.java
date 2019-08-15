package base;

/**
 * Created by zhaoziyun on 2019/4/9.
 */
public class Msg<M> {
    private String publisher;
    private String topic;
    private M m;

    public Msg(String publisher, String topic, M m) {
        this.publisher = publisher;
        this.topic = topic;
        this.m = m;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }
}
