package com.prode.repository;

import com.prode.entity.User;
import com.prode.entity.UserMatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMatchRepository extends JpaRepository<UserMatch, Long> {

    List<UserMatch> findAllByUser(User user);
}
