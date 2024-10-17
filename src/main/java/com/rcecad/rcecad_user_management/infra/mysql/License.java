package com.rcecad.rcecad_user_management.infra.mysql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String licenseKey;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    private LicenseInfo licenseInfo;
    @OneToOne
    private User user;
    @OneToOne
    private Enterprise enterprise;
}
