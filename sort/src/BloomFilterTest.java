import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhaoziyun on 2019/2/18.
 */
public class BloomFilterTest {
    public static void main(String[] args) {
        long star = System.currentTimeMillis();
        Set<Integer> hashSet = new HashSet<>(100);
        for(int i = 0;i<100;i++){
            hashSet.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("执行时间："+ (end - star));
    }
}
