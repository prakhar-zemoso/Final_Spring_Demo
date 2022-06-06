package com.prakhar.shopping.finalShopping2.repository;

import com.prakhar.shopping.finalShopping2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    @Query("select c from User c where c.email = ?1")
    User findByEmail(String email);
}
