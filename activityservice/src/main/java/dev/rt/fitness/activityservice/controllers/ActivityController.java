package dev.rt.fitness.activityservice.controllers;

import dev.rt.fitness.activityservice.dtos.ActivityRequest;
import dev.rt.fitness.activityservice.dtos.ActivityResponse;
import dev.rt.fitness.activityservice.services.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller responsible fo activity-related endpoints.
 *
 * <p>Handles HTTP requests and delegates business logic to the service layer.</p>
 */
@RestController
@RequestMapping("/api/activities")
public class ActivityController {

  private final ActivityService activityService;

  public ActivityController(ActivityService activityService) {
    this.activityService = activityService;
  }

  /**
   * Tracks a new activity.
   *
   * @param request activity creation data.
   *
   * @return the created activity response.
   */
  @PostMapping
  public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(activityService.trackActivity(request));
  }

  /**
   * Retrieves all activities associated with a specific user.
   *
   * <p>The user identifier is expected to be provided via the
   * {@code X-USER-ID} request header.</p>
   *
   * @param userId the identifier of the user whose activities are requested
   *
   * @return a list of activities performed by the user
   */
  @GetMapping
  public ResponseEntity<List<ActivityResponse>> getUserActivities(
    @RequestHeader("X-USER-ID") String userId) {
    return ResponseEntity.ok(activityService.getUserActivities(userId));
  }

  /**
   * Retrieves a specific activity by its identifier.
   *
   * <p>The activity ID is provided as a path variable. If the activity
   * exists, its details are returned in the response body.</p>
   *
   * @param activityId the unique identifier of the activity
   *
   * @return the requested activity as a response DTO
   */
  @GetMapping("/{activityId}")
  public ResponseEntity<ActivityResponse> getActivity(@PathVariable String activityId) {
    return ResponseEntity.ok(activityService.getActivityById(activityId));
  }
}
