package angafe.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ProductTest extends AppEngineTestCase {

    private Product model = new Product();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
