package com.mouritech.onlinefooddeliveryapplication.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mouritech.onlinefooddeliveryapplication.entity.Customer;
import com.mouritech.onlinefooddeliveryapplication.repository.CustomerRepository;
import com.mouritech.onlinefooddeliveryapplication.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void addCustomerInformation(Customer customer) {
		
		customerRepository.save(customer);
		
	}

	@Override
	public boolean findCustomerByEmailAndPassword(String customerEmail, String customerPassword) {
		boolean flag =false;
		
		Customer customer = customerRepository.findByCustomerEmailAndCustomerPassword(customerEmail,customerPassword);
		if(customer==null) {
			return flag;
		}
		else {
			return flag=true;
		}

	}

	@Override
	public ResponseEntity<?> updatecustomerinfobyname(Customer customer) {
		
		Customer cust = customerRepository.findByCustomerName(customer.getCustomerName());
		if(cust==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("resourse not you can't update");
		}
		else {
			cust.setCustomerName(customer.getCustomerName());
			
			cust.setCustomerPassword(customer.getCustomerPassword());
			cust.setCustomerCity(customer.getCustomerCity());
			cust.setCustomerState(customer.getCustomerState());
			cust.setCustomerCountry(customer.getCustomerCountry());
			cust.setCustomerPincode(customer.getCustomerPincode());
			cust.setCustomerMobileNumber(customer.getCustomerMobileNumber());
			cust.setCustomerEmail(customer.getCustomerEmail());
			
			final Customer customerfinal = customerRepository.save(cust);
			
			 return ResponseEntity.ok(customerfinal);
		}
}


}