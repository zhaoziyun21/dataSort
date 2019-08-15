package base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订阅器类
 * Created by zhaoziyun on 2019/3/28.
 */
public class Subscriber<M> {
    //订阅器名称
    private String name;
    //订阅者
    private Map<String,Object> subcriberMap = new HashMap<>();


    public Subscriber(String name) {
        this.name = name;
    }

    /**
     * 订阅
     * @param subcriber
     */
    public void subcribe(ISubcriber subcriber,String topic){
        if(subcriberMap.get(topic) != null){
            List<ISubcriber> subcriberList  = (List<ISubcriber>) subcriberMap.get(topic);
            subcriberList.add(subcriber);
        }else{
            List<ISubcriber> subcriberList = new ArrayList<>();
            subcriberList.add(subcriber);
            subcriberMap.put(topic,subcriberList);
        }
    }

    /**
     * 发布
     * @param publisher
     * @param message
     */
    public void publish(String publisher,String topic,M message){
        update(publisher,topic,message);
    }

    /**
     * 给订阅者发送消息
     * @param publisher
     * @param message
     */
    public void update(String publisher,String topic, M message) {
        List<ISubcriber>    subcriberList = (List<ISubcriber>)subcriberMap.get(topic);
        if(subcriberList != null){
            for (ISubcriber subcriber:subcriberList) {
                subcriber.update(publisher,topic,message);
            }
        }
    }

    public void unSubcribe(ISubcriber subcriber,String topic){
        List<ISubcriber>    subcriberList = (List<ISubcriber>)subcriberMap.get(topic);
        if(subcriberList != null) {
            subcriberList.remove(subcriber);
        }
    }
}
