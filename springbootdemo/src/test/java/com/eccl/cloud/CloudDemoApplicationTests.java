package com.eccl.cloud;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.eccl.cloud.common.domain.SysUser;
import com.eccl.cloud.demo.CloudDemoApplication;
import com.eccl.cloud.demo.domain.SysUserPos;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CloudDemoApplication.class)
@WebAppConfiguration
public class CloudDemoApplicationTests {
	
	@Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

	private ObjectMapper mapper = new ObjectMapper();
	
	@Before
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

	@Test
    public void testSend() throws Exception {
//		SysUserPos record = new SysUserPos();
//		record.setIsPrimaryPos("是");
//        //调用接口，传入添加的用户参数
//		MvcResult result = mockMvc.perform(post("/userPos")
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(mapper.writeValueAsString(record)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//    	
//    	JsonNode json = mapper.readTree(result.getResponse().getContentAsString());
//    	
//    	Assert.assertEquals(json.path("success").asBoolean(), true);
		
		MvcResult result = mockMvc.perform(get("/hi")).andExpect(status().isOk()).andDo(print()).andReturn();

    }
	

}
