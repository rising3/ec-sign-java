package com.github.rising3.ecsign;

import static com.github.rising3.ecsign.EcSginConstants.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public final class Verifier {
  private PublicKey key;

  public Verifier(String publicKeyPem) throws InvalidKeySpecException {
    this(SignUtils.toPublicKey(publicKeyPem));
  }

  public Verifier(PublicKey publicKey) {
    this.key = publicKey;
  }

  public boolean verify(String data, long timestamp, String signature)
      throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
    return verify(data, timestamp, signature, DEFAULT_HASH_ALGO);
  }

  public boolean verify(String data, long timestamp, String signature, String hashAlgo)
      throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
    byte dataBytes[];
    try {
      dataBytes = String.valueOf(timestamp).concat(data).getBytes("UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
    Signature verifier = BcEcdsaProvider.getSignature(hashAlgo);
    verifier.initVerify(key);
    verifier.update(dataBytes);
    return verifier.verify(Base64.getDecoder().decode(signature));
  }
}
