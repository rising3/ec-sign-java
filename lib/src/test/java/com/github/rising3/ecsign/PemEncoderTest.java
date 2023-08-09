package com.github.rising3.ecsign;

import static com.github.rising3.ecsign.EcSginConstants.*;
import static org.junit.jupiter.api.Assertions.*;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import org.junit.jupiter.api.Test;

class PemEncoderTest {
  static final String PUBLIC_KEY_B64DER =
      "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEmzxcrqObEK6HWPYozK/3pYw84Ku+rLq8gxHT8d5E3SRp4Sfd1ttfq8mA7C4dDYoyQslrE77vwI1GBYs5UeoemA==";
  static final String PRIVATE_KEY_B64DER =
      "MEECAQAwEwYHKoZIzj0CAQYIKoZIzj0DAQcEJzAlAgEBBCASNB1uJ7z1GxxO7gEyEmG6QBVLOy9CjcLc4LFwzhNkrg==";

  @Test
  void testEncodeWithPublicKeyDer() throws Exception {
    final PublicKey publicKey =
        EcKeyFactory.createPublicKey(Base64.getDecoder().decode(PUBLIC_KEY_B64DER));
    final String actual = new PemEncoder(publicKey).encode();
    assertTrue(actual.matches(REGEX_PUBLIC_PEM));
  }

  @Test
  void testEncodeWithPrivateKeyDer() throws Exception {
    final PrivateKey privateKey =
        EcKeyFactory.createPrivateKey(Base64.getDecoder().decode(PRIVATE_KEY_B64DER));
    final String actual = new PemEncoder(privateKey).encode();
    assertTrue(actual.matches(REGEX_PRIVATE_PEM));
  }
}
