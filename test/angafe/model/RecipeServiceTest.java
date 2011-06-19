package angafe.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class RecipeServiceTest extends AppEngineTestCase {

    private RecipeService model = new RecipeService();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
