package com.iris.msirismicroservicetemplate.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RECORDSET")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecordSet {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name", unique = true)
    private String name;

    @Column(name = "Gender", unique = true)
    private String gender;

    @Column(name = "Description", unique = true)
    private String description;
}
