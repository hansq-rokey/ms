package com.fengzhuo.tudou.ms.controllerTest;

import com.fengzhuo.tudou.ms.test.BaseTest;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Created by hanshuaiqi 21:36 2017/11/6
 */
public class ModelScoreControllerTest extends BaseTest{

    @Test
    public void getModelScore() throws Exception{
        MockHttpServletRequestBuilder request = post("/ms/model/score")
                .param("name", "韩帅奇")
                .param("phone","17382342705")
                .param("idNo", "411424198711058812")
                .param("zhimaScore","551.0000")
                .param("borrowTimeScore", "1.0000")
                .param("overDay","0")
                .param("mobileType", "1")
                .param("teamNo", "456")
                .param("blockBox","");
//        request.header("token", "dddd");
//        request.header("signMsg", "dddd");
        MvcResult result = mockMvc.perform(request).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void onLoad() throws Exception{
        MockHttpServletRequestBuilder request = post("/ms/model/onConfig");
        MvcResult result = mockMvc.perform(request).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void updateScore() throws Exception{
        MockHttpServletRequestBuilder request = post("/ms/model/updateScore/submit");
        MvcResult result = mockMvc.perform(request).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void updateScore1() throws Exception{
        MockHttpServletRequestBuilder request = post("/ms/model/updateScore/update")
                .param("logId","74");
        MvcResult result = mockMvc.perform(request).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }
}
