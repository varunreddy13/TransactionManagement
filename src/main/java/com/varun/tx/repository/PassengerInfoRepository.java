package com.varun.tx.repository;

import com.varun.tx.entity.PassangerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassangerInfo,Long> {
}
