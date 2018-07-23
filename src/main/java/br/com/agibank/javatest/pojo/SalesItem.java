package br.com.agibank.javatest.pojo;

import br.com.agibank.javatest.pojo.base.Data;

public class SalesItem extends Data {

    private static final long serialVersionUID = 1060562251037600955L;

    private Long itemID;
    private Integer itemQuantity;
    private Double itemPrice;

    public SalesItem(Long itemID, Integer itemQuantity, Double itemPrice) {
        this.itemID = itemID;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
    }

    public Long getItemID() {
        return itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
