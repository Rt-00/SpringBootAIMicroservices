package dev.rt.fitness.aiservice.repository;

import dev.rt.fitness.aiservice.models.Recommendation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing {@link Recommendation} documents.
 *
 * <p>Provides MongoDB persistence operations and query derivation
 * through Spring Data MongoDB.</p>
 */
@Repository
public interface RecommendationRepository extends MongoRepository<Recommendation, String> {

  /**
   * Finds all recommendations associated with a specific user.
   *
   * @param userId the identifier of the user
   *
   * @return a list of recommendations linked to the user
   */
  List<Recommendation> findByUserId(String userId);

  /**
   * Finds the recommendation associated with a specific activity.
   *
   * @param activityId the identifier of the activity
   *
   * @return an optional containing the recommendation if found
   */
  Optional<Recommendation> findByActivityId(String activityId);
}
