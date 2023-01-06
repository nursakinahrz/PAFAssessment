package vttp2022.paf.assessment.eshop.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import vttp2022.paf.assessment.eshop.models.Customer;
import vttp2022.paf.assessment.eshop.respositories.CustomerRepository;
import vttp2022.paf.assessment.eshop.respositories.OrderRepository;
import vttp2022.paf.assessment.eshop.services.WarehouseService;

@RestController
@RequestMapping(path="/customer")
public class OrderController {

	//TODO: Task 3

	@Autowired
	private WarehouseService warehouseSvc;

	@GetMapping(path= "/name")
	public ResponseEntity <String> getCustomerByName (@PathVariable String name) {
		JsonObject result = null;
		Optional<Customer> customer = warehouseSvc.dispatch(name);
		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("name", customer.get().toJSON());
		result = builder.build();

		return ResponseEntity
		.status(HttpStatus.OK)
		.contentType(MediaType.APPLICATION_JSON)
		.body(result.toString());
		
	}
	
	@PostMapping
	public String postCustomer(@RequestBody MultiValueMap <String, String> form, Model model) {
		String name = form.getFirst("name");
		String address = form.getFirst("address");
		String email = form.getFirst("email");

		Customer c = new Customer(name, address, email);
		Customer postedCustomer = warehouseSvc.postCustomer(c);
		model.addAttribute(name, postedCustomer);

		return "customer_result"; 

	}




}

