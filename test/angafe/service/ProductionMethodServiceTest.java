package angafe.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ProductionMethodServiceTest extends AppEngineTestCase {

    private ProductionMethodService service = new ProductionMethodService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
