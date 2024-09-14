package com.example.marinepath.entity;

import com.example.marinepath.entity.Enum.JourneyDetailStatusEnum;
import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "journey_detail")
public class JourneyDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "journey_id")
    private Journey journey;

    @OneToOne
    @JoinColumn(name = "harbour_pass_id")
    private HarbourPass harbourPass;

    @Column(name = "arrival_time",nullable = false)
    private LocalDateTime arrivalTime;

    @Column(name = "departure_time",nullable = false)
    private LocalDateTime departureTime;

    @Column(name = "dock_time",nullable = false)
    private Integer dockTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "journey_detail_status",nullable = false)
    private JourneyDetailStatusEnum status;

    @Column(name = "is_deleted",nullable = false)
    private Boolean isDeleted;

}
