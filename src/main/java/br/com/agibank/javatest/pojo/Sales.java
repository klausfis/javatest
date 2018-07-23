package br.com.agibank.javatest.pojo;

import java.util.List;

import br.com.agibank.javatest.pojo.base.Data;

public class Sales extends Data {

    private static final long serialVersionUID = 3810975764109324881L;

    private String saleId;
    private List<SalesItem> items;
    private String salesmanName;

    public Sales(Integer id, String saleId, List<SalesItem> items, String salesmanName) {
        setId(id);
        this.saleId = saleId;
        this.items = items;
        this.salesmanName = salesmanName;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public List<SalesItem> getItems() {
        return items;
    }

    public void setItems(List<SalesItem> items) {
        this.items = items;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

}
