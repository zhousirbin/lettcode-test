package company.code;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrefixTest {

    Prefix prefix = new Prefix();
    @Test
    public void longestCommonPrefix() {

        assertEquals("flo", prefix.longestCommonPrefix(new String[]{"flower", "flow", "floight"}));

    }
}