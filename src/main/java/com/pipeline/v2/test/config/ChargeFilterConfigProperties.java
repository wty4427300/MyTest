package com.pipeline.v2.test.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "charge")
public class ChargeFilterConfigProperties {

  private Map<String, List<String>> configs;

  public Map<String, List<String>> getConfigs() {
    return configs;
  }
}