package com.example.marinepath.entity;

import com.example.marinepath.entity.Enum.ShipStatusEnum;
import com.example.marinepath.entity.Enum.ShipTypeEnum;
import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ship")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ship_code", unique = true, nullable = false)
    private String shipCode;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "ship_current_status",nullable = false)
    private ShipStatusEnum currentStatus;

    @Column(nullable = false)
    private Integer buildYear;

    @Column(nullable = false)
    private String flag;

    @Enumerated(EnumType.STRING)
    @Column(name = "ship_type",nullable = false)
    private ShipTypeEnum type;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "is_deleted",nullable = false)
    private Boolean isDeleted;

    @OneToMany(mappedBy = "ship")
    private List<Journey> journeys;

}
