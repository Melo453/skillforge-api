package com.skillforge.skillforge_api.progress;

import com.skillforge.skillforge_api.learningpath.LearningPath;
import com.skillforge.skillforge_api.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_learning_paths")
public class UserLearningPath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "learning_path_id")
    private LearningPath learningPath;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
    private Integer progressPercentage;
    private boolean active;
}
