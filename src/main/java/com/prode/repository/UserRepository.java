package com.prode.repository;

import com.prode.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByMail(String mail);

}
