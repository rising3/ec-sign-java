package com.github.rising3.ecsign;

import static com.github.rising3.ecsign.EcSginConstants.*;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

final class EcKeyFactory {
  private EcKeyFactory() {}

  public static PublicKey createPublicKey(String pem) throws InvalidKeySpecException {
    assert pem != null;

    if (!(pem.matches(REGEX_PUBLIC_PEM))) {
      throw new IllegalArgumentException();
    }
    String b64Pem =
        pem.replace(BEGIN_PUBLIC_KEY, "")
            .replace(END_PUBLIC_KEY, "")
            .replaceAll("\\n|\\r|\\r\\n", "");
    return createPublicKey(Base64.getDecoder().decode(b64Pem));
  }

  public static PublicKey createPublicKey(byte[] keyBytes) throws InvalidKeySpecException {
    KeyFactory keyFactory = BcEcdsaProvider.getKeyFactory();
    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
    return keyFactory.generatePublic(keySpec);
  }

  public static PrivateKey createPrivateKey(String pem) throws InvalidKeySpecException {
    assert pem != null;

    if (!(pem.matches(REGEX_PRIVATE_PEM))) {
      throw new IllegalArgumentException();
    }
    String b64Pem =
        pem.replace(BEGIN_PRIVATE_KEY, "")
            .replace(END_PRIVATE_KEY, "")
            .replaceAll("\\n|\\r|\\r\\n", "");
    return createPrivateKey(Base64.getDecoder().decode(b64Pem));
  }

  public static PrivateKey createPrivateKey(byte[] keyBytes) throws InvalidKeySpecException {
    KeyFactory keyFactory = BcEcdsaProvider.getKeyFactory();
    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
    return keyFactory.generatePrivate(keySpec);
  }
}
