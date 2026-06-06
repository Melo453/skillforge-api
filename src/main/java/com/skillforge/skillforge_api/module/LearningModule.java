package com.skillforge.skillforge_api.module;

import com.skillforge.skillforge_api.learningpath.LearningPath;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "learning_modules")
public class LearningModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer moduleOrder;
    @ManyToOne
    @JoinColumn(name = "learning_path_id")
    private LearningPath learningPath;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
