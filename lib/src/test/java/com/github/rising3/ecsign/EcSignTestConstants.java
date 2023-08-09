package com.github.rising3.ecsign;

final class EcSignTestConstants {
  protected static final String TEST_MESSAGE = "hello, message";

  protected static final long TEST_TIMESTAMP = 1688895463045L;

  // P-256/SHA256
  protected static final String TEST_PUBLIC_KEY_PEM =
      "-----BEGIN PUBLIC KEY-----\n"
          + "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEwp4/QyKS/fN5cLFULWtRL5ISmoud\n"
          + "GpOgtgDMZAj8m1bt3kBjrBY1WWDQj8VOAjKTRcGwxiOYdcD5VelU+GJQ5g==\n"
          + "-----END PUBLIC KEY-----";

  protected static final String TEST_PRIVATE_KEY_PEM =
      "-----BEGIN PRIVATE KEY-----\n"
          + "MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQg7zyYxvCg89jDUvbS\n"
          + "u1wkzYRhOUtPFwHnkfY/voD0IB6hRANCAATCnj9DIpL983lwsVQta1EvkhKai50a\n"
          + "k6C2AMxkCPybVu3eQGOsFjVZYNCPxU4CMpNFwbDGI5h1wPlV6VT4YlDm\n"
          + "-----END PRIVATE KEY-----";

  protected static final String TEST_SIGNATURE =
      "MEUCIBQ07TYo91z1xr2iz7ePmqEpBgp1QI92I1zp0fSFAUobAiEAwHVHl9nUFLhQovpiufn8Hc4ZOFeZW3C8heAOmkdls6s=";

  // P-384/SHA384
  protected static final String TEST_PUBLIC_KEY_PEM_WITH_P384 =
      "-----BEGIN PUBLIC KEY-----\n"
          + "MHYwEAYHKoZIzj0CAQYFK4EEACIDYgAEk7n3ELZsD8c4K0B/cUxyFg1mtXrJKs1G\n"
          + "jmZBEzU+w11gcQUEi6oI4fcpGFApLlxK5ZAQnOjWOj1g8XTVeMW9xNBnO0joivQx\n"
          + "B8upCECQ/IgPz0SI8uZhlXLDBRS2CwEg\n"
          + "-----END PUBLIC KEY-----";

  protected static final String TEST_PRIVATE_KEY_PEM_WITH_P384 =
      "-----BEGIN PRIVATE KEY-----\n"
          + "MIG2AgEAMBAGByqGSM49AgEGBSuBBAAiBIGeMIGbAgEBBDCeJKS522euvo1mP3Cm\n"
          + "PBsWgId7SBjcihjG7a3mXYpYc3Mioe4MgiF1Fqm7RcWRXBWhZANiAASTufcQtmwP\n"
          + "xzgrQH9xTHIWDWa1eskqzUaOZkETNT7DXWBxBQSLqgjh9ykYUCkuXErlkBCc6NY6\n"
          + "PWDxdNV4xb3E0Gc7SOiK9DEHy6kIQJD8iA/PRIjy5mGVcsMFFLYLASA=\n"
          + "-----END PRIVATE KEY-----";

  protected static final String TEST_SIGNATURE_WITH_P384 =
      "MGQCMFiTH1LNtexNuLBzqLt8r8k5XByfVOzfwUZBnGr1pBGniMyc1LDjSLaB3YXegsRlFAIwaAgdtBiTlq5onMY5cSWo/F2jGuXeObTUhqsAlW2MRhkuu0vvVjGSKY3lErYqMdLR";

  // secp256k1/SHA256
  protected static final String TEST_PUBLIC_KEY_PEM_WITH_SECP256K1 =
      "-----BEGIN PUBLIC KEY-----\n"
          + "MFYwEAYHKoZIzj0CAQYFK4EEAAoDQgAEm1eVSAq73aR2Oo8L8rvDzBU214+uhgIj\n"
          + "MkiasZgxKDJtMbGosVVCPd8drgkr3NrZ1Eqhrf0mveProOsJdaF5Ag==\n"
          + "-----END PUBLIC KEY-----";

  protected static final String TEST_PRIVATE_KEY_PEM_WITH_SECP256K1 =
      "-----BEGIN PRIVATE KEY-----\n"
          + "MIGEAgEAMBAGByqGSM49AgEGBSuBBAAKBG0wawIBAQQgH4RMksnOnI68DAm0PzqQ\n"
          + "rtS1oznTSsb/pVDQLNPguqShRANCAASbV5VICrvdpHY6jwvyu8PMFTbXj66GAiMy\n"
          + "SJqxmDEoMm0xsaixVUI93x2uCSvc2tnUSqGt/Sa94+ug6wl1oXkC\n"
          + "-----END PRIVATE KEY-----";

  protected static final String TEST_SIGNATURE_WITH_SECP256K1 =
      "MEYCIQCeYobZ2BIoL7jCV4eGYrT/yXGtNLhEFY2MchsIDGCsywIhAMwak6nBiHgJsNfuY2zSdcX235Xy7Ucj2bGMvFh/xdTy";
}
