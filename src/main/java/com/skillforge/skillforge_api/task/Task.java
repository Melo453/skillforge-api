package com.skillforge.skillforge_api.task;

import com.skillforge.skillforge_api.module.LearningModule;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer taskOrder;
    @ManyToOne
    @JoinColumn(name = "learning_module_id")
    private LearningModule learningModule;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
