package com.fengzhuo.tudou.ms.controllerTest;

import com.fengzhuo.tudou.ms.test.BaseTest;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by hsq 11:16 2018/1/23
 */
public class MessageControllerTest extends BaseTest {

    @Test
    public void sendMsg() throws Exception{
        MockHttpServletRequestBuilder request = get("/sendMessage")
                .param("msg","hello activeMq3");
        MvcResult result = mockMvc.perform(request).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void acceptMsg() throws Exception{
        MockHttpServletRequestBuilder request = get("/receiveMessage");
        MvcResult result = mockMvc.perform(request).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

}
