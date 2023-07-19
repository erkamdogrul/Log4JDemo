package com.erkam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;
import java.util.logging.Level;

public class myTimerLoggins {
    static final Logger logger = LogManager.getLogger();
    static private int secondCounter;
    static private int minuteCounter;

    public static void main(String[] args) {

        LocalTime previousTime = LocalTime.now().minusSeconds(1);
        while (true) {
            LocalTime currentTime = LocalTime.now();

            if (previousTime.getSecond() != currentTime.getSecond()) {
                if (currentTime.getSecond() != 0) {
                    logger.debug("Second changed.");
                }
            }
            if (previousTime.getMinute() != currentTime.getMinute()) {
                if (currentTime.getMinute() != 0) {
                    logger.info("Minute changed.");
                }

            }
            if (previousTime.getHour() != currentTime.getHour()) {
                logger.error("Hour changed.");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(myTimerLoggins.class.getName()).log(Level.SEVERE, null, ex);
            }
            previousTime = currentTime;
        }

    }
}
