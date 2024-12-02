package com.FullFledgedEcommerce.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    private String paymentMethod;    // Payment method (e.g., Credit Card, PayPal, etc.)

    private String transactionId;    // Unique transaction ID from payment gateway

    private String paymentStatus;    // Status of the payment (e.g., pending, completed, failed)

    private LocalDateTime paymentDate;


}

