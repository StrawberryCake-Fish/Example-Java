package org.example.creator.single;

import org.example.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.reflect.Constructor;

public class SingleTest {
    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    @Test
    public static void threadTest() throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(() -> {
                Single single = Single.createSingle();
                logger.info("{} ===> {}", single.getClass().getName() + "@" + Integer.toHexString(single.hashCode()), single.echo(String.valueOf(finalI)));
            }).start();
        }
        Thread.sleep(1000);
    }

    @Test
    public void reflect() throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(() -> {
                Class<Single> clazz = Single.class;
                try {
                    Constructor<Single> cons = clazz.getDeclaredConstructor();
                    cons.setAccessible(true);
                    Single single = cons.newInstance();
                    logger.info("{} ===> {}", single.getClass().getName() + "@" + Integer.toHexString(single.hashCode()), single.echo(String.valueOf(finalI)));
                } catch (Exception e) {
                    logger.error("Thread reflect error!", e);
                }
            }).start();
        }
        Thread.sleep(1000);
    }
}
