package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchingFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchingFacade.class);

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    public List<SomethingToReturnInList> findByPartOfName(String whatToFind, String partOfName) {
        String arg = "%" + partOfName + "%";
        if(whatToFind.toUpperCase().equals("E") || whatToFind.toUpperCase().equals("EMPLOYEE")) {
            return employeeDao.retrieveEmployeesWithLastName(arg);
        } else if(whatToFind.toUpperCase().equals("C") || whatToFind.toUpperCase().equals("COMPANY")) {
            return companyDao.retrieveCompaniesWhoseNameContains(arg);
        }
        LOGGER.warn("Can only search for Employee(E) or Company(C).");
        return new ArrayList<>();
    }

}
