package br.com.agibank.javatest.pojo.base;

import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class Data implements IData {

    private static final long serialVersionUID = 1569206649651401833L;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
