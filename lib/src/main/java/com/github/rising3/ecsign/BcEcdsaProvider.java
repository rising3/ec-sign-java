package com.github.rising3.ecsign;

import static com.github.rising3.ecsign.EcSginConstants.*;

import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.Signature;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

final class BcEcdsaProvider {
  private BcEcdsaProvider() {}

  public static KeyPairGenerator getKeyPairGenerator() {
    registerBc();
    try {
      return KeyPairGenerator.getInstance(ALGORITHM_ECDSA, SECURITY_PROVIDER);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static KeyFactory getKeyFactory() {
    registerBc();
    try {
      return KeyFactory.getInstance(ALGORITHM_ECDSA, SECURITY_PROVIDER);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static Signature getSignature(String algo) throws NoSuchAlgorithmException {
    assert algo != null;

    registerBc();
    try {
      return Signature.getInstance(algo, SECURITY_PROVIDER);
    } catch (NoSuchProviderException e) {
      throw new RuntimeException(e);
    }
  }

  private static void registerBc() {
    if (Security.getProvider(SECURITY_PROVIDER) == null) {
      Security.addProvider(new BouncyCastleProvider());
    }
  }
}
