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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cpf;
    @OneToOne(cascade = CascadeType.ALL)
    private UserData userData;
    @ManyToOne
    private Enterprise enterprise;
}
