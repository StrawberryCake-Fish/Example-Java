package org.example.machine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum StatusEnum {

    STATUS_1 {
        @Override
        public void doAction(StatusDomain status) {
            logger.info("From: {}, To: {}", status.getOriginalStatus(), this.name());
        }
    },

    STATUS_2 {
        @Override
        public void doAction(StatusDomain status) {
            logger.info("From: {}, To: {}", status.getOriginalStatus(), this.name());
        }
    },

    STATUS_3 {
        @Override
        public void doAction(StatusDomain status) {
            logger.info("From: {}, To: {}", status.getOriginalStatus(), this.name());
        }
    };

    private final static Logger logger = LoggerFactory.getLogger(StatusEnum.class);

    public static StatusEnum getByStatus(String status) {
        for (StatusEnum contentStatusEnum : StatusEnum.values()) {
            if (contentStatusEnum.name().equals(status)) {
                return contentStatusEnum;
            }
        }
        return null;
    }

    public boolean checkCondition(StatusDomain status) {
        logger.info("This: {}, Domain: {}", this.name(), status.getToStatus());
        return this.name().equals(status.getToStatus());
    }

    public abstract void doAction(StatusDomain status);
}
