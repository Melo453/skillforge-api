    package com.skillforge.skillforge_api.learningpath;

    import com.skillforge.skillforge_api.learningpath.dto.request.LearningPathCreateRequestDTO;
    import com.skillforge.skillforge_api.learningpath.dto.response.LearningPathResponseDTO;
    import com.skillforge.skillforge_api.user.User;
    import com.skillforge.skillforge_api.user.UserRepository;
    import org.springframework.security.authentication.AnonymousAuthenticationToken;
    import org.springframework.security.core.Authentication;
    import org.springframework.security.core.context.SecurityContextHolder;
    import org.springframework.stereotype.Service;
    import org.springframework.web.bind.annotation.PathVariable;

    import java.time.LocalDateTime;
    import java.util.List;
    import java.util.Optional;

    @Service
    public class LearningPathService {

        private final LearningPathRepository learningPathRepository;
        private final UserRepository userRepository;

        public LearningPathService(LearningPathRepository learningPathRepository, UserRepository userRepository) {
            this.learningPathRepository = learningPathRepository;
            this.userRepository = userRepository;
        }

        public LearningPathResponseDTO createLearningPath(LearningPathCreateRequestDTO request){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (authentication == null || (authentication instanceof AnonymousAuthenticationToken)) {
                throw new IllegalArgumentException("Error");
            }
            String email = authentication.getName();

            User createdBy = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("error"));
            LearningPath learningPath = new LearningPath();
            learningPath.setTitle(request.title());
            learningPath.setDescription(request.description());
            learningPath.setDifficulty(request.difficulty());
            learningPath.setStatus(LearningPathStatus.DRAFT);
            learningPath.setCreatedAt(LocalDateTime.now());
            learningPath.setUpdatedAt(LocalDateTime.now());
            learningPath.setCreatedBy(createdBy);

            LearningPath savedLearningPath = learningPathRepository.save(learningPath);

            return mapToResponseDTO(savedLearningPath);
        }

        public List<LearningPathResponseDTO> getAllPaths(){
            List<LearningPath> entities = learningPathRepository.findAll();


            return entities.stream()
                    .map(this::mapToResponseDTO)
                    .toList();
        }

        public LearningPathResponseDTO getPathById(Long id){
            LearningPath learningPath = learningPathRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Learning path not found"));

            return mapToResponseDTO(learningPath);
        }

        public LearningPathResponseDTO publishLearningPath(Long id){
            LearningPath learningPath = learningPathRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Learning path not found"));
            learningPath.setStatus(LearningPathStatus.PUBLISHED);
            learningPath.setUpdatedAt(LocalDateTime.now());

            LearningPath savedLearningPath = learningPathRepository.save(learningPath);

            return mapToResponseDTO(savedLearningPath);
        }

        private LearningPathResponseDTO mapToResponseDTO(LearningPath learningPath){
            return new LearningPathResponseDTO(learningPath.getId(),
                    learningPath.getTitle(),
                    learningPath.getDescription(),
                    learningPath.getDifficulty(),
                    learningPath.getStatus(),
                    learningPath.getCreatedAt(),
                    learningPath.getUpdatedAt(),
                    learningPath.getCreatedBy().getEmail());
        }
    }
