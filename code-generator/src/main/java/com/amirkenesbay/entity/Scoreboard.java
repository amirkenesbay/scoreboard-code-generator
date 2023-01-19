package com.amirkenesbay.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "scoreboard", schema = "scoreboard_schema")
@Getter
@Setter
public class Scoreboard {

    @Id
    @Column(name = "code_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeId;

    @Column(name = "code_name")
    private String codeName;
}
