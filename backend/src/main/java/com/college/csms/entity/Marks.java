package com.college.csms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "marks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private Integer marksObtained;
    private Integer maxMarks;
    private Integer semester;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private LocalDateTime createdAt = LocalDateTime.now();
}
