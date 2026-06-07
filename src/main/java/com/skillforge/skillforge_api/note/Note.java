package com.skillforge.skillforge_api.note;

import com.skillforge.skillforge_api.task.Task;
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
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
