package com.example.marinepath.entity;

import com.example.marinepath.entity.Enum.JourneyStatusEnum;
import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "journey")
public class Journey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;

    @Column(name = "cargo_description",nullable = false)
    private String cargoDescription;

    @Column(name = "container_count",nullable = false)
    private Integer containerCount;

    @Column(name = "start_date",nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date",nullable = false)
    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "journey_status",nullable = false)
    private JourneyStatusEnum status;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private String description;

    @Column(name = "is_deleted",nullable = false)
    private Boolean isDeleted;

    @OneToMany(mappedBy = "journey")
    private List<JourneyDetail> journeyDetails;

    @OneToMany(mappedBy = "journey")
    private List<IncidentReport> incidentReports;


}
