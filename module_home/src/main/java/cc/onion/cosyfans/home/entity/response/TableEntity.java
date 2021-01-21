package cc.onion.cosyfans.home.entity.response;

import java.io.Serializable;
import java.util.List;

/**
 * @author guobihai
 * @date  2019 -11-12
 */
public class TableEntity implements Serializable {


    private static final long serialVersionUID = -7827865717168718007L;
    /**
     * status : 200
     * msg : OK
     * data : {"moduleId":15594,"flowTabList":[{"flowTabId":23917,"flowTabName":"test2"},{"flowTabId":24091,"flowTabName":"test1"}]}
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
         * moduleId : 15594
         * flowTabList : [{"flowTabId":23917,"flowTabName":"test2"},{"flowTabId":24091,"flowTabName":"test1"}]
         */

        private int moduleId;
        private List<FlowTabListBean> flowTabList;

        public int getModuleId() {
            return moduleId;
        }

        public void setModuleId(int moduleId) {
            this.moduleId = moduleId;
        }

        public List<FlowTabListBean> getFlowTabList() {
            return flowTabList;
        }

        public void setFlowTabList(List<FlowTabListBean> flowTabList) {
            this.flowTabList = flowTabList;
        }

        public static class FlowTabListBean {
            /**
             * flowTabId : 23917
             * flowTabName : test2
             */

            private int flowTabId;
            private String flowTabName;

            public int getFlowTabId() {
                return flowTabId;
            }

            public void setFlowTabId(int flowTabId) {
                this.flowTabId = flowTabId;
            }

            public String getFlowTabName() {
                return flowTabName;
            }

            public void setFlowTabName(String flowTabName) {
                this.flowTabName = flowTabName;
            }
        }
    }
}
