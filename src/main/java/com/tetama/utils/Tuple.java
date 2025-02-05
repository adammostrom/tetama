package com.example.tetama.utils;

public class Tuple<X, Y> {
  public final X first;
  public final Y second;

  public Tuple(X first, Y second) {
    this.first = first;
    this.second = second;
  }

  public X returnFirst(){
    return this.first;
  }

  public Y returnSecond(){
    return this.second;
  }

  @Override
  public String toString() {
    return "(" + first + ", " + second + ")";
  }
}
