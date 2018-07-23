package br.com.agibank.javatest.utils;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.agibank.javatest.pojo.Customer;
import br.com.agibank.javatest.pojo.Sales;
import br.com.agibank.javatest.pojo.SalesItem;
import br.com.agibank.javatest.pojo.Salesman;
import br.com.agibank.javatest.pojo.base.IData;

public class DataFactory {

    public IData generateData(Integer id, String[] tuple) {
        switch (id) {
            case 1:
                return salesman(id, tuple);
            case 2:
                return customer(id, tuple);
            case 3:
                return sales(id, tuple);
            default:
                return null;
        }

    }

    private Salesman salesman(Integer id, String[] tuple) {
        Salesman salesman = new Salesman(id, tuple[1].trim(), tuple[2].trim(), Double.parseDouble(tuple[3].trim()));
        return salesman;
    }

    private Customer customer(Integer id, String[] tuple) {
        Customer customer = new Customer(id, tuple[1].trim(), tuple[2].trim(), tuple[3].trim());
        return customer;
    }

    private Sales sales(Integer id, String[] tuple) {
        Sales sales = new Sales(id, tuple[1].trim(), salesItems(tuple[2].trim()), tuple[3].trim());
        return sales;
    }

    private List<SalesItem> salesItems(String line) {
        List<SalesItem> items = Lists.newArrayList();
        try {
            String itemsArray[] = line.replaceAll("\\[|\\]", "").split(",");
            for (int i = 0; i < itemsArray.length; i++) {
                String[] tuple = itemsArray[i].split("-");
                SalesItem item = new SalesItem(Long.parseLong(tuple[0].trim()), Integer.parseInt(tuple[1].trim()),
                        Double.parseDouble(tuple[2].trim()));
                items.add(item);
            }
        } catch (Exception e) {
        }
        return items;
    }

}
