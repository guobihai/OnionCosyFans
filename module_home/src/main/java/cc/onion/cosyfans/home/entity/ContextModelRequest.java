package cc.onion.cosyfans.home.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cc.onion.cosyfans.base.config.AppBaseConfig;
import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.interfaces.BaseRequestListener;
import cc.onion.cosyfans.base.utils.DateFormatUtils;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.MsOnionSecuritySignUtils;
import cc.onion.cosyfans.base.utils.TypeUtils;

/**
 * 内容模块请求Request
 * @author guobihai
 * @eamil:guobihai@163.com
 */
public class ContextModelRequest  extends BaseRequestBean{
    String moduleId;


    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }
}
