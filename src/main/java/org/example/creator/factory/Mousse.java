package org.example.creator.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mousse implements Dessert {
    private final static Logger logger = LoggerFactory.getLogger(Mousse.class);

    @Override
    public void show() {
        logger.info("Mousse.");
    }
}
