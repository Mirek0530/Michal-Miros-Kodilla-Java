package com.kodilla.hibernate.manytomany.facade;

public class QueryException extends Exception {

    public static final String COMPANY_NOT_FOUND = "Company with given substring not found.";
    public static final String EMPLOYEE_NOT_FOUND = "Employee with given substring not found.";

    public QueryException(String message) {
        super(message);
    }
}
