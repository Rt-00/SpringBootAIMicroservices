package dev.rt.fitness.aiservice.services;

import dev.rt.fitness.aiservice.models.Activity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ActivityMessageListener {

  /**
   * Receives and process an Activity through the Rabbit MQ.
   *
   * @param activity a physical activity performed by a user.
   */
  @RabbitListener(queues = "activity.queue")
  public void processActivity(Activity activity) {
    log.info("Received activity for procesing: {}", activity.getId());
  }
}
