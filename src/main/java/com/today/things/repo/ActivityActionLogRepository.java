package com.today.things.repo;

import com.today.things.model.ActivityActionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityActionLogRepository extends JpaRepository<ActivityActionLog, Long> {

}
