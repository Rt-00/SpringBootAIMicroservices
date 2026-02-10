package dev.rt.fitness.userservice.dtos;

import dev.rt.fitness.userservice.enums.UserRole;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Data Transfer Object used to expose user data in API responses.
 *
 * <p>This DTO represents a view of a user entity</p>
 */
@Data
public class UserResponse {
  /**
   * User's ID.
   */
  private String id;

  /**
   * User's email address.
   */
  private String email;

  /**
   * User's first name.
   */
  private String firstName;

  /**
   * User's last name.
   */
  private String lastName;

  /**
   * Role assigned to the user within the system.
   */
  private UserRole role;

  /**
   * Timestamp indicating when the user was created.
   */
  private LocalDateTime createdAt;

  /**
   * Timestamp indicating the last update to the user.
   */
  private LocalDateTime updatedAt;
}
