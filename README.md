# checkdigit

[![Build Status](https://travis-ci.org/sgyatto/checkdigit.svg?branch=master)](https://travis-ci.org/sgyatto/checkdigit)

## Description

This module calculates a check digit.

- Luhn(Luhn)
- Modulus 10, Weight 3:1(M10W31)
- Modulus 11, Weight 2~7(M11W27)
- Damm(Damm)

## Synopsis

```java
CheckDigitService checkDigit = new Luhn();
checkDigit.calculate("176048"); // => 7
checkDigit.isValid("1760487"); // => true
```

## License

[MIT](/LICENSE)
