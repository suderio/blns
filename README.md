# Big List of Naughty Strings

A Java version of [big-list-of-naughty-strings](https://github.com/minimaxir/big-list-of-naughty-strings)

A big (and growing) set of problematic strings, for testing.

## Usage

Add this to your pom.xml:

```xml
<dependencies>
  ...  
  <dependency>
    <groupId>net.technearts</groupId>
    <artifactId>big-list-of-naughty-strings</artifactId>
    <version>1.0.0</version>
  </dependency>
</dependencies>
```
### As a JUnit plugin

This is the intended use. Simply add `@Blns` (and `@ParameterizedTest`) to a Junit test method.

```java
@ParameterizedTest
@Blns
public void test(String blnsString) {
    System.out.printf("%s\n", blnsString);
    // Your test here
}
```

### Using a method provider of a `Stream<String>`

This is an alternative, just the strings in a stream.

```java
BllnsArgumentProvider provider = new BlnsArgumentProvider();
Stream<String> strings = provider.provideStrings();
```