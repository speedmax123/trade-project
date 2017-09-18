package com.speedmax.trade.service;

import com.speedmax.trade.BaseTest;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.core.header.MediaTypes;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JerseyThreadSafeTest extends BaseTest{

}
