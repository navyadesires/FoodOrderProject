package com.mouritech.onlinefooddeliveryapplication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mouritech.onlinefooddeliveryapplication.entity.Bill;
import com.mouritech.onlinefooddeliveryapplication.exception.BillNotFound;
import com.mouritech.onlinefooddeliveryapplication.service.BillService;



@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/bills")
public class BillController {

	@Autowired
	private BillService billService;
	
	//save an Bill
		@PostMapping("/bills")
		public Bill saveBil(@Valid @RequestBody Bill bill)
		{
			return billService.saveBill(bill);
		}
		//get all bills
		@GetMapping("/bills")
		public List<Bill> getAllBills()
		{
			return billService.getAllBills();
		}
		//update bills
		@PutMapping("/bills/{id}")
		public ResponseEntity<Bill> updateBill(@PathVariable(value = "id") int billId) throws BillNotFound {
		
			return billService.updateBills(billId);
		
		}
		//delete bill
		@DeleteMapping("/bills/{billId}")
		public ResponseEntity<?> deleteBill( 
				@PathVariable(value = "billId") int billId)
		throws BillNotFound{
			return billService.deleteBill(billId);
			
		}

		//get bill by billId
		@GetMapping("/bills/{id}")
	  public ResponseEntity<Bill> getBillById(@PathVariable(value = "id") int billId)
	      throws BillNotFound {
			return billService.getBillById(billId);
			
			
		}

}
