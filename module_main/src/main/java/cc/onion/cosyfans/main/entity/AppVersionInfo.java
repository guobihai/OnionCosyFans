package cc.onion.cosyfans.main.entity;

import cc.onion.cosyfans.base.appinfo.AppVersion;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.main.entity
 * @ClassName: AppVersion
 * @Description: App版本 Version
 * @Author: guobihai
 * @CreateDate: 2020-01-11 14:38
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-11 14:38
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AppVersionInfo{


    /**
     * status : 200
     * msg : OK
     * data : {"hasVersion":true,"jsVersion":"20191218152619133","versionNo":null,"updateContent":null,"url":null,"updateIndex":null,"forceUpdate":null}
     */

    private int status;
    private String msg;
    private AppVersion data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public AppVersion getData() {
        return data;
    }

    public void setData(AppVersion data) {
        this.data = data;
    }
}
