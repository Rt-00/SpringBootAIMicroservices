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
  private final UserValidationService userValidationService;

  public ActivityService(ActivityRepository activityRepository,
    UserValidationService userValidationService) {
    this.activityRepository = activityRepository;
    this.userValidationService = userValidationService;
  }

  /**
   * Tracks a new activity in the system.
   *
   * <p>This method validates the user against the user service,
   * maps the incoming request to a domain model, persists it, and returns a response DTO.</p>
   *
   * @param request activity creation data
   *
   * @return the newly created activity as a response DTO
   *
   * @throws RuntimeException if the user does not exist or is invalid
   */
  public ActivityResponse trackActivity(ActivityRequest request) {
    boolean isValidUser = userValidationService.validateUser(request.getUserId());

    if (!isValidUser) {
      throw new RuntimeException("Invalid User: " + request.getUserId());
    }

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

  /**
   * Retrieves an activity by its identifier.
   *
   * <p>This method queries the persistence layer for the activity and maps
   * it to a response DTO. If no activity is found, an exception is thrown.</p>
   *
   * @param activityId the unique identifier of the activity
   *
   * @return the activity as a response DTO
   *
   * @throws RuntimeException if no activity with the given ID exists
   */
  public ActivityResponse getActivityById(String activityId) {
    return activityRepository.findById(activityId)
      .map(ActivityMapper::toResponse)
      .orElseThrow(() -> new RuntimeException("Activity not found with this ID: " + activityId));
  }
}
