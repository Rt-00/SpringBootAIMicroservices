package dev.rt.fitness.activityservice.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

/**
 * Service responsible for validating users via the user-service.
 *
 * <p>This service performs synchronous HTTP calls to verify whether
 * a user exists before allowing activity-related operations.</p>
 */
@Service
@Slf4j
public class UserValidationService {

  private final WebClient userServiceWebClient;

  public UserValidationService(WebClient userServiceWebClient) {
    this.userServiceWebClient = userServiceWebClient;
  }

  /**
   * Validates the existence of a user by its identifier.
   *
   * <p>This method calls the user-service validation endpoint and
   * blocks until a response is received.</p>
   *
   * @param userId the identifier of the user to validate
   *
   * @return {@code true} if the user is valid
   *
   * @throws RuntimeException if the user does not exist or the request is invalid
   */
  public boolean validateUser(String userId) {
    log.info("Calling User Validation API for userID: {}", userId);
    try {
      return Boolean.TRUE.equals(userServiceWebClient.get()
        .uri("/api/users/{userId}/validate", userId)
        .retrieve()
        .bodyToMono(Boolean.class)
        .block());
    } catch (WebClientResponseException e) {
      if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
        throw new RuntimeException("User not found with this ID: " + userId);
      } else if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
        throw new RuntimeException("Invalid request for this ID: " + userId);
      }
    }

    return false;
  }
}
