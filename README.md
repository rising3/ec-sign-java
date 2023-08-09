# ec-sign-java
[![Build](https://github.com/rising3/ec-sign-java/actions/workflows/build.yml/badge.svg)](https://github.com/rising3/ec-sign-java/actions/workflows/build.yml)
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](LICENSE)

ECDSA cryptographic signature library for Java.

Elliptic Curve | Hash Algorithm
--- | ---
secp256r1(Default) | SHA256withECDSA(Default)
secp384r1 | SHA384withECDSA
secp256k1 | SHA256withECDSA

## Requirements

* Java 11 or higher

## How to install

ec-sign Maven group ID is com.github.rising3, and its artifact ID is ecsign.

To add a dependency on semver using Maven, use the following:
```xml
<dependency>
  <groupId>com.github.rising3</groupId>
  <artifactId>ecsign</artifactId>
  <version>{version}</version>
</dependency>
```

To add a dependency using Gradle:
```groovy
dependencies {
    implementation("com.github.rising3:ecsign:{version}")
}
```

## How to use library

### Generate keypair

```Java
const keypair = SignUtils.generateKeyPair('secp224r1');
```

### Converts public key to PEM

```Java
String pubPem = SignUtils.toPem(keypair.getPublic());

System.out.println(pubPem);
// -----BEGIN PUBLIC KEY-----
// MFYwEAYHKoZIzj0CAQYFK4EEAAoDQgAEm1eVSAq73aR2Oo8L8rvDzBU214+uhgIj
// MkiasZgxKDJtMbGosVVCPd8drgkr3NrZ1Eqhrf0mveProOsJdaF5Ag==
// -----END PUBLIC KEY-----
```

### Converts private key to PEM

```Java
String priPem = SignUtils.toPem(keypair.getPrivate());

System.out.println(priPem);
// -----BEGIN PRIVATE KEY-----
// MIGEAgEAMBAGByqGSM49AgEGBSuBBAAKBG0wawIBAQQgH4RMksnOnI68DAm0PzqQ
// rtS1oznTSsb/pVDQLNPguqShRANCAASbV5VICrvdpHY6jwvyu8PMFTbXj66GAiMy
// SJqxmDEoMm0xsaixVUI93x2uCSvc2tnUSqGt/Sa94+ug6wl1oXkC
// -----END PRIVATE KEY-----
```

### Sign with data and private key

```Java
Signer signer = new Signer(priPem);
SignerResult result = signer.sign("hello, message");

System.out.println(result.getTimestamp());
// 1688895463045

System.out.println(result.getSignature());
// MEYCIQCeYobZ2BIoL7jCV4eGYrT/yXGtNLhEFY2MchsIDGCsywIhAMwak6nBiHgJsNfuY2zSdcX235Xy7Ucj2bGMvFh/xdTy
```

### Verify signature with data, timestamp and public key

```javascript
Verifier verifier = new Verifier(pubPem);
boolean valid = verifier.verify("hello, message", result.getTimestamp(), result.getSignature());

System.out.println("signature was verified: " + verified);
// signature was verified: true
```

## How to build from source

### prerequisites

Java, git need to be installed.

```sh
git clone https://github.com/rising3/ec-sign-java.git
cd ec-sign-java
./gradlew build
```

## License

[MIT License](LICENSE)
