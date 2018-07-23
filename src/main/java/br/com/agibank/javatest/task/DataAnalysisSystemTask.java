package br.com.agibank.javatest.task;

import java.util.TimerTask;

import br.com.agibank.javatest.service.DataAnalysisSystemService;
import br.com.agibank.javatest.service.impl.DataAnalysisSystemServiceImpl;

public class DataAnalysisSystemTask extends TimerTask {

    @Override
    public void run() {
        DataAnalysisSystemService dataAnalysisSystemService = new DataAnalysisSystemServiceImpl();
        dataAnalysisSystemService.initDataAnalysisSystem();
    }
}
