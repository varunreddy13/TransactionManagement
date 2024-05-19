package com.varun.tx.dto;

import com.varun.tx.entity.PassangerInfo;
import com.varun.tx.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
    private PassangerInfo passangerInfo;
    private PaymentInfo paymentInfo;

}
