package com.today.things.repo;

import com.today.things.model.TodayUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodayUserRepository extends JpaRepository<TodayUser, Long> {

    TodayUser findTop1ByEmailIdAndPassword(String emailId, String password);

    Optional<TodayUser> findTop1ByEmailId(String emailId);
}
