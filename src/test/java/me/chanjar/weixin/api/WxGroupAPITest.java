package me.chanjar.weixin.api;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import me.chanjar.weixin.bean.WxGroup;
import me.chanjar.weixin.exception.WxErrorException;

import com.google.inject.Inject;

/**
 * 测试分组接口
 * 
 * @author chanjarster
 */
@Test(groups = "groupAPI", dependsOnGroups = "baseAPI")
@Guice(modules = ApiTestModule.class)
public class WxGroupAPITest {

  @Inject
  protected WxServiceImpl wxService;

  protected WxGroup group;
  
  public void testGroupCreate() throws WxErrorException {
    WxGroup res = wxService.groupCreate("测试分组1");
    Assert.assertEquals(res.getName(), "测试分组1");
  }

  @Test(dependsOnMethods="testGroupCreate")
  public void testGroupGet() throws WxErrorException {
    List<WxGroup> groupList = wxService.groupGet();
    Assert.assertNotNull(groupList);
    Assert.assertTrue(groupList.size() > 0);
    for (WxGroup g : groupList) {
      group = g;
      Assert.assertNotNull(g.getName());
    }
  }
  
  @Test(dependsOnMethods={"testGroupGet", "testGroupCreate"})
  public void getGroupUpdate() throws WxErrorException {
    group.setName("分组改名");
    wxService.groupUpdate(group);
  }

}
