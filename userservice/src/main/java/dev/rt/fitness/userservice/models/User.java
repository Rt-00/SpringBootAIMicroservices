package dev.rt.fitness.userservice.models;

import dev.rt.fitness.userservice.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {

  /**
   * User's ID.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  /**
   * User's email.
   */
  @Column(unique = true, nullable = false)
  private String email;

  /**
   * User's password.
   */
  @Column(nullable = false)
  private String password;

  /**
   * User's first name.
   */
  @Column(nullable = false)
  private String firstName;

  /**
   * User's last name.
   */
  @Column(nullable = false)
  private String lastName;

  /**
   * User's role
   */
  private UserRole role = UserRole.USER;

  /**
   * Timestamp indicating when the user record was created.
   */
  @CreationTimestamp
  private LocalDateTime createdAt;

  /**
   * Timestamp indicating when the user record was last updated.
   */
  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
