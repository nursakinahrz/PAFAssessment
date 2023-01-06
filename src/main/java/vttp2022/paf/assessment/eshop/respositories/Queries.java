package vttp2022.paf.assessment.eshop.respositories;

public class Queries {
    
    public static final String SQL_SELECT_ALL_CUSTOMERS = "select id, name, address, email from customers";

    public static final String SQL_SELECT_CUSTOMER_BY_NAME = "select id, name, address, email from customers where name =?";

    public static String SQL_INSERT_CUSTOMER = "insert into customers(name, address, email) values (?, ?, ?)";



}
