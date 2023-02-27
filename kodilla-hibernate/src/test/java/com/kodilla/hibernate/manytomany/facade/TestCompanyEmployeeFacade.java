package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestCompanyEmployeeFacade {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CompanyEmployeeFacade facade;

    @Test
    void testCompanyFacadeCompanySearch() throws QueryException {
        //Given
        Company dataTransfer = new Company("Data Transfers");
        Company dataMasters = new Company("Data Masters");
        Company softwareKings = new Company("Software Kings");
        Company redFoxes = new Company("Red Foxes");

        companyDao.save(dataTransfer);
        companyDao.save(dataMasters);
        companyDao.save(softwareKings);
        companyDao.save(redFoxes);

        //When
        List<Company> companies = facade.findCompanyByGivenSubstring("ata");

        //Then
        assertEquals(2, companies.size());

        //CleanUp
        companyDao.deleteAll();
    }

    @Test
    void testCompanyFacadeEmployeeSearch() throws QueryException {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarkson = new Employee("Stephanie", "Clarkson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        //When
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarkson);
        employeeDao.save(lindaKovalsky);

        List<Employee> result = facade.findEmployeeByGivenSubstring("anie");

        //Then
        assertEquals(1, result.size());

        //CleanUp
        employeeDao.deleteAll();
    }
}
