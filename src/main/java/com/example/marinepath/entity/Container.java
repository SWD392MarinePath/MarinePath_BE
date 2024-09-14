package com.example.marinepath.entity;

import com.example.marinepath.entity.Enum.ContainerStatusEnum;
import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "container")
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "journey_detail_id")
    private JourneyDetail journeyDetail;

    @Column(nullable = false)
    private Float weight;

    @Enumerated(EnumType.STRING)
    @Column(name = "container_status",nullable = false)
    private ContainerStatusEnum status;

    @Column(name = "loaded_at",nullable = false)
    private LocalDateTime loadedAt;

    @Column(name = "unloaded_at",nullable = false)
    private LocalDateTime unloadedAt;

    @Column(name = "is_deleted",nullable = false)
    private Boolean isDeleted;


}
