package com.pokerforfun.rest.auth;

import com.google.common.base.Optional;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import io.dropwizard.auth.basic.BasicCredentials;

public class DummyAuthenticatorTest {
    private DummyAuthenticator authenticator = new DummyAuthenticator();

    @Test
    public void testEmptyUsername() throws Exception {
        Optional<String> authResult = authenticator.authenticate(new BasicCredentials("", ""));
        Assert.assertFalse(authResult.isPresent());
    }

    @Test
    public void testUsernameEmptyAfterTrim() throws Exception {
        Optional<String> authResult = authenticator.authenticate(new BasicCredentials("     ", ""));
        Assert.assertFalse(authResult.isPresent());
    }

    @Test
    public void testValidUsername() throws Exception {
        String username = "Yan";
        Optional<String> authResult = authenticator.authenticate(new BasicCredentials(username, ""));
        Assert.assertThat(authResult.get(), IsEqual.equalTo(username));
    }
}
