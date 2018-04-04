package com.today.things.repo;

import com.today.things.model.TodayUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<TodayUser, Long> {

}
