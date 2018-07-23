package br.com.agibank.javatest.pojo;

import br.com.agibank.javatest.pojo.base.Data;

public class Customer extends Data {

    private static final long serialVersionUID = 1767568326922691321L;
    private String cnpj;
    private String name;
    private String businessArea;

    public Customer(Integer id, String cnpj, String name, String businessArea) {
        super();
        setId(id);
        this.cnpj = cnpj;
        this.name = name;
        this.businessArea = businessArea;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

}
