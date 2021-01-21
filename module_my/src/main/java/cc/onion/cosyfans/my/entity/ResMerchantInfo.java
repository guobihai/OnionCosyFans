package cc.onion.cosyfans.my.entity;

import android.text.TextUtils;

/**
 * 查询返回店铺信息
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.entity
 * @ClassName: ResMerchantInfo
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/11 17:02
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/11 17:02
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ResMerchantInfo {

    /**
     * status : 200
     * msg : OK
     * data : {"appId":null,"appKey":null,"sign":null,"timestamp":null,"apiv":null,"language":null,"id":29046,"discription":"SSR","name":"15767708601"}
     */

    private int status;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * appId : null
         * appKey : null
         * sign : null
         * timestamp : null
         * apiv : null
         * language : null
         * id : 29046
         * discription : SSR
         * name : 15767708601
         */

        private Object appId;
        private Object appKey;
        private Object sign;
        private Object timestamp;
        private Object apiv;
        private Object language;
        private int id;
        private String discription;
        private String name;

        public Object getAppId() {
            return appId;
        }

        public void setAppId(Object appId) {
            this.appId = appId;
        }

        public Object getAppKey() {
            return appKey;
        }

        public void setAppKey(Object appKey) {
            this.appKey = appKey;
        }

        public Object getSign() {
            return sign;
        }

        public void setSign(Object sign) {
            this.sign = sign;
        }

        public Object getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Object timestamp) {
            this.timestamp = timestamp;
        }

        public Object getApiv() {
            return apiv;
        }

        public void setApiv(Object apiv) {
            this.apiv = apiv;
        }

        public Object getLanguage() {
            return language;
        }

        public void setLanguage(Object language) {
            this.language = language;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDiscription() {
            return TextUtils.isEmpty(discription)?"":discription;
        }

        public void setDiscription(String discription) {
            this.discription = discription;
        }

        public String getName() {
            return TextUtils.isEmpty(name)?"":name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
