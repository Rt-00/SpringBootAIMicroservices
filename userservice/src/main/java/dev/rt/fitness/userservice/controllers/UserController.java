package dev.rt.fitness.userservice.controllers;

import dev.rt.fitness.userservice.dtos.UserRegisterRequest;
import dev.rt.fitness.userservice.dtos.UserResponse;
import dev.rt.fitness.userservice.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/{userId}")
  public ResponseEntity<UserResponse> getUserProfile(@PathVariable String userId) {
    return ResponseEntity.ok(userService.getUserProfile(userId));
  }

  @PostMapping("/register")
  public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserRegisterRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(request));
  }

}
