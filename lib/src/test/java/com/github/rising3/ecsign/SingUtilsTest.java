package com.github.rising3.ecsign;

import static com.github.rising3.ecsign.EcSginConstants.*;
import static com.github.rising3.ecsign.EcSignTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SingUtilsTest {

  @ParameterizedTest
  @ValueSource(strings = {"secp256r1", "secp384r1", "secp256k1"})
  void testGenerateKeyPair(String nc) throws Exception {
    final KeyPair actual = SignUtils.generateKeyPair(nc);
    assertTrue(actual.getPublic() instanceof PublicKey);
    assertTrue(actual.getPrivate() instanceof PrivateKey);
  }

  @ParameterizedTest
  @ValueSource(strings = {"secp256r1", "secp384r1", "secp256k1"})
  void testToPublicKeyPem(String nc) throws Exception {
    final KeyPair kp = SignUtils.generateKeyPair(nc);
    final String actual = SignUtils.toPem(kp.getPublic());
    assertTrue(actual.matches(REGEX_PUBLIC_PEM));
  }

  @ParameterizedTest
  @ValueSource(strings = {"secp256r1", "secp384r1", "secp256k1"})
  void testToPrivateKeyPem(String nc) throws Exception {
    final KeyPair kp = SignUtils.generateKeyPair(nc);
    final String actual = SignUtils.toPem(kp.getPrivate());
    assertTrue(actual.matches(REGEX_PRIVATE_PEM));
  }

  @ParameterizedTest
  @ValueSource(
      strings = {
        TEST_PUBLIC_KEY_PEM,
        TEST_PUBLIC_KEY_PEM_WITH_P384,
        TEST_PUBLIC_KEY_PEM_WITH_SECP256K1
      })
  void testToPublicKey(String pem) throws Exception {
    final PublicKey actual = SignUtils.toPublicKey(pem);
    assertTrue(actual instanceof PublicKey);
    assertTrue(SignUtils.toPublicKey(actual.getEncoded()) instanceof PublicKey);
  }

  @ParameterizedTest
  @ValueSource(
      strings = {
        TEST_PRIVATE_KEY_PEM,
        TEST_PRIVATE_KEY_PEM_WITH_P384,
        TEST_PRIVATE_KEY_PEM_WITH_SECP256K1
      })
  void testToPrivateKey(String pem) throws Exception {
    final PrivateKey actual = SignUtils.toPrivateKey(pem);
    assertTrue(actual instanceof PrivateKey);
    assertTrue(SignUtils.toPrivateKey(actual.getEncoded()) instanceof PrivateKey);
  }

  @Test
  void testTimestamp() throws Exception {
    assertNotNull(SignUtils.timestamp());
  }
}
