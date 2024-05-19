package com.varun.tx.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "VarunInfo")
public class VarunInfo {
    @Id
    private  Long id;
    private String accesories;
    private  String education;
}
