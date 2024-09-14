package com.example.marinepath.entity;

import com.example.marinepath.entity.Enum.CargoTypeEnum;
import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Float weight;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo_type",nullable = false)
    private CargoTypeEnum type;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "is_deleted",nullable = false)
    private Boolean isDeleted;

    @OneToMany(mappedBy = "cargo")
    private List<Container> containers;


}
