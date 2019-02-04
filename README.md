# checkdigit

## Description

This module calculates a check digit.

- Luhn
- Modulus 10, Weight 3:1
- Modulus 11, Weight 2~7
- Damm

## Synopsis

```java
CheckDigitService checkDigit = new Luhn();
checkDigit.calculate("176048"); // => 7
checkDigit.isValid("1760487"); // => true
```

## License

[MIT](/LICENSE)
