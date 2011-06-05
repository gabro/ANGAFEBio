package angafe.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ProducerTest extends AppEngineTestCase {

    private Producer model = new Producer();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
