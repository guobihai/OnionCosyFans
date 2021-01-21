package cc.onion.cosyfans.home.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author guobihai
 */
public class TbaleItemEntity implements Serializable {

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
