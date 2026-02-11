package dev.rt.fitness.activityservice.mappers;

import dev.rt.fitness.activityservice.dtos.ActivityRequest;
import dev.rt.fitness.activityservice.dtos.ActivityResponse;
import dev.rt.fitness.activityservice.models.Activity;

/**
 * Utility class responsible for mapping between Activity entities and DTOs.
 */
public class ActivityMapper {

  /**
   * Converts activity creation request DTO into an Activity entity.
   *
   * @param request the incoming creation data.
   *
   * @return an Activity entity populated with request data.
   */
  public static Activity toModel(ActivityRequest request) {
    Activity activity = new Activity();
    activity.setUserId(request.getUserId());
    activity.setType(request.getType());
    activity.setDuration(request.getDuration());
    activity.setCaloriesBurned(request.getCaloriesBurned());
    activity.setStartTime(request.getStartTime());
    activity.setAdditionalMetrics(request.getAdditionalMetrics());

    return activity;
  }

  /**
   * Converts an Activity entity into a response DTO.
   *
   * @param activity the persisted activity entity
   *
   * @return a response DTO suitable for API output
   */
  public static ActivityResponse toResponse(Activity activity) {
    ActivityResponse response = new ActivityResponse();
    response.setId(activity.getId());
    response.setUserId(activity.getUserId());
    response.setType(activity.getType());
    response.setDuration(activity.getDuration());
    response.setCaloriesBurned(activity.getCaloriesBurned());
    response.setStartTime(activity.getStartTime());
    response.setAdditionalMetrics(activity.getAdditionalMetrics());
    response.setCreatedAt(activity.getCreatedAt());
    response.setUpdatedAt(activity.getUpdatedAt());

    return response;
  }
}
