package cc.onion.cosyfans.module_search.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_search.entity
 * @ClassName: SearchHotWordEntity
 * @Description: 热词
 * @Author: guobihai
 * @CreateDate: 2020-01-06 10:39
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-06 10:39
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SearchHotWordEntity implements Serializable {
    private static final long serialVersionUID = -3712134351031640020L;


    /**
     * status : 200
     * msg : OK
     * data : [{"id":13357,"zindex":100,"locale":"cn","hotWord":"洗发水","isPush":1,"remark":""},{"id":13457,"zindex":100,"locale":"cn","hotWord":"包","isPush":1,"remark":""},{"id":12417,"zindex":7,"locale":"cn","hotWord":"Exception","isPush":1,"remark":""},{"id":11286,"zindex":2,"locale":"cn","hotWord":"栗子","isPush":0,"remark":""}]
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
         * id : 13357
         * zindex : 100
         * locale : cn
         * hotWord : 洗发水
         * isPush : 1
         * remark :
         */

        private int id;
        private int zindex;
        private String locale;
        private String hotWord;
        private int isPush;
        private String remark;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getZindex() {
            return zindex;
        }

        public void setZindex(int zindex) {
            this.zindex = zindex;
        }

        public String getLocale() {
            return locale;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }

        public String getHotWord() {
            return hotWord;
        }

        public void setHotWord(String hotWord) {
            this.hotWord = hotWord;
        }

        public int getIsPush() {
            return isPush;
        }

        public void setIsPush(int isPush) {
            this.isPush = isPush;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
