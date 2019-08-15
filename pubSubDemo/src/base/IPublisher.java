package base;

/**
 * 发布者
 * Created by zhaoziyun on 2019/3/28.
 */
public interface IPublisher<M> {
    /**
     *  向订阅器发布消息
     * @param Subscriber 订阅器
     * @param message 消息
     */
    public void  publish(Subscriber Subscriber,String topic,M message);
}
