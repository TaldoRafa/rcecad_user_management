package com.rcecad.rcecad_user_management.infra.mysql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class PaymentLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime date;
    private Double amount;
    @OneToOne
    private License license;
    private String methodPayment;
    private String paymentCode;
    private Boolean approved;
}
