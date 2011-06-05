package angafe.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ProductionMethodTest extends AppEngineTestCase {

    private ProductionMethod model = new ProductionMethod();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
