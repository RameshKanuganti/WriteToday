package com.today.things.repo;

import com.today.things.model.ActivityTypeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityTypeDetailRepository extends JpaRepository<ActivityTypeDetails, Long> {

    List<ActivityTypeDetails> findAllByActivityType_Id(Long activityTypeId);

}
