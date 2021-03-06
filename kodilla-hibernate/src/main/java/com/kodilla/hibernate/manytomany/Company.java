package com.kodilla.hibernate.manytomany;

import com.kodilla.hibernate.manytomany.facade.SomethingToReturnInList;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQuery(
        name = "Company.retrieveCompaniesWithNameStartedWith",
        query = "SELECT * FROM COMPANIES" +
                " WHERE SUBSTRING(COMPANY_NAME, 1, 3) LIKE :GIVENSIGNS",
        resultClass = Company.class
)

@NamedNativeQuery(
        name = "Company.retrieveCompaniesWhoseNameContains",
        query = "SELECT * FROM COMPANIES" +
                " WHERE COMPANY_NAME LIKE :GIVENSIGNS",
        resultClass = Company.class
)
@Entity
@Table(name = "COMPANIES")
public class Company implements SomethingToReturnInList {
    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")

    public List<Employee> getEmployees() {
        return employees;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
