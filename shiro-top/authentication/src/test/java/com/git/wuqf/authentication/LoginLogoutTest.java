package com.git.wuqf.authentication;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.hamcrest.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sdzn-dsj on 2016/11/3.
 */
public class LoginLogoutTest {

    @Test
    public void testHelloworld(){
        IniSecurityManagerFactory factory =
                new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager=factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("zhang","123");
        try {
            subject.login(token);
        }
        catch (Exception e  ){
            Assert.assertEquals(true,subject.isAuthenticated());
        }
        subject.logout();
    }
}
