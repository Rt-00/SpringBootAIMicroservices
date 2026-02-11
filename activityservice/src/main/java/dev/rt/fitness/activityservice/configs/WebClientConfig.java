package dev.rt.fitness.activityservice.configs;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Configuration class for WebClient beans.
 *
 * <p>Provides a load-balanced {@link WebClient.Builder} and a
 * dedicated {@link WebClient} instance for communicating with the user-service.</p>
 */
@Configuration
public class WebClientConfig {

  /**
   * Creates a load-balanced WebClient builder.
   *
   * <p>Service names in base URLs are resolved via the service
   * discovery mechanism.</p>
   *
   * @return a load-balanced WebClient builder
   */
  @Bean
  @LoadBalanced
  public WebClient.Builder webClientBuilder() {
    return WebClient.builder();
  }

  /**
   * Creates a WebClient configured to communicate with the user-service.
   *
   * @param webClientBuilder the load-balanced WebClient builder
   *
   * @return a WebClient targeting the user-service
   */
  @Bean
  public WebClient userServiceWebClient(WebClient.Builder webClientBuilder) {
    return webClientBuilder
      .baseUrl("http://USER-SERVICE")
      .build();
  }
}
