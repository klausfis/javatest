package br.com.agibank.javatest.pojo;

import br.com.agibank.javatest.pojo.base.Data;

public class Salesman extends Data {

    private static final long serialVersionUID = -8541562290640641896L;

    private String cpf;
    private String name;
    private Double salary;

    public Salesman(Integer id, String cpf, String name, Double salary) {
        setId(id);
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

}
