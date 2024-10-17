package com.rcecad.rcecad_user_management.infra.mysql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cnpj;
    @OneToOne(cascade = CascadeType.ALL)
    private UserData userData;
}
