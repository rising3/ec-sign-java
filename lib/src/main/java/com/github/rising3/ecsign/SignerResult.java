package com.github.rising3.ecsign;

public final class SignerResult {
  private long timestamp;
  private String signature;

  public SignerResult(long timestamp, String signature) {
    assert signature != null;

    this.timestamp = timestamp;
    this.signature = signature;
  }

  public long getTimestamp() {
    return this.timestamp;
  }

  public String getSignature() {
    return this.signature;
  }
}
