package dev.rt.fitness.userservice.mappers;

import dev.rt.fitness.userservice.dtos.UserRegisterRequest;
import dev.rt.fitness.userservice.dtos.UserResponse;
import dev.rt.fitness.userservice.models.User;

/**
 * Utility class responsible for mapping between User entities and DTOs.
 */
public class UserMapper {

  /**
   * Converts a user registration request DTO into a User entity.
   *
   * @param request the incoming registration data.
   *
   * @return a User entity populated with request data.
   */
  public static User toModel(UserRegisterRequest request) {
    User user = new User();
    user.setEmail(request.getEmail());
    user.setPassword(request.getPassword());
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());

    return user;
  }

  /**
   * Converts a User entity into a response DTO.
   *
   * <p>Excludes sensitive fields such as the password.</p>
   *
   * @param user the persisted user entity
   *
   * @return a response DTO suitable for API output
   */
  public static UserResponse toResponse(User user) {
    UserResponse userResponse = new UserResponse();
    userResponse.setId(user.getId());
    userResponse.setEmail(user.getEmail());
    userResponse.setFirstName(user.getFirstName());
    userResponse.setLastName(user.getLastName());
    userResponse.setRole(user.getRole());
    userResponse.setCreatedAt(user.getCreatedAt());
    userResponse.setUpdatedAt(user.getUpdatedAt());

    return userResponse;
  }
}
