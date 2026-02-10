package dev.rt.fitness.userservice.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * DTO used to capture user registration input.
 */
@Data
public class UserRegisterRequest {

  /**
   * User's email address.
   *
   * <p>Must be non-blank and follow a valid email format.</p>
   */
  @NotBlank(message = "Email is required")
  @Email(message = "Invalid email format")
  private String email;

  /**
   * User's raw password.
   *
   * <p>Must be non-blank and contain at least 6 characters.</p>
   */
  @NotBlank(message = "Password is required")
  @Size(min = 6, message = "Password must have at least 6 characters")
  private String password;

  /**
   * User's first name.
   *
   * <p>Must be non-blank and contain at least 2 characters.</p>
   */
  @NotBlank(message = "First name is required")
  @Size(min = 2, message = "First name must have at least 2 characters")
  private String firstName;

  /**
   * User's last name.
   *
   * <p>Must be non-blank and contain at least 2 characters.</p>
   */
  @NotBlank(message = "Last name is required")
  @Size(min = 2, message = "Last name must have at least 2 characters")
  private String lastName;
}
