package vttp2022.paf.assessment.eshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vttp2022.paf.assessment.eshop.respositories.CustomerRepository;
import vttp2022.paf.assessment.eshop.respositories.OrderRepository;
import vttp2022.paf.assessment.eshop.services.WarehouseService;

@RestController
@RequestMapping(path="/api/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

	//TODO: Task 3

	// @Autowired
	// private WarehouseService warehouseSvc;

	@Autowired
	private CustomerRepository customerRepo;

	@GetMapping("/name")
	public ResponseEntity<String> getCustomerByName (@RequestParam (required =false) String name) {
		return customerRepo.findCustomerByName(name);

	}

	
	return ResponseEntity
	.status(HttpStatus.OK)
	.contentType(MediaType.APPLICATION_JSON)
	.body(result.toString());



}
