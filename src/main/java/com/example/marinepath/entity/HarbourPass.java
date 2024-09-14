package com.example.marinepath.entity;

import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "harbour_pass")
public class HarbourPass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "port_id")
    private Port port;

    @Column(nullable = false)
    private String document;

    @Column(name = "issued_at",nullable = false)
    private LocalDateTime issuedAt;

    @Column(name = "expired_at",nullable = false)
    private LocalDateTime expiredAt;

    @Column(name = "is_deleted",nullable = false)
    private Boolean isDeleted;

    @OneToOne(mappedBy = "harbourPass")
    private JourneyDetail journeyDetail;

}
