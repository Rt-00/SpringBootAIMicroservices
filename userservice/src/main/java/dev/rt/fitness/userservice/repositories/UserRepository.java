package dev.rt.fitness.userservice.repositories;

import dev.rt.fitness.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing {@link User} entities.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

  /**
   * Checks whether a user with the given email already exists.
   *
   * @param email the email address to check
   *
   * @return {@code true} if a user with the given email exists, otherwise {@code false}
   */
  boolean existsByEmail(String email);
}
