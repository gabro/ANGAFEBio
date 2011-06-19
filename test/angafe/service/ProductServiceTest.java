package angafe.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ProductServiceTest extends AppEngineTestCase {

    private ProductService service = new ProductService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
