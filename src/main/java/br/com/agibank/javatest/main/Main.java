package br.com.agibank.javatest.main;

import java.util.Date;
import java.util.Timer;

import br.com.agibank.javatest.task.DataAnalysisSystemTask;

public class Main {

    public static void main(String[] args) {
        Timer timer = new Timer();
        // 20 seconds
        int secondsIntervalExecute = 20;
        timer.scheduleAtFixedRate(new DataAnalysisSystemTask(), new Date(), 1000 * secondsIntervalExecute);
    }
}
