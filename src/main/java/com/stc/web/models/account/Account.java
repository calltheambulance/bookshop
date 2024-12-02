package com.stc.web.models.account;


import com.stc.web.models.Role;
import com.stc.web.models.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "account_email")
    private String email;

    @Column(name = "account_password")
    private String password;

    @Column(name = "account_name")
    private String name;

    @Column(name = "account_surname")
    private String surname;

    @Column(name = "account_phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_role")
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_state")
    private State state;

    public Account(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
