package cc.onion.cosyfans.module_trade.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_trade.entity
 * @ClassName: CreateOrderEntity
 * @Description: (用一句话描述此类名)
 * @Author: guobihai
 * @CreateDate: 2019-12-13 14:01
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-13 14:01
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class PlayListEntity implements Serializable {
    private static final long serialVersionUID = 1733847271470015016L;


    /**
     * status : 200
     * msg : OK
     * data : [{"name":"IPay88","isNeedNavigate":1,"logo":"https://onion-images-dev.yangsupplychain.com/collect/20181130/20181130105236781_105.jpg","id":1,"code":"IPAY88_MOBILE"}]
     */

    private int status;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name : IPay88
         * isNeedNavigate : 1
         * logo : https://onion-images-dev.yangsupplychain.com/collect/20181130/20181130105236781_105.jpg
         * id : 1
         * code : IPAY88_MOBILE
         */

        private String name;
        private int isNeedNavigate;
        private String logo;
        private int id;
        private String code;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIsNeedNavigate() {
            return isNeedNavigate;
        }

        public void setIsNeedNavigate(int isNeedNavigate) {
            this.isNeedNavigate = isNeedNavigate;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
