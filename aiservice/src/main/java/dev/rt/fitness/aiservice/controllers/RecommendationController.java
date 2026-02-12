package dev.rt.fitness.aiservice.controllers;

import dev.rt.fitness.aiservice.models.Recommendation;
import dev.rt.fitness.aiservice.services.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller responsible for recommendation-related endpoints.
 */
@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

  private final RecommendationService recommendationService;

  public RecommendationController(RecommendationService recommendationService) {
    this.recommendationService = recommendationService;
  }

  /**
   * Retrieves all recommendations associated with a specific user.
   *
   * @param userId the identifier of the user
   *
   * @return a list of recommendations generated for the user
   */
  @GetMapping("/user/{userId}")
  public ResponseEntity<List<Recommendation>> getUserRecommendation(@PathVariable String userId) {
    return ResponseEntity.ok(recommendationService.getUserRecommendation(userId));
  }

  /**
   * Retrieves the recommendation associated with a specific activity.
   *
   * @param activityId the identifier of the activity
   *
   * @return the recommendation generated for the activity
   */
  @GetMapping("/activity/{activityId}")
  public ResponseEntity<Recommendation> getActivityRecommendation(
    @PathVariable String activityId) {
    return ResponseEntity.ok(recommendationService.getActivityRecommendation(activityId));
  }
}
