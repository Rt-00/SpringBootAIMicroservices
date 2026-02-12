package dev.rt.fitness.aiservice.services;

import dev.rt.fitness.aiservice.models.Recommendation;
import dev.rt.fitness.aiservice.repository.RecommendationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer responsible for recommendation retrieval logic.
 *
 * <p>This service abstracts persistence details and defines
 * failure semantics for recommendation lookups.</p>
 */
@Service
public class RecommendationService {

  private final RecommendationRepository recommendationRepository;

  public RecommendationService(RecommendationRepository recommendationRepository) {
    this.recommendationRepository = recommendationRepository;
  }

  /**
   * Retrieves all recommendations generated for a specific user.
   *
   * @param userId the identifier of the user
   *
   * @return a list of recommendations for the user
   */
  public List<Recommendation> getUserRecommendation(String userId) {
    return recommendationRepository.findByUserId(userId);
  }

  /**
   * Retrieves the recommendation associated with a specific activity.
   *
   * @param activityId the identifier of the activity
   *
   * @return the recommendation for the activity
   *
   * @throws RuntimeException if no recommendation is found
   */
  public Recommendation getActivityRecommendation(String activityId) {
    return recommendationRepository.findByActivityId(activityId)
      .orElseThrow(() -> new RuntimeException(
        "No recommendation found by this activity: " + activityId));
  }
}
