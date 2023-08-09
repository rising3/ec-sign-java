package com.github.rising3.ecsign;

import static com.github.rising3.ecsign.EcSginConstants.*;

import java.security.Key;
import java.security.PrivateKey;
import java.util.Base64;

final class PemEncoder {
  private Key key;

  public PemEncoder(Key key) {
    assert key != null;

    this.key = key;
  }

  public Key getKey() {
    return this.key;
  }

  public String encode() {
    byte[] keyBytes = key.getEncoded();
    String b64Key = Base64.getEncoder().encodeToString(keyBytes);
    StringBuilder pemKey = new StringBuilder();

    if (key instanceof PrivateKey) {
      pemKey.append(BEGIN_PRIVATE_KEY);
      pemKey.append("\n");
      pemKey.append(formatPEMString(b64Key));
      pemKey.append(END_PRIVATE_KEY);
      pemKey.append("\n");
    } else {
      pemKey.append(BEGIN_PUBLIC_KEY);
      pemKey.append("\n");
      pemKey.append(formatPEMString(b64Key));
      pemKey.append(END_PUBLIC_KEY);
      pemKey.append("\n");
    }
    return pemKey.toString();
  }

  private static String formatPEMString(String b64String) {
    assert b64String != null;

    StringBuilder pem = new StringBuilder();
    int lineLength = 64;
    int offset = 0;
    while (offset < b64String.length()) {
      int endIndex = Math.min(offset + lineLength, b64String.length());
      pem.append(b64String, offset, endIndex).append("\n");
      offset = endIndex;
    }
    return pem.toString();
  }
}
