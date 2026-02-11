package dev.rt.fitness.activityservice.models;

import dev.rt.fitness.activityservice.enums.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Represents a physical activity performed by a user.
 */
@Document(collection = "activities")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Activity {

  /**
   * Unique identifier of the activity document.
   */
  @Id
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
  @Field("metrics")
  private Map<String, Object> additionalMetrics;

  /**
   * Timestamp indicating when the activity document was created.
   */
  @CreatedDate
  private LocalDateTime createdAt;

  /**
   * Timestamp indicating when the activity document was last updated.
   */
  @LastModifiedDate
  private LocalDateTime updatedAt;
}