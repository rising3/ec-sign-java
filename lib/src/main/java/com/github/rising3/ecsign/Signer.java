package com.github.rising3.ecsign;

import static com.github.rising3.ecsign.EcSginConstants.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public final class Signer {
  private PrivateKey key;

  public Signer(String privateKeyPem) throws InvalidKeySpecException {
    this(SignUtils.toPrivateKey(privateKeyPem));
  }

  public Signer(PrivateKey privateKey) {
    this.key = privateKey;
  }

  public SignerResult sign(String data)
      throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
    return sign(data, DEFAULT_HASH_ALGO);
  }

  public SignerResult sign(String data, String hashAlgo)
      throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
    Signature signer = BcEcdsaProvider.getSignature(hashAlgo);
    long timestamp = SignUtils.timestamp();
    byte dataBytes[];
    try {
      dataBytes = String.valueOf(timestamp).concat(data).getBytes("UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
    signer.initSign(this.key);
    signer.update(dataBytes);
    byte[] signatureBytes = signer.sign();
    String b64Signature = Base64.getEncoder().encodeToString(signatureBytes);
    return new SignerResult(timestamp, b64Signature);
  }
}
