package org.example.creator.single;

import org.example.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(() -> {
                Single single = Single.createSingle();
                logger.info("{} ===> {}", single.getClass().getName() + "@" + Integer.toHexString(single.hashCode()), single.echo(String.valueOf(finalI)));
            }).start();
        }
    }
}
