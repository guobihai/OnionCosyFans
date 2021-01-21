package cc.onion.cosyfans.module_trade.entity;

import java.io.Serializable;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_trade.entity
 * @ClassName: PlayRequestEntity
 * @Description: 根据后台获取请求支付数据字典
 * @Author: guobihai
 * @CreateDate: 2019-12-26 11:49
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-26 11:49
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class PlayRequestEntity implements Serializable {

    private static final long serialVersionUID = -2768889076939908934L;


    /**
     * status : 200
     * msg : OK
     * data : {"payResult":{"status":200,"msg":"OK","data":{"country":"MY","merchantCode":"M16384","amount":"33.90","orderNo":"CTMS2019122600001000427","backendURL":"https://cosyfans-api.factorychain2social.cn/transaction/ipay88/paynotify","userContact":"60123456789","userName":"mask123","merchantKey":"qUj1RnO1yz","paymentId":"","userEmail":"13838455438@139.com.net","currency":"MYR","shopId":null,"prodDesc":"CTMS2019122600001000427"}},"isNeedNavigate":0}
     */

    private int status;
    private String msg;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * payResult : {"status":200,"msg":"OK","data":{"country":"MY","merchantCode":"M16384","amount":"33.90","orderNo":"CTMS2019122600001000427","backendURL":"https://cosyfans-api.factorychain2social.cn/transaction/ipay88/paynotify","userContact":"60123456789","userName":"mask123","merchantKey":"qUj1RnO1yz","paymentId":"","userEmail":"13838455438@139.com.net","currency":"MYR","shopId":null,"prodDesc":"CTMS2019122600001000427"}}
         * isNeedNavigate : 0
         */

        private PayResultBean payResult;
        private int isNeedNavigate;

        public PayResultBean getPayResult() {
            return payResult;
        }

        public void setPayResult(PayResultBean payResult) {
            this.payResult = payResult;
        }

        public int getIsNeedNavigate() {
            return isNeedNavigate;
        }

        public void setIsNeedNavigate(int isNeedNavigate) {
            this.isNeedNavigate = isNeedNavigate;
        }

        public static class PayResultBean {
            /**
             * status : 200
             * msg : OK
             * data : {"country":"MY","merchantCode":"M16384","amount":"33.90","orderNo":"CTMS2019122600001000427","backendURL":"https://cosyfans-api.factorychain2social.cn/transaction/ipay88/paynotify","userContact":"60123456789","userName":"mask123","merchantKey":"qUj1RnO1yz","paymentId":"","userEmail":"13838455438@139.com.net","currency":"MYR","shopId":null,"prodDesc":"CTMS2019122600001000427"}
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
                 * country : MY
                 * merchantCode : M16384
                 * amount : 33.90
                 * orderNo : CTMS2019122600001000427
                 * backendURL : https://cosyfans-api.factorychain2social.cn/transaction/ipay88/paynotify
                 * userContact : 60123456789
                 * userName : mask123
                 * merchantKey : qUj1RnO1yz
                 * paymentId :
                 * userEmail : 13838455438@139.com.net
                 * currency : MYR
                 * shopId : null
                 * prodDesc : CTMS2019122600001000427
                 */

                private String country;
                private String merchantCode;
                private String amount;
                private String orderNo;
                private String backendURL;
                private String userContact;
                private String userName;
                private String merchantKey;
                private String paymentId;
                private String userEmail;
                private String currency;
                private Object shopId;
                private String prodDesc;

                public String getCountry() {
                    return country;
                }

                public void setCountry(String country) {
                    this.country = country;
                }

                public String getMerchantCode() {
                    return merchantCode;
                }

                public void setMerchantCode(String merchantCode) {
                    this.merchantCode = merchantCode;
                }

                public String getAmount() {
                    return amount;
                }

                public void setAmount(String amount) {
                    this.amount = amount;
                }

                public String getOrderNo() {
                    return orderNo;
                }

                public void setOrderNo(String orderNo) {
                    this.orderNo = orderNo;
                }

                public String getBackendURL() {
                    return backendURL;
                }

                public void setBackendURL(String backendURL) {
                    this.backendURL = backendURL;
                }

                public String getUserContact() {
                    return userContact;
                }

                public void setUserContact(String userContact) {
                    this.userContact = userContact;
                }

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public String getMerchantKey() {
                    return merchantKey;
                }

                public void setMerchantKey(String merchantKey) {
                    this.merchantKey = merchantKey;
                }

                public String getPaymentId() {
                    return paymentId;
                }

                public void setPaymentId(String paymentId) {
                    this.paymentId = paymentId;
                }

                public String getUserEmail() {
                    return userEmail;
                }

                public void setUserEmail(String userEmail) {
                    this.userEmail = userEmail;
                }

                public String getCurrency() {
                    return currency;
                }

                public void setCurrency(String currency) {
                    this.currency = currency;
                }

                public Object getShopId() {
                    return shopId;
                }

                public void setShopId(Object shopId) {
                    this.shopId = shopId;
                }

                public String getProdDesc() {
                    return prodDesc;
                }

                public void setProdDesc(String prodDesc) {
                    this.prodDesc = prodDesc;
                }
            }
        }
    }
}
