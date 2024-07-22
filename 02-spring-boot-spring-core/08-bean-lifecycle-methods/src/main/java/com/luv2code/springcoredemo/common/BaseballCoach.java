package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

  public BaseballCoach() {
    System.out.println("In constructor " + this.getClass().getName());
  }

  @Override
  public String getDailyWorkout() {
    return "Spend 30 minutes on batting practice";
  }
}
