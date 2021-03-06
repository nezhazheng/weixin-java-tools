package me.chanjar.weixin.bean;

import me.chanjar.weixin.bean.WxXmlOutImageMessage;
import me.chanjar.weixin.bean.WxXmlOutMessage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class WxXmlOutImageMessageTest {

  public void test() {
    WxXmlOutImageMessage m = new WxXmlOutImageMessage();
    m.setMediaId("ddfefesfsdfef");
    m.setCreateTime(1122l);
    m.setFromUserName("from");
    m.setToUserName("to");
    
    String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" 
        + "<xml>"
        + "<ToUserName><![CDATA[to]]></ToUserName>"
        + "<FromUserName><![CDATA[from]]></FromUserName>"
        + "<CreateTime>1122</CreateTime>"
        + "<MsgType><![CDATA[image]]></MsgType>"
        + "<Image><MediaId><![CDATA[ddfefesfsdfef]]></MediaId></Image>"
        + "</xml>";
    System.out.println(m.toXml());
    Assert.assertEquals(m.toXml().replaceAll("\\s", ""), expected.replaceAll("\\s", ""));
  }
  
  public void testBuild() {
    WxXmlOutImageMessage m = WxXmlOutMessage.IMAGE().mediaId("ddfefesfsdfef").fromUser("from").touser("to").build();
    String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" 
        + "<xml>"
        + "<ToUserName><![CDATA[to]]></ToUserName>"
        + "<FromUserName><![CDATA[from]]></FromUserName>"
        + "<CreateTime>1122</CreateTime>"
        + "<MsgType><![CDATA[image]]></MsgType>"
        + "<Image><MediaId><![CDATA[ddfefesfsdfef]]></MediaId></Image>"
        + "</xml>";
    System.out.println(m.toXml());
    Assert.assertEquals(
              m
                .toXml()
                .replaceAll("\\s", "")
                .replaceAll("<CreateTime>.*?</CreateTime>", ""), 
              expected
                .replaceAll("\\s", "")
                .replaceAll("<CreateTime>.*?</CreateTime>", "")
              );
    
  }
}
