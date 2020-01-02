package test.template;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import com.byy.api.Application;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.List;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @program: flash-car
 * @description: 单元测试模板
 * @author: Goblin
 * @create: 2019-05-07 15:53
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class template {


  @Test
  public void contextLoads() {
  }

  @Autowired
  private WebApplicationContext wac;

  private MockMvc mockMvc;


  @Before // 在测试开始前初始化工作
  public void setup() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }

  /***
   * 新增方法测试
   * @throws Exception
   */
  @Test
  public void testPost() throws Exception {
    List<String> images = Lists.newArrayList();
    images.add("sadasdasd");
    HashMap<String, Object> map = Maps.newHashMap();
    map.put("orderId", 90);
    map.put("content", "asd111");
    map.put("imgUrls", images);

    MvcResult result = mockMvc.perform(post("/comment/app").
        content(JSONObject.toJSONString(map)).contentType("application/json;charset=utf-8")
    ).andReturn();
    System.out.println(result.getResponse().getContentAsString());
  }

  /**
   * 查询方法测试
   */
  @Test
  public void testGet() throws Exception {
    MvcResult result = mockMvc.perform(
        get("/cash/back/list")
            .contentType("application/json;charset=utf-8")).andReturn();
    System.out.println(result.getResponse().getContentAsString());
  }

  /**
   * 分页条件查询方法测试
   */
  @Test
  public void testList() throws Exception {
    MvcResult result = mockMvc.perform(
        get("/url").param("xxx", "xxx").param("page", "0").param("size", "8")
            .contentType("application/json;charset=utf-8")).andReturn();
    System.out.println(result.getResponse().getContentAsString());
  }

  /**
   * 修改方法测试
   */
  @Test
  public void testPut() throws Exception {
    ImmutableMap<String, String> map = ImmutableMap.of("key1", "value1", "key2", "value2");
    MvcResult result = mockMvc.perform(put("/url").content(JSONObject.toJSONString(map))
        .contentType("application/json;charset=utf-8"))
        .andReturn();
    System.out.println(result.getResponse().getContentAsString());

  }

  /***
   * 删除方法测试
   * @throws Exception
   */
  @Test
  public void testDelete() throws Exception {
    MvcResult result = mockMvc.perform(
        get("/url").param("id", "16")
            .contentType("application/json;charset=utf-8")).andReturn();
    System.out.println(result.getResponse().getContentAsString());
  }


}