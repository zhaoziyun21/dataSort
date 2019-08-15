package base;

/**
 * Created by zhaoziyun on 2019/3/28.
 */
public interface ISubcriber<M> {
    /**
     *  订阅
     * @param subscriber 订阅器
     */
    public void subcribe(Subscriber subscriber,String topic);

    /**
     *  退订
     * @param subscriber 订阅器
     */
    public void unSubcribe(Subscriber subscriber,String topic);

    /**
     * 接收消息
     * @param publisher
     * @param msg
     */
    public void update(String publisher,String topic,M msg);
}
