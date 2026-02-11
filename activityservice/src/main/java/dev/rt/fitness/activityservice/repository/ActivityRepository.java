package dev.rt.fitness.activityservice.repository;

import dev.rt.fitness.activityservice.models.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing {@link Activity} entities.
 */
@Repository
public interface ActivityRepository extends MongoRepository<Activity, String> {
}
