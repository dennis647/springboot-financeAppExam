package org.kristiania.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.kristiania.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
