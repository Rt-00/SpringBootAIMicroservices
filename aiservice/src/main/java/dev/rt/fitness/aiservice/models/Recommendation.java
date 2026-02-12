package dev.rt.fitness.aiservice.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents an AI-generated recommendation for a user's activity.
 */
@Document(collection = "recommendations")
@Data
public class Recommendation {
  /**
   * Unique identifier of the recommendation document.
   */
  @Id
  private String id;

  /**
   * Identifier of the activity associated with this recommendation.
   */
  private String activityId;

  /**
   * Identifier of the user who performed the activity.
   */
  private String userId;

  /**
   * Type of activity analyzed.
   */
  private String activityType;

  /**
   * General AI-generated recommendation summary.
   *
   * <p>This field contains the primary narrative feedback.</p>
   */
  private String recommendation;

  /**
   * List of identified areas for improvement.
   */
  private List<String> improvements;

  /**
   * List of actionable suggestions for future sessions.
   */
  private List<String> suggestions;

  /**
   * List of safety-related considerations.
   *
   * <p>Includes warnings or precautions relevant to the activity.</p>
   */
  private List<String> safety;

  /**
   * Timestamp indicating when the recommendation was generated.
   *
   * <p>Automatically set by Spring Data MongoDB auditing.</p>
   */
  @CreatedDate
  private LocalDateTime createdAt;
}