package cc.onion.cosyfans.module_trade.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.entity
 * @ClassName: AddressListEntity
 * @Description: 地质类
 * @Author: guobihai
 * @CreateDate: 2019-12-11 15:08
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-11 15:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AddressListEntity implements Serializable {
    private static final long serialVersionUID = 4529515988920750679L;

    /**
     * status : 200
     * msg : OK
     * data : [{"country":"Malaysia","isDefault":true,"consignee":"test","city":"Gombak","address2":"444","address1":"444","postalCode":"60","mobile":"15626165038","id":32601,"state":"Selangor","userId":48441}]
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

    public static class DataBean implements Serializable{
        private static final long serialVersionUID = -5628515841572128211L;
        /**
         * country : Malaysia
         * isDefault : true
         * consignee : test
         * city : Gombak
         * address2 : 444
         * address1 : 444
         * postalCode : 60
         * mobile : 15626165038
         * id : 32601
         * state : Selangor
         * userId : 48441
         */

        private String country;
        private boolean isDefault;
        private String consignee;
        private String city;
        private String address2;
        private String address1;
        private String postalCode;
        private String mobile;
        private int id;
        private String state;
        private int userId;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public boolean isIsDefault() {
            return isDefault;
        }

        public void setIsDefault(boolean isDefault) {
            this.isDefault = isDefault;
        }

        public String getConsignee() {
            return consignee;
        }

        public void setConsignee(String consignee) {
            this.consignee = consignee;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
