package angafe.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SpecialNeedTest extends AppEngineTestCase {

    private SpecialNeed model = new SpecialNeed();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
