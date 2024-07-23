package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Timer;
import java.util.TimerTask;

public class myTimerLoggings {
    private static final Logger logger = LogManager.getLogger(myTimerLoggings.class);

    public static void main(String[] args) {
        Timer timer = new Timer();

        // Debug log
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logger.debug("Current time: " + java.time.LocalTime.now().withNano(0));
            }
        }, 0, 1000);

        // Info log
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logger.info("Current minute: " + java.time.LocalTime.now().withSecond(0).withNano(0));
            }
        }, 0, 60000);

        // Error log
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logger.error("Current hour: " + java.time.LocalTime.now().withMinute(0).withSecond(0).withNano(0));
            }
        }, 0, 3600000);
    }
}
