package com.github.rising3.ecsign;

import static com.github.rising3.ecsign.EcSignTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class SignerTest {
  MockedStatic<SignUtils> mocked;

  @BeforeEach
  void init() {
    mocked = mockStatic(SignUtils.class, Mockito.CALLS_REAL_METHODS);
    mocked.when(() -> SignUtils.timestamp()).thenReturn(TEST_TIMESTAMP);
  }

  @AfterEach
  void tearDown() {
    mocked.close();
  }

  @ParameterizedTest
  @MethodSource("params")
  void testSign(Param param) throws Exception {
    final Signer signer = new Signer(param.privateKeyPem);
    final SignerResult actual = signer.sign(TEST_MESSAGE, param.hashAlgo);
    assertEquals(TEST_TIMESTAMP, actual.getTimestamp());
    assertNotNull(actual.getSignature());
  }

  static List<Param> params() {
    return Arrays.asList(
        new Param(TEST_PRIVATE_KEY_PEM, "SHA256withECDSA"),
        new Param(TEST_PRIVATE_KEY_PEM_WITH_P384, "SHA384withECDSA"),
        new Param(TEST_PRIVATE_KEY_PEM_WITH_SECP256K1, "SHA256withECDSA"));
  }

  static final class Param {
    public String privateKeyPem;
    public String hashAlgo;

    public Param(String privateKeyPem, String hashAlgo) {
      this.privateKeyPem = privateKeyPem;
      this.hashAlgo = hashAlgo;
    }
  }
}
