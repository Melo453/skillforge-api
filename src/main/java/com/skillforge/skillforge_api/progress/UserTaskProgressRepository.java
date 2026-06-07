package com.skillforge.skillforge_api.progress;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTaskProgressRepository extends JpaRepository<UserTaskProgress, Long> {
}
