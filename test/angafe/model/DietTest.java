package angafe.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DietTest extends AppEngineTestCase {

    private Diet model = new Diet();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
