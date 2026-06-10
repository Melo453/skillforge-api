package com.skillforge.skillforge_api.learningpath.dto.request;


import com.skillforge.skillforge_api.learningpath.LearningPathDifficulty;
import jakarta.validation.constraints.NotBlank;

public record LearningPathCreateRequestDTO(@NotBlank String title,
                                           @NotBlank String description,
                                           LearningPathDifficulty difficulty) {
}
