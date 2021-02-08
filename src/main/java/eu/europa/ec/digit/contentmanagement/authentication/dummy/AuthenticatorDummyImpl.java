package eu.europa.ec.digit.contentmanagement.authentication.dummy;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import eu.europa.ec.digit.contentmanagement.authentication.AbstractAuthenticatorModule;
import eu.europa.ec.digit.contentmanagement.authentication.Credentials_i;
import eu.europa.ec.digit.contentmanagement.domain.api.entities.user.Privilege_i;
import eu.europa.ec.digit.contentmanagement.domain.api.entities.user.User_i;

/**
 * 
 * @author bentsth
 */
public class AuthenticatorDummyImpl extends AbstractAuthenticatorModule{
    
    private static final Logger logger = Logger.getLogger(AuthenticatorDummyImpl.class);
    
    private AtomicInteger cntUser = new AtomicInteger();
    private Random random = new Random();
    
    
    @Override
    protected void initSub() throws Exception {
        
    }
    
    @Override
    protected void closeSub() throws Exception {
        
    }

    @Override
    public User_i authenticate(Credentials_i credentials) {
        if (logger.isDebugEnabled())
            logger.debug("Authenticating: " + credentials);

        int id = cntUser.incrementAndGet();
        return new User_i() {
            
            @Override
            public String getUuid() {
                return random.nextLong() + "";
            }
            
            
            @Override
            public long getId() {
                return id;
            }
            
            
            @Override
            public void setName(String username) {
                
            }
            
            
            @Override
            public String getName() {
                return "username_" + id;
            }


            @Override
            public List<Privilege_i> getPrivileges(Object id) {
                return null;
            }


            @Override
            public void addPrivilege(Privilege_i privilege, Object id) {
            }


            @Override
            public void removePrivilege(Privilege_i privilege, Object id) {
            }
        };
    }

    @Override
    public void close() {
    }

}
