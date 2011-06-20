package angafe.controller.angafe.product.add;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class LoadControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/angafe/product/add/load");
        LoadController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));
    }
}
