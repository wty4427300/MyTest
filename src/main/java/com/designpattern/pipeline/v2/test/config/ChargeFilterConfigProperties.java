package com.designpattern.pipeline.v2.test.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "charge")
@Component
public class ChargeFilterConfigProperties {

  private Map<String, List<String>> configs;

  public Map<String, List<String>> getConfigs() {
    return configs;
  }
}