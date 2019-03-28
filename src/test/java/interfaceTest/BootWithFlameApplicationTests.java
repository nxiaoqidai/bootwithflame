package interfaceTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.chenxixiang.bootwithflame.BootWithFlameApplication;
import com.chenxixiang.bootwithflame.dao.pojo.User;
import com.chenxixiang.bootwithflame.redis.InventoryRedisCache;
import com.chenxixiang.bootwithflame.service.interfaces.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { BootWithFlameApplication.class, BootWithFlameApplicationTests.class })
public class BootWithFlameApplicationTests {

	@Autowired
	UserService userService;
	@Autowired
	InventoryRedisCache ircache;
	@Autowired
	WebApplicationContext webappContext;

	private MockMvc mockmvc;

	@Before
	public void setUp() {
		mockmvc = MockMvcBuilders.webAppContextSetup(webappContext).build();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void selectUser() throws Exception {
		User userquery = new User();
		userquery.setName("Beita");
		String content = JSONObject.toJSONString(userquery);
		// List<User> results = userService.selectUser(userquery);
		RequestBuilder request = MockMvcRequestBuilders.get("/user/select").header("StreamNo", "stream001")
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(content).accept(MediaType.APPLICATION_JSON_UTF8);
		ResultActions resultActions = mockmvc.perform(request);
		MvcResult result = resultActions.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print()).andReturn();
		String response = result.getResponse().getContentAsString();
		System.out.println(response);
	}

	@Test
	public void InvenTest() {
		ircache.putIfAbsent("Pantyhose", 2);
		System.out.println(ircache.get("Pantyhose"));
	}
}
