package com.github.rising3.ecsign;

import static com.github.rising3.ecsign.EcSginConstants.*;
import static org.junit.jupiter.api.Assertions.*;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import org.junit.jupiter.api.Test;

class EcKeyFactoryTest {
  static final String PUBLIC_KEY_B64DER =
      "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEC8fg3tAQ897GH6Vj5MfRxYyxs9Eo/BLEWW4558/rJHYCfFP6HtAc6qgA5WWjFXKgfFIXzIddMsMB4nfZNJm1Dg==";

  static final String PRIVATE_KEY_B64DER =
      "MIGTAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBHkwdwIBAQQgYHO5yuLp0GroKNQjoy20CPraYd7Fn155nBVXoR3PXoKgCgYIKoZIzj0DAQehRANCAAQLx+De0BDz3sYfpWPkx9HFjLGz0Sj8EsRZbjnnz+skdgJ8U/oe0BzqqADlZaMVcqB8UhfMh10ywwHid9k0mbUO";

  static final String PUBLIC_KEY_PEM =
      "-----BEGIN PUBLIC KEY-----\n"
          + "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEC8fg3tAQ897GH6Vj5MfRxYyxs9Eo\n"
          + "/BLEWW4558/rJHYCfFP6HtAc6qgA5WWjFXKgfFIXzIddMsMB4nfZNJm1Dg==\n"
          + "-----END PUBLIC KEY-----";

  static final String PRIVATE_KEY_PEM =
      "-----BEGIN PRIVATE KEY-----\n"
          + "MIGTAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBHkwdwIBAQQgYHO5yuLp0GroKNQj\n"
          + "oy20CPraYd7Fn155nBVXoR3PXoKgCgYIKoZIzj0DAQehRANCAAQLx+De0BDz3sYf\n"
          + "pWPkx9HFjLGz0Sj8EsRZbjnnz+skdgJ8U/oe0BzqqADlZaMVcqB8UhfMh10ywwHi\n"
          + "d9k0mbUO\n"
          + "-----END PRIVATE KEY-----";

  @Test
  void testEncodeWithPublicKeyDer() throws Exception {
    final PublicKey actual =
        EcKeyFactory.createPublicKey(Base64.getDecoder().decode(PUBLIC_KEY_B64DER));
    assertEquals(ALGORITHM_ECDSA, actual.getAlgorithm());
    assertEquals("X.509", actual.getFormat());
    assertArrayEquals(Base64.getDecoder().decode(PUBLIC_KEY_B64DER), actual.getEncoded());
  }

  @Test
  void testEncodeWithPublicKeyPEM() throws Exception {
    final PublicKey actual = EcKeyFactory.createPublicKey(PUBLIC_KEY_PEM);
    assertEquals(ALGORITHM_ECDSA, actual.getAlgorithm());
    assertEquals("X.509", actual.getFormat());
    assertArrayEquals(Base64.getDecoder().decode(PUBLIC_KEY_B64DER), actual.getEncoded());
  }

  @Test
  void testEncodeWithPrivateKeyDer() throws Exception {
    final PrivateKey actual =
        EcKeyFactory.createPrivateKey(Base64.getDecoder().decode(PRIVATE_KEY_B64DER));
    assertEquals(ALGORITHM_ECDSA, actual.getAlgorithm());
    assertEquals("PKCS#8", actual.getFormat());
    assertArrayEquals(Base64.getDecoder().decode(PRIVATE_KEY_B64DER), actual.getEncoded());
  }

  @Test
  void testEncodeWithPrivateKeyPem() throws Exception {
    final PrivateKey actual = EcKeyFactory.createPrivateKey(PRIVATE_KEY_PEM);
    assertEquals(ALGORITHM_ECDSA, actual.getAlgorithm());
    assertEquals("PKCS#8", actual.getFormat());
    assertArrayEquals(Base64.getDecoder().decode(PRIVATE_KEY_B64DER), actual.getEncoded());
  }
}
