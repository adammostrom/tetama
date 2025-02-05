package com.example.tetama;

public enum Priority {

  NA(0),
  INSIGNIFICANT(1),
  LOW(2),
  MEDIUM(3),
  HIGH(4),
  URGENT(5);

  private final int value;


  // An enum element is sort of a constructor, so we create the element to hold a value, and then we make a constructor
  // that sets a internal parameter "value" as the input it is, and then we can return the value for comparison and sorting.
  Priority(int value){
    this.value = value;
  }

  public int getValue(){
    return value;
  }

}
