package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> logger.info("Hello and welcome!")).start();
        }
    }
}