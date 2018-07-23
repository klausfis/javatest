package br.com.agibank.javatest.service;

import java.io.Serializable;

public interface DataAnalysisBEAService extends Serializable {

    public StringBuilder getSummarize();

    public Integer getAmountOfClients();

    public Integer getAmountOfSalesman();

    public Integer getIdOfTheMostExpensiveSale();

    public String getWorstSalesman();
}
