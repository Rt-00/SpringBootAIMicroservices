package dev.rt.fitness.activityservice.controllers;

import dev.rt.fitness.activityservice.dtos.ActivityRequest;
import dev.rt.fitness.activityservice.dtos.ActivityResponse;
import dev.rt.fitness.activityservice.services.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
