package e2;

import org.junit.jupiter.api.Test;

public class LogicsTest {

    public static final int SIZE = 7;

    @Test
    public void canCreateLogics() {
        final Logics logics = new LogicsImpl(SIZE);
    }

}
