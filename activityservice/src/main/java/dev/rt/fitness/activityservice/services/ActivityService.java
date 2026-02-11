package dev.rt.fitness.activityservice.services;

import dev.rt.fitness.activityservice.dtos.ActivityRequest;
import dev.rt.fitness.activityservice.dtos.ActivityResponse;
import dev.rt.fitness.activityservice.mappers.ActivityMapper;
import dev.rt.fitness.activityservice.models.Activity;
import dev.rt.fitness.activityservice.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer responsible for activity-related business logic.
 */
@Service
public class ActivityService {

  private final ActivityRepository activityRepository;

  public ActivityService(ActivityRepository activityRepository) {
    this.activityRepository = activityRepository;
  }

  /**
   * Tracking Activity in the system.
   *
   * <p>This method maps the incoming request.
   * to a domain model, persists it, and returns a respose DTO.</p>
   *
   * @param request activity creation data.
   *
   * @return the newly created activity as responsible DTO.
   */
  public ActivityResponse trackActivity(ActivityRequest request) {
    Activity activity = ActivityMapper.toModel(request);

    Activity savedActivity = activityRepository.save(activity);

    return ActivityMapper.toResponse(savedActivity);
  }

  /**
   * Retrieves all activities performed by a given user.
   *
   * <p>This method queries the persistence layer for activities associated
   * with the specified user identifier and maps them to response DTOs.</p>
   *
   * @param userId the identifier of the user
   *
   * @return a list of activities belonging to the user
   */
  public List<ActivityResponse> getUserActivities(String userId) {
    List<Activity> activities = activityRepository.findByUserId(userId);

    return activities.stream()
      .map(ActivityMapper::toResponse)
      .toList();
  }
}
