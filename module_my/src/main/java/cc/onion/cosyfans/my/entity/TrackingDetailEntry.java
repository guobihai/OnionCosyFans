package cc.onion.cosyfans.my.entity;

import android.text.TextUtils;
import android.widget.TextView;

import java.util.List;

/**
 * 物流轨迹信息
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.entity
 * @ClassName: TrackingDetailEntry
 * @Description: java类作用描述
 * @Author: 唐朝
 * @CreateDate: 2020/1/16 11:58
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/16 11:58
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TrackingDetailEntry {

    /**
     * status : 200
     * msg : OK
     * data : {"trackDetailList":[{"date":"2019-05-20 16:45:17","eventCode":"","country":"","reason":"","companyName":"","stationName":"GuangZhou,China","remark":"","reasonCode":"","event":"Ready The Shipment"}],"logisticsNo":"6225659941","logisticsCompany":"COMONE EXPRESS"}
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
         * trackDetailList : [{"date":"2019-05-20 16:45:17","eventCode":"","country":"","reason":"","companyName":"","stationName":"GuangZhou,China","remark":"","reasonCode":"","event":"Ready The Shipment"}]
         * logisticsNo : 6225659941
         * logisticsCompany : COMONE EXPRESS
         */

        private String logisticsNo;
        private String logisticsCompany;
        private List<TrackDetailListBean> trackDetailList;

        public String getLogisticsNo() {
            return TextUtils.isEmpty(logisticsNo)?"":logisticsNo;
        }

        public void setLogisticsNo(String logisticsNo) {
            this.logisticsNo = logisticsNo;
        }

        public String getLogisticsCompany() {
            return TextUtils.isEmpty(logisticsCompany)?"":logisticsCompany;
        }

        public void setLogisticsCompany(String logisticsCompany) {
            this.logisticsCompany = logisticsCompany;
        }

        public List<TrackDetailListBean> getTrackDetailList() {
            return trackDetailList;
        }

        public void setTrackDetailList(List<TrackDetailListBean> trackDetailList) {
            this.trackDetailList = trackDetailList;
        }

        public static class TrackDetailListBean {
            /**
             * date : 2019-05-20 16:45:17
             * eventCode :
             * country :
             * reason :
             * companyName :
             * stationName : GuangZhou,China
             * remark :
             * reasonCode :
             * event : Ready The Shipment
             */

            private String date;
            private String eventCode;
            private String country;
            private String reason;
            private String companyName;
            private String stationName;
            private String remark;
            private String reasonCode;
            private String event;
            private boolean isFirst;//是否是第一条

            public String getDate() {
                return TextUtils.isEmpty(date)?"":date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getEventCode() {
                return eventCode;
            }

            public void setEventCode(String eventCode) {
                this.eventCode = eventCode;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }

            public String getCompanyName() {
                return companyName;
            }

            public void setCompanyName(String companyName) {
                this.companyName = companyName;
            }

            public String getStationName() {
                return TextUtils.isEmpty(stationName)?"":stationName;
            }

            public void setStationName(String stationName) {
                this.stationName = stationName;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getReasonCode() {
                return reasonCode;
            }

            public void setReasonCode(String reasonCode) {
                this.reasonCode = reasonCode;
            }

            public String getEvent() {
                return TextUtils.isEmpty(event)?"":event;
            }

            public void setEvent(String event) {
                this.event = event;
            }

            public boolean isFirst() {
                return isFirst;
            }

            public void setFirst(boolean first) {
                isFirst = first;
            }
        }
    }
}
