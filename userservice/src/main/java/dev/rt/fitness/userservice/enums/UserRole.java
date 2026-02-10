package dev.rt.fitness.userservice.enums;

/**
 * Represents the role assigned to a user.
 *
 * <p></p>User roles are used to define authorization levels and control access to protected
 * resources and actions.</p>
 *
 * <ul>
 *   <li>{@link #USER} - Standard user with basic permissions.</li>
 *   <li>{@link #ADMIN} - Administrator with elevated privileges.</li>
 * </ul>
 */
public enum UserRole {
  USER,
  ADMIN
}
