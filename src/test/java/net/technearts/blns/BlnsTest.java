package net.technearts.blns;

import org.junit.jupiter.params.ParameterizedTest;

public class BlnsTest {

    @ParameterizedTest
    @Blns
    public void test(String input) {
        System.out.printf("%s\n", input);
    }
}
