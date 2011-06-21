package angafe.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ProductRecipeTest extends AppEngineTestCase {

    private ProductRecipe service = new ProductRecipe();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
