package angafe.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SpecialOfferServiceTest extends AppEngineTestCase {

    private SpecialOfferService service = new SpecialOfferService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
