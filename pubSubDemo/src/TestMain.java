import base.IPublisher;
import base.ISubcriber;
import base.Msg;
import base.Subscriber;
import pub.PublisherImpOne;
import sub.SubcriberImpOne;
import sun.reflect.Reflection;

/**
 * Created by zhaoziyun on 2019/4/9.
 */
public class TestMain {
    public static void main(String[] args) {
        Subscriber<String> subscriber = new Subscriber<>("订阅器");
        Subscriber<Msg> subscriberMsg = new Subscriber<Msg>("订阅器Msg");

        IPublisher<String> publisher1 = new PublisherImpOne<String>("发布者1");
        IPublisher<String> publisher3 = new PublisherImpOne<String>("发布者3");
        IPublisher<Msg> publisher2 = new PublisherImpOne<Msg>("发布者2");

        ISubcriber<String> subcriber1 = new SubcriberImpOne<String>("订阅者1");
        ISubcriber<String> subcriber2 = new SubcriberImpOne<String>("订阅者2");
        ISubcriber<String> subcriber3 = new SubcriberImpOne<String>("订阅者3");

        subcriber1.subcribe(subscriber,"哈哈");
        subcriber2.subcribe(subscriber,"嘿嘿");
        subcriber3.subcribe(subscriber,"嘿嘿");

        publisher1.publish(subscriber,"哈哈","发布者1发布的消息1");
        publisher3.publish(subscriber,"嘿嘿","发布者1发布的消息2");
    }
}
