package com.twpracticespring.appws.practiceappws;
import com.twpracticespring.appws.practiceappws.shared.Utils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class UtilsTest {

    @Test
    void utilityShouldProduceRandomString() {
        Utils utility = new Utils();
        String first = utility.getID();
        String second = utility.getID();
        assertNotNull(first);
        assertNotNull(second);
        assertNotEquals(second,first);
    }
}
