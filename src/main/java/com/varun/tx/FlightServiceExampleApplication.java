package com.varun.tx;

import com.varun.tx.dto.FlightBookingAcknowldgement;
import com.varun.tx.dto.FlightBookingRequest;
import com.varun.tx.dto.FlightBookingResponse;
import com.varun.tx.entity.PassangerInfo;
import com.varun.tx.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class FlightServiceExampleApplication {
	@Autowired
	BookingService service;
	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowldgement bookingAcknowldgement(@RequestBody FlightBookingRequest request){
		return service.bookFlightTickets(request);
	}

//	@GetMapping("/persondetails/{id}")
//	public List<FlightBookingResponse> getPassangerDetails(@RequestParam Long id){
//		return service.getPassangerDetails(id);
//	}

	@GetMapping("/passangers")
	public ResponseEntity<List<PassangerInfo>> getAllPassangers(){
		return new ResponseEntity<>(service.findAllPassangers(), HttpStatus.OK);

	}

//	@GetMapping("/passangers/{id}")
//	public ResponseEntity<PassangerInfo> getPassangerById(@PathVariable Long id){
//		return new ResponseEntity<>(service.getPassangerById(id), HttpStatus.OK);
//
//	}
	public static void main(String[] args) {
		SpringApplication.run(FlightServiceExampleApplication.class, args);
	}

}
