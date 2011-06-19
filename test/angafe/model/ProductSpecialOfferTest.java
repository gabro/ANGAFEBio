package angafe.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ProductSpecialOfferTest extends AppEngineTestCase {

    private ProductSpecialOffer model = new ProductSpecialOffer();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
