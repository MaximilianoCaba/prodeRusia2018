package com.prode.repository;

import com.prode.entity.Match;
import com.prode.entity.MatchUser;
import com.prode.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchUserRepository extends JpaRepository<MatchUser, Long> {

    List<MatchUser> findAllByUser(User user);

    List<MatchUser> findByMatch(Match match);
}
