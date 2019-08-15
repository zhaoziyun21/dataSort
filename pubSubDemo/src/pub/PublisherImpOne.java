package pub;

import base.IPublisher;
import base.Subscriber;

/**
 * Created by zhaoziyun on 2019/4/9.
 */
public class PublisherImpOne<M> implements IPublisher {
    private String name;

    public PublisherImpOne(String name) {
        this.name = name;
    }

    @Override
    public void publish(Subscriber Subscriber,String topic, Object message) {
        Subscriber.publish(name,topic,message);
    }
}
