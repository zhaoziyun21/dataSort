package sub;

import base.ISubcriber;
import base.Subscriber;

/**
 * Created by zhaoziyun on 2019/4/9.
 */
public class SubcriberImpOne<M> implements ISubcriber {
    private String name;

    public SubcriberImpOne(String name) {
        this.name = name;
    }

    @Override
    public void subcribe(Subscriber subscriber,String topic) {
        subscriber.subcribe(this,topic);
    }

    @Override
    public void unSubcribe(Subscriber subscriber,String topic) {
        subscriber.unSubcribe(this,topic);
    }

    @Override
    public void update(String publisher, String topic,Object msg) {
            System.out.println(this.name+"收到"+publisher+"发来的消息:"+msg.toString());
    }


}
