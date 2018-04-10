package com.today.things.repo;

import com.today.things.model.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> {
    ActivityType findTop1ById(Long id);
}
