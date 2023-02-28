package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyEmployeeFacade {

    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyEmployeeFacade.class);

    @Autowired
    public CompanyEmployeeFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> findCompanyByGivenSubstring(String substring) throws QueryException {
        LOGGER.info("Searching for company with given phrase: " + substring);
        List<Company> companies = companyDao.findCompanyByGivenSubstring("%" + substring + "%");

        if (companies.size() == 0) {
            LOGGER.error(String.format(QueryException.COMPANY_NOT_FOUND, substring));
            throw new QueryException(QueryException.COMPANY_NOT_FOUND);
        }
        return companies;
    }

    public List<Employee> findEmployeeByGivenSubstring(String substring) throws QueryException {
        LOGGER.info("Searching for employee with given phrase: " + substring);
        List<Employee> employees = employeeDao.findEmployeeByGivenSubstring("%" + substring + "%");

        if (employees.size() == 0) {
            LOGGER.error(String.format(QueryException.EMPLOYEE_NOT_FOUND, substring));
            throw new QueryException(QueryException.EMPLOYEE_NOT_FOUND);
        }
        return employees;
    }
}
