package com.github.rising3.ecsign;

import static com.github.rising3.ecsign.EcSginConstants.*;

import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public final class SignUtils {

  private SignUtils() {}

  public static KeyPair generateKeyPair() throws InvalidAlgorithmParameterException {
    return generateKeyPair(DEFAULT_NAMED_CURVE);
  }

  public static KeyPair generateKeyPair(String nc) throws InvalidAlgorithmParameterException {
    KeyPairGenerator kpGen = BcEcdsaProvider.getKeyPairGenerator();
    ECGenParameterSpec spec = new ECGenParameterSpec(nc);
    kpGen.initialize(spec);
    return kpGen.generateKeyPair();
  }

  public static String toPem(Key key) {
    return new PemEncoder(key).encode();
  }

  public static PublicKey toPublicKey(String pem) throws InvalidKeySpecException {
    return EcKeyFactory.createPublicKey(pem);
  }

  public static PublicKey toPublicKey(byte[] der) throws InvalidKeySpecException {
    return EcKeyFactory.createPublicKey(der);
  }

  public static PrivateKey toPrivateKey(String pem) throws InvalidKeySpecException {
    return EcKeyFactory.createPrivateKey(pem);
  }

  public static PrivateKey toPrivateKey(byte[] der) throws InvalidKeySpecException {
    return EcKeyFactory.createPrivateKey(der);
  }

  public static long timestamp() {
    return ZonedDateTime.now(ZoneOffset.UTC).toInstant().toEpochMilli();
  }
}
