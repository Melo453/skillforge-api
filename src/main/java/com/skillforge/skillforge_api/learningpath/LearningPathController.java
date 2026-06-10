package com.skillforge.skillforge_api.learningpath;

import com.skillforge.skillforge_api.learningpath.dto.request.LearningPathCreateRequestDTO;
import com.skillforge.skillforge_api.learningpath.dto.response.LearningPathResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/learning-paths")
public class LearningPathController {

    private final LearningPathService learningPathService;

    public LearningPathController(LearningPathService learningPathService) {
        this.learningPathService = learningPathService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<LearningPathResponseDTO> create(@Valid @RequestBody LearningPathCreateRequestDTO learningPathCreateRequestDTO){

        LearningPathResponseDTO response = learningPathService.createLearningPath(learningPathCreateRequestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public List<LearningPathResponseDTO> listLearningPaths(){
        return learningPathService.getAllPaths();
    }
    @GetMapping("/{id}")
    public ResponseEntity<LearningPathResponseDTO> getLearningPathById(@PathVariable Long id){
        LearningPathResponseDTO response =  learningPathService.getPathById(id);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{id}/publish")
    public ResponseEntity<LearningPathResponseDTO> publishLearningPathById(@PathVariable Long id){
        LearningPathResponseDTO response = learningPathService.publishLearningPath(id);
        return ResponseEntity.ok(response);
    }
}
