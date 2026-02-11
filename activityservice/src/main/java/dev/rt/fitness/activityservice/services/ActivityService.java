package dev.rt.fitness.activityservice.services;

import dev.rt.fitness.activityservice.dtos.ActivityRequest;
import dev.rt.fitness.activityservice.dtos.ActivityResponse;
import dev.rt.fitness.activityservice.mappers.ActivityMapper;
import dev.rt.fitness.activityservice.models.Activity;
import dev.rt.fitness.activityservice.repository.ActivityRepository;
import org.springframework.stereotype.Service;

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
}
