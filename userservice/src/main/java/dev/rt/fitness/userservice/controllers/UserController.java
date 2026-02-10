package dev.rt.fitness.userservice.controllers;

import dev.rt.fitness.userservice.dtos.UserRegisterRequest;
import dev.rt.fitness.userservice.dtos.UserResponse;
import dev.rt.fitness.userservice.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller responsible fo user-related endpoints.
 *
 * <p>Handles HTTP requests and delegates business logic to the service layer.</p>
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  /**
   * Retrieve a User by ID.
   *
   * @param userId the user's ID
   *
   * @return the user's profile data as a {#{@link UserResponse}}
   */
  @GetMapping("/{userId}")
  public ResponseEntity<UserResponse> getUserProfile(@PathVariable String userId) {
    return ResponseEntity.ok(userService.getUserProfile(userId));
  }

  /**
   * Registers a new user.
   *
   * @param request validated user registration data
   *
   * @return the created user response
   */
  @PostMapping("/register")
  public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserRegisterRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(request));
  }

}
