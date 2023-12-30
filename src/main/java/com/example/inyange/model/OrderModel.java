package com.example.inyange.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Order_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullnames;
    private String phone;
    private String address;

}
