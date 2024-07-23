package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class myTimerLoggings {
    private static final Logger logger = LogManager.getLogger(myTimerLoggings.class);
    private static final SimpleDateFormat secondFormat = new SimpleDateFormat("HH:mm:ss");
    private static final SimpleDateFormat minuteFormat = new SimpleDateFormat("HH:mm:00");
    private static final SimpleDateFormat hourFormat = new SimpleDateFormat("HH:00:00");

    public static void main(String[] args) {
        Timer timer = new Timer();

        // Log every second
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Calendar cal = Calendar.getInstance();
                logger.debug("Debug Time: " + secondFormat.format(cal.getTime()));
            }
        }, 0, 1000);

        // Log every minute
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Calendar cal = Calendar.getInstance();
                logger.info("Info Time: " + minuteFormat.format(cal.getTime()));
            }
        }, 0, 60000);

        // Log every hour
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Calendar cal = Calendar.getInstance();
                logger.error("Error Time: " + hourFormat.format(cal.getTime()));
            }
        }, 0, 3600000);
    }
}
