package eu.europa.ec.digit.contentmanagement.authentication.dummy;

import static org.junit.Assert.*;

import org.junit.Test;

import eu.europa.ec.digit.contentmanagement.authentication.AuthenticatorModuleFactory;
import eu.europa.ec.digit.contentmanagement.authentication.AuthenticatorModule_i;

/**
 * 
 * @author bentsth
 */
public class TestAuthenticatorModule {

    @Test
    public void test() throws Exception {
        AuthenticatorModule_i auth = AuthenticatorModuleFactory.getModule();
        assertNotNull(auth);
        assertEquals(AuthenticatorDummyImpl.class, auth.getClass());
    }
}
