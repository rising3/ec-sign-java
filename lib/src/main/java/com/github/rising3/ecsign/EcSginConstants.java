package com.github.rising3.ecsign;

final class EcSginConstants {
  protected static final String ALGORITHM_ECDSA = "ECDSA";
  protected static final String SECURITY_PROVIDER = "BC";
  protected static final String DEFAULT_NAMED_CURVE = "secp256r1";
  protected static final String DEFAULT_HASH_ALGO = "SHA256withECDSA";
  protected static final String BEGIN_PUBLIC_KEY = "-----BEGIN PUBLIC KEY-----";
  protected static final String END_PUBLIC_KEY = "-----END PUBLIC KEY-----";
  protected static final String BEGIN_PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----";
  protected static final String END_PRIVATE_KEY = "-----END PRIVATE KEY-----";
  protected static final String REGEX_PUBLIC_PEM =
      "(-----BEGIN PUBLIC KEY-----(\\n|\\r|\\r\\n)([0-9a-zA-Z\\+\\/=]{64}(\\n|\\r|\\r\\n))*([0-9a-zA-Z\\+\\/=]{1,63}(\\n|\\r|\\r\\n))?-----END PUBLIC KEY-----(\\n|\\r|\\r\\n|))";
  protected static final String REGEX_PRIVATE_PEM =
      "(-----BEGIN PRIVATE KEY-----(\\n|\\r|\\r\\n)([0-9a-zA-Z\\+\\/=]{64}(\\n|\\r|\\r\\n))*([0-9a-zA-Z\\+\\/=]{1,63}(\\n|\\r|\\r\\n))?-----END PRIVATE KEY-----(\\n|\\r|\\r\\n|))";

  private EcSginConstants() {}
}
