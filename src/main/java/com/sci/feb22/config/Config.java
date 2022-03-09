package com.sci.feb22.config;

import java.util.Scanner;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

  @Bean
  public Scanner getScanner() {
    return new Scanner("aha kjh oiur");
  }
}
