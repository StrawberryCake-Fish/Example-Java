package org.example.creator.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tiramisu implements Dessert {
    private final static Logger logger = LoggerFactory.getLogger(Tiramisu.class);

    @Override
    public void show() {
        logger.info("Tiramisu.");
    }
}
