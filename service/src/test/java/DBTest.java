import com.mouse.store.DubboDemoApplication;
import com.mouse.store.impl.StoreServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author gongchangyou
 * @version 1.0
 * @date 2022/3/15 9:41 上午
 */

@Slf4j
@SpringBootTest(classes= DubboDemoApplication.class)
public class DBTest {

    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));

    @Autowired
    private StoreServiceImpl storeServiceImpl;

    @Test
    void decr() {
        for (int i = 0; i < 10; i++) {

            threadPoolExecutor.execute(() -> {
                val result = storeServiceImpl.decr(3);
                log.info("result={}", result);
            });
        }

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}