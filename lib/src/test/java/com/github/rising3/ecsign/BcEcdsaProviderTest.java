package com.github.rising3.ecsign;

import static com.github.rising3.ecsign.EcSginConstants.*;
import static org.junit.jupiter.api.Assertions.*;

import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.Signature;
import org.junit.jupiter.api.Test;

class BcEcdsaProviderTest {
  @Test
  void testGetKeyPairGenerator() throws Exception {
    final KeyPairGenerator actual = BcEcdsaProvider.getKeyPairGenerator();
    assertEquals(ALGORITHM_ECDSA, actual.getAlgorithm());
    assertTrue(actual.getProvider().contains(SECURITY_PROVIDER));
  }

  @Test
  void testGetKeyFactory() throws Exception {
    final KeyFactory actual = BcEcdsaProvider.getKeyFactory();
    assertEquals(ALGORITHM_ECDSA, actual.getAlgorithm());
    assertTrue(actual.getProvider().contains(SECURITY_PROVIDER));
  }

  @Test
  void testGetSignature() throws Exception {
    final Signature actual = BcEcdsaProvider.getSignature(DEFAULT_HASH_ALGO);
    assertEquals(DEFAULT_HASH_ALGO, actual.getAlgorithm());
    assertTrue(actual.getProvider().contains(SECURITY_PROVIDER));
  }
}
