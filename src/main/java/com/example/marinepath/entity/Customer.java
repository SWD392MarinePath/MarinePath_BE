package com.example.marinepath.entity;

import com.example.marinepath.entity.Enum.Customer.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Table(name = "customer")
public class Customer implements UserDetails {

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
    private CustomerGenderEnum gender;

    @Column
    private String picture;

    @Column(unique = true)
    private String googleId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CustomerRoleEnum role;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CustomerProviderEnum provider;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CustomerStatusEnum status;

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
        return this.status != CustomerStatusEnum.BLOCKED;
    }

    @Transient
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Transient
    @Override
    public boolean isEnabled() {
        return this.status == CustomerStatusEnum.VERIFIED;
    }
}
