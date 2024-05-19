package com.varun.tx.dto;

import com.varun.tx.entity.PassangerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingAcknowldgement {

    private String status;
    private double totalFare;
    private String pnrNO;
    private PassangerInfo passangerInfo;
}
