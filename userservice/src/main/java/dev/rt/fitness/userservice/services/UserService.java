package dev.rt.fitness.userservice.services;

import dev.rt.fitness.userservice.dtos.UserRegisterRequest;
import dev.rt.fitness.userservice.dtos.UserResponse;
import dev.rt.fitness.userservice.mappers.UserMapper;
import dev.rt.fitness.userservice.models.User;
import dev.rt.fitness.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Service layer responsible for user-related business logic.
 */
@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
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
}
