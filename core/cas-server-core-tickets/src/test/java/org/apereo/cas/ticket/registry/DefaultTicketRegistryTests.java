package org.apereo.cas.ticket.registry;

import org.apereo.cas.CipherExecutor;
import org.apereo.cas.config.CasCoreTicketCatalogConfiguration;
import org.apereo.cas.config.CasCoreTicketsConfiguration;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test case to test the DefaultTicketRegistry based on test cases to test all
 * Ticket Registries.
 *
 * @author Scott Battaglia
 * @since 3.0.0
 */
@RunWith(Parameterized.class)
@SpringBootTest(classes = {
    CasCoreTicketsConfiguration.class,
    CasCoreTicketCatalogConfiguration.class
})
public class DefaultTicketRegistryTests extends BaseTicketRegistryTests {

    @Parameterized.Parameters
    public static Collection<Object> getTestParameters() {
        return Arrays.asList(false, true);
    }

    @Override
    public TicketRegistry getNewTicketRegistry() {
        return new DefaultTicketRegistry();
    }

    @Test
    public void verifyOtherConstructor() {
        assertNotNull(new DefaultTicketRegistry(10, 10, 5, CipherExecutor.noOp()));
    }
}
