package dev.rt.fitness.userservice.services;

import dev.rt.fitness.userservice.dtos.UserRegisterRequest;
import dev.rt.fitness.userservice.dtos.UserResponse;
import dev.rt.fitness.userservice.mappers.UserMapper;
import dev.rt.fitness.userservice.models.User;
import dev.rt.fitness.userservice.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Service layer responsible for user-related business logic.
 */
@Service
@Slf4j
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * Retrieves the profile information of a user by its identifier.
   *
   * <p>This method looks up the user in the persistence layer and returns
   * a read-only representation suitable for API responses.</p>
   *
   * @param userId the user's ID
   *
   * @return the user's profile data as a {#{@link UserResponse}}
   *
   * @throws RuntimeException if no user with the given ID is found
   */
  public UserResponse getUserProfile(String userId) {
    User user = userRepository.findById(userId)
      .orElseThrow(() -> new RuntimeException("User not found"));

    return UserMapper.toResponse(user);
  }

  /**
   * Registers a new user in the system.
   *
   * <p>This method verifies email uniqueness, maps the incoming request
   * to a domain model, persists it, and returns a response DTO.</p>
   *
   * @param request user registration data
   *
   * @return the newly created user as a response DTO
   *
   * @throws RuntimeException if the email already exists
   */
  public UserResponse registerUser(UserRegisterRequest request) {
    if (userRepository.existsByEmail(request.getEmail())) {
      throw new RuntimeException("Email already exists");
    }

    User user = UserMapper.toModel(request);
    User savedUser = userRepository.save(user);

    return UserMapper.toResponse(savedUser);
  }

  /**
   * Checks whether a user exists with the given identifier.
   *
   * @param userId the unique identifier of the user
   *
   * @return {@code true} if a user with the given ID exists, otherwise {@code false}
   */
  public Boolean existsByUserId(String userId) {
    log.info("Calling User Validation API for userID: {}", userId);
    return userRepository.existsById(userId);
  }
}
