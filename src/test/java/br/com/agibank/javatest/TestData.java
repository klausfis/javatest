package br.com.agibank.javatest;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.Lists;

import br.com.agibank.javatest.pojo.Customer;
import br.com.agibank.javatest.pojo.Sales;
import br.com.agibank.javatest.pojo.SalesItem;
import br.com.agibank.javatest.pojo.Salesman;
import br.com.agibank.javatest.pojo.base.IData;
import br.com.agibank.javatest.service.DataAnalysisBEAService;
import br.com.agibank.javatest.service.impl.DataAnalysisBEAServiceImpl;

public class TestData {

    @DataProvider(name = "items")
    public Object[][] items() {
        List<IData> dataTest = Lists.newArrayList();
        dataTest.add(new Salesman(new Integer(001), "1234567891234", "Pedro", Double.parseDouble("50000")));
        dataTest.add(new Salesman(new Integer(001), "3245678865434", "Paulo", Double.parseDouble("40000.99")));
        dataTest.add(new Customer(new Integer(002), "2345675434544345", "Jose da Silva", "Rural"));
        dataTest.add(new Customer(new Integer(002), "2345675433444345", "Eduardo Pereira", "Rural"));
        List<SalesItem> items1 = new ArrayList<SalesItem>();
        items1.add(new SalesItem(1L, new Integer(10), new Double(100)));
        items1.add(new SalesItem(2L, new Integer(30), new Double(2.5)));
        items1.add(new SalesItem(3L, new Integer(40), new Double(3.1)));
        List<SalesItem> items2 = new ArrayList<SalesItem>();
        items2.add(new SalesItem(1L, new Integer(34), new Double(10)));
        items2.add(new SalesItem(2L, new Integer(33), new Double(1.5)));
        items2.add(new SalesItem(3L, new Integer(40), new Double(0.10)));
        dataTest.add(new Sales(new Integer(003), "10", items1, "Pedro"));
        dataTest.add(new Sales(new Integer(003), "08", items2, "Paulo"));
        return new Object[][] { { dataTest, Lists.newArrayList() } };
    }

    @Test(dataProvider = "items")
    public void testar(List<IData> items, List<IData> listaNula) {
        DataAnalysisBEAService data = new DataAnalysisBEAServiceImpl(items);
        Assert.assertEquals(Integer.valueOf(2), data.getAmountOfClients());
        Assert.assertEquals(Integer.valueOf(2), data.getAmountOfSalesman());
        Assert.assertEquals(Integer.valueOf(10), data.getIdOfTheMostExpensiveSale());
        Assert.assertEquals("Paulo", data.getWorstSalesman());
    }

}
