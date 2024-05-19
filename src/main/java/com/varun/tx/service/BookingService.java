package com.varun.tx.service;

import com.varun.tx.dto.FlightBookingAcknowldgement;
import com.varun.tx.dto.FlightBookingRequest;
import com.varun.tx.dto.FlightBookingResponse;
import com.varun.tx.entity.PassangerInfo;
import com.varun.tx.entity.PaymentInfo;
import com.varun.tx.exception.InsufficentAmountException;
import com.varun.tx.repository.PassengerInfoRepository;
import com.varun.tx.repository.PaymentInfoRepository;
import com.varun.tx.utils.PaymentUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingService {
    @Autowired
    PassengerInfoRepository passengerInfoRepository;
    @Autowired
    PaymentInfoRepository paymentInfoRepository;

    @Transactional
    public FlightBookingAcknowldgement bookFlightTickets(FlightBookingRequest request){

        //FlightBookingAcknowldgement acknowldgement = null;
        PassangerInfo passangerInfo =request.getPassangerInfo();
        passangerInfo=passengerInfoRepository.save(passangerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        PaymentUtils.validCreditLimit(paymentInfo.getAccountNo(),passangerInfo.getFare());

        paymentInfo.setPassengerId(passangerInfo.getPId());
        paymentInfo.setAmount(passangerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);

        return new FlightBookingAcknowldgement("Sucess",passangerInfo.getFare(), UUID.randomUUID().toString().split("")[0],passangerInfo);


    }

    public List<FlightBookingResponse> getPassangerDetails(Long id) {

        List flightBookingResponses = new ArrayList<>();

        PassangerInfo Responses =passengerInfoRepository.getById(id);
        flightBookingResponses.add(Responses.getPId());
        flightBookingResponses.add(Responses.getName());

        return flightBookingResponses;
    }


    public List<PassangerInfo> findAllPassangers() {
        return passengerInfoRepository.findAll();
    }

//    public PassangerInfo getPassangerById(Long id) {
//       return passengerInfoRepository.findById(id);
//    }
}
