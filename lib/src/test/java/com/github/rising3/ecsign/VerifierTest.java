package com.github.rising3.ecsign;

import static com.github.rising3.ecsign.EcSginConstants.*;
import static com.github.rising3.ecsign.EcSignTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class VerifierTest {

  @ParameterizedTest
  @MethodSource("params")
  void testVerify(Param param) throws Exception {
    Verifier verifier = new Verifier(param.publicKeyPem);
    boolean actual = verifier.verify(param.data, param.timestamp, param.signature, param.hashAlgo);
    assertEquals(param.expected, actual);
  }

  static List<Param> params() {
    return Arrays.asList(
        new Param(
            TEST_PUBLIC_KEY_PEM,
            TEST_MESSAGE,
            TEST_TIMESTAMP,
            TEST_SIGNATURE,
            "SHA256withECDSA",
            true),
        new Param(
            TEST_PUBLIC_KEY_PEM, "Bad", TEST_TIMESTAMP, TEST_SIGNATURE, "SHA256withECDSA", false),
        new Param(TEST_PUBLIC_KEY_PEM, TEST_MESSAGE, 1, TEST_SIGNATURE, "SHA256withECDSA", false),
        new Param(
            TEST_PUBLIC_KEY_PEM_WITH_P384,
            TEST_MESSAGE,
            TEST_TIMESTAMP,
            TEST_SIGNATURE_WITH_P384,
            "SHA384withECDSA",
            true),
        new Param(
            TEST_PUBLIC_KEY_PEM_WITH_P384,
            "Bad",
            TEST_TIMESTAMP,
            TEST_SIGNATURE_WITH_P384,
            "SHA384withECDSA",
            false),
        new Param(
            TEST_PUBLIC_KEY_PEM_WITH_P384,
            TEST_MESSAGE,
            1,
            TEST_SIGNATURE_WITH_P384,
            "SHA384withECDSA",
            false),
        new Param(
            TEST_PUBLIC_KEY_PEM_WITH_SECP256K1,
            TEST_MESSAGE,
            TEST_TIMESTAMP,
            TEST_SIGNATURE_WITH_SECP256K1,
            "SHA256withECDSA",
            true),
        new Param(
            TEST_PUBLIC_KEY_PEM_WITH_SECP256K1,
            "bad",
            TEST_TIMESTAMP,
            TEST_SIGNATURE_WITH_SECP256K1,
            "SHA256withECDSA",
            false),
        new Param(
            TEST_PUBLIC_KEY_PEM_WITH_SECP256K1,
            TEST_MESSAGE,
            1,
            TEST_SIGNATURE_WITH_SECP256K1,
            "SHA256withECDSA",
            false));
  }

  static final class Param {
    public String publicKeyPem;
    public String data;
    public long timestamp;
    public String signature;
    public String hashAlgo;
    public boolean expected;

    public Param(
        String publicKeyPem,
        String data,
        long timestamp,
        String signature,
        String hashAlgo,
        boolean expected) {
      this.publicKeyPem = publicKeyPem;
      this.data = data;
      this.timestamp = timestamp;
      this.signature = signature;
      this.hashAlgo = hashAlgo;
      this.expected = expected;
    }
  }
}
