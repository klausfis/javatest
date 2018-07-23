package br.com.agibank.javatest.service.impl;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.agibank.javatest.pojo.Customer;
import br.com.agibank.javatest.pojo.Sales;
import br.com.agibank.javatest.pojo.SalesItem;
import br.com.agibank.javatest.pojo.Salesman;
import br.com.agibank.javatest.pojo.base.IData;
import br.com.agibank.javatest.service.DataAnalysisBEAService;

public final class DataAnalysisBEAServiceImpl implements DataAnalysisBEAService {

    private static final long serialVersionUID = 2793604300943099300L;

    private List<IData> dataList = Lists.newArrayList();

    public DataAnalysisBEAServiceImpl(List<IData> dataList) {
        this.dataList = dataList;
    }

    public StringBuilder getSummarize() {
        StringBuilder result = new StringBuilder();
        result.append("- Quantidade de clientes no arquivo de entrada: ").append(getAmountOfClients());
        result.append("\n- Quantidade de vendedor no arquivo de entrada: ").append(getAmountOfSalesman());
        result.append("\n- ID da venda mais cara: ").append(getIdOfTheMostExpensiveSale());
        result.append("\n- O pior vendedor: ").append(getWorstSalesman());
        return result;
    }

    public Integer getAmountOfClients() {
        Integer amountOfClients = 0;
        for (IData i : dataList) {
            if (i instanceof Customer) {
                amountOfClients++;
            }
        }
        return amountOfClients;
    }

    public Integer getAmountOfSalesman() {
        Integer amountOfSalesman = 0;
        for (IData i : dataList) {
            if (i instanceof Salesman) {
                amountOfSalesman++;
            }
        }
        return amountOfSalesman;
    }

    public Integer getIdOfTheMostExpensiveSale() {
        Double mostExpensive = 0.0;
        Sales mostExpensiveSale = null;
        for (IData i : dataList) {
            if (i instanceof Sales) {
                Double calc = 0.0;
                List<SalesItem> items = ((Sales) i).getItems();
                for (SalesItem item : items) {
                    calc = calc + (item.getItemPrice() * item.getItemQuantity());
                }
                if (calc > mostExpensive) {
                    mostExpensive = calc;
                    mostExpensiveSale = ((Sales) i);
                }
            }
        }
        return mostExpensiveSale != null ? Integer.valueOf(mostExpensiveSale.getSaleId()) : 0;
    }

    public String getWorstSalesman() {
        Double worstSale = 0.0;
        String worstSalesman = null;
        for (IData i : dataList) {
            if (i instanceof Sales) {
                Double calc = 0.0;
                List<SalesItem> items = ((Sales) i).getItems();
                for (SalesItem item : items) {
                    calc = calc + (item.getItemPrice() * item.getItemQuantity());
                }
                worstSale = calc;
                if (calc <= worstSale) {
                    worstSalesman = ((Sales) i).getSalesmanName();
                }
            }
        }
        return worstSalesman;
    }
}
