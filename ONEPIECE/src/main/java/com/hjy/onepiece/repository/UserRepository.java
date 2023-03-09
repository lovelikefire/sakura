package com.hjy.onepiece.repository;

import com.hjy.onepiece.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
        @Query(value = "select * from user where id =?",nativeQuery = true)
        User getById(long id);

        @Query(value = "select * from user where username =?",nativeQuery = true)
        User getByName(String username);
}
