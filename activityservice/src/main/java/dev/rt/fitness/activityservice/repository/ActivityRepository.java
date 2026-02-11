package dev.rt.fitness.activityservice.repository;

import dev.rt.fitness.activityservice.models.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing {@link Activity} entities.
 */
@Repository
public interface ActivityRepository extends MongoRepository<Activity, String> {
  /**
   * Finds all activities associated with a specific user.
   *
   * <p>The query is derived from the method name and executed by
   * Spring Data MongoDB.</p>
   *
   * @param userId the identifier of the user
   *
   * @return a list of activities linked to the given user
   */
  List<Activity> findByUserId(String userId);
}
