package com.today.things.repo;

import com.today.things.model.ActivityTypeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityTypeDetailRepository extends JpaRepository<ActivityTypeDetails, Long> {
}
