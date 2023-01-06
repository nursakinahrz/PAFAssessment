package vttp2022.paf.assessment.eshop.respositories;

import java.lang.StackWalker.Option;
import java.util.LinkedList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.paf.assessment.eshop.models.Customer;
import static vttp2022.paf.assessment.eshop.respositories.Queries.*;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate template;

	// You cannot change the method's signature
	public Optional<Customer> findCustomerByName(String name) {
		// TODO: Task 3

        final Optional<Customer> customer = Optional.empty();

        System.out.println(">>>Customer" + name);

        SqlRowSet result = null;

       if (name == null) {
        result = template.queryForRowSet(SQL_SELECT_ALL_CUSTOMERS);

       } else {

       } result = template.queryForRowSet(SQL_SELECT_CUSTOMER_BY_NAME);

       while (result.next()) {
        customer.add(Customer.create(result));
       }

       return customer;

	}

    public static Customer create(SqlRowSet rs) {
		Customer customer = new Customer();
		customer.setName(rs.getString("name"));
		customer.setAddress(rs.getString("address"));
		customer.setEmail(rs.getString("email"));

		return customer;



	}


}
