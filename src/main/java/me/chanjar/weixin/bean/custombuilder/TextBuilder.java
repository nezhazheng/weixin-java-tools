package me.chanjar.weixin.bean.custombuilder;

import me.chanjar.weixin.api.WxConsts;
import me.chanjar.weixin.bean.WxCustomMessage;

/**
 * 文本消息builder
 * <pre>
 * 用法: WxCustomMessage m = WxCustomMessage.TEXT().content(...).touser(...).build();
 * </pre>
 * @author chanjarster
 *
 */
public final class TextBuilder extends BaseBuilder<TextBuilder> {
  private String content;

  public TextBuilder() {
    this.msgtype = WxConsts.CUSTOM_MSG_TEXT;
  }

  public TextBuilder content(String content) {
    this.content = content;
    return this;
  }

  public WxCustomMessage build() {
    WxCustomMessage m = super.build();
    m.setContent(this.content);
    return m;
  }
}
