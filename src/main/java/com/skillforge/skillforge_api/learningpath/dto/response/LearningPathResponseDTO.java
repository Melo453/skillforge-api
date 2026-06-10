package com.skillforge.skillforge_api.learningpath.dto.response;

import com.skillforge.skillforge_api.learningpath.LearningPathDifficulty;
import com.skillforge.skillforge_api.learningpath.LearningPathStatus;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record LearningPathResponseDTO (Long id,
                                       String title,
                                       String description,
                                       LearningPathDifficulty difficulty,
                                       LearningPathStatus status,
                                       LocalDateTime createdAt,
                                       LocalDateTime updatedAt,
                                       String createdByEmail) {
}
