package com.example.marinepath.entity;

import com.example.marinepath.entity.Enum.Account.AccountGenderEnum;
import com.example.marinepath.entity.Enum.Account.AccountProviderEnum;
import com.example.marinepath.entity.Enum.Account.AccountRoleEnum;
import com.example.marinepath.entity.Enum.Account.AccountStatusEnum;
import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String name;

    @Column
    private String password;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private AccountGenderEnum gender;

    @Column
    private String picture;

    @Column(unique = true)
    private String googleId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountRoleEnum role;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountProviderEnum provider;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountStatusEnum status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;


@Transient
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + this.role.name()));
}
    @Transient
    @Override
    public String getUsername() {
        return this.email;
    }

    @Transient
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Transient
    @Override
    public boolean isAccountNonLocked() {
        return this.status != AccountStatusEnum.BLOCKED;
    }

    @Transient
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Transient
    @Override
    public boolean isEnabled() {
        return this.status == AccountStatusEnum.VERIFIED;
    }
}
