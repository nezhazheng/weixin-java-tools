package me.chanjar.weixin.api;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import me.chanjar.weixin.bean.WxCustomMessage;
import me.chanjar.weixin.exception.WxErrorException;

import com.google.inject.Inject;

/***
 * 测试发送客服消息
 * @author chanjarster
 *
 */
@Test(groups="customMessageAPI", dependsOnGroups = "baseAPI")
@Guice(modules = ApiTestModule.class)
public class WxCustomMessageAPITest {

  @Inject
  protected WxServiceImpl wxService;

  public void testSendCustomMessage() throws WxErrorException {
    ApiTestModule.WxXmlConfigStorage configStorage = (ApiTestModule.WxXmlConfigStorage) wxService.wxConfigStorage;
    WxCustomMessage message = new WxCustomMessage();
    message.setMsgtype(WxConsts.CUSTOM_MSG_TEXT);
    message.setTouser(configStorage.getOpenId());
    message.setContent("欢迎欢迎，热烈欢迎\n换行测试\n超链接:<a href=\"http://www.baidu.com\">Hello World</a>");

    wxService.customMessageSend(message);
  }

}
