package com.today.things.repo;

import com.today.things.model.ActivityQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityQuestionRepository extends JpaRepository<ActivityQuestion, Long> {

}
