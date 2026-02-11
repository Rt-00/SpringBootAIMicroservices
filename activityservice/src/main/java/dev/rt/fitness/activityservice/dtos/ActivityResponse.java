package dev.rt.fitness.activityservice.dtos;

import dev.rt.fitness.activityservice.enums.ActivityType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * DTO used to capture activity creation input.
 */
@Data
public class ActivityResponse {
  /**
   * Unique identifier of the activity document.
   */
  private String id;

  /**
   * Identifier of the user who performed the activity.
   */
  private String userId;

  /**
   * Type of physical activity performed.
   */
  private ActivityType type;

  /**
   * Duration of the activity in minutes.
   */
  private Integer duration;

  /**
   * Estimated number of calories burned during the activity.
   */
  private Integer caloriesBurned;

  /**
   * Date and time when the activity started.
   */
  private LocalDateTime startTime;

  /**
   * Additional activity-specific metrics.
   *
   * <p>This field allows flexible storage of extra data such as:
   * distance, pace, heart rate, repetitions, or intensity.</p>
   */
  private Map<String, Object> additionalMetrics;

  /**
   * Timestamp indicating when the activity document was created.
   */
  private LocalDateTime createdAt;

  /**
   * Timestamp indicating when the activity document was last updated.
   */
  private LocalDateTime updatedAt;
}
