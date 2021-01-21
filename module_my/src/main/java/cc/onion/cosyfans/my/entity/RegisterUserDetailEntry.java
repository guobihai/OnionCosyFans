package cc.onion.cosyfans.my.entity;

import android.text.TextUtils;

import java.util.List;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.entity
 * @ClassName: RegisterUserDetailEntry
 * @Description: java类作用描述
 * @Author: 唐朝
 * @CreateDate: 2020/1/17 10:16
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/17 10:16
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class RegisterUserDetailEntry {

    /**
     * status : 200
     * msg :
     * data : [{"userIdxCode":47927,"userName":"hwq","cellPhone":"15918855375","createTime":"2019-11-19","level":"Cosy Friend","registerJoint":"hwq(15918855375)"}]
     * pageNum : 1
     * totalPages : 1
     * pageSize : 5
     * totalCounts : 1
     * hasNextPage : false
     * hasPrePage : false
     * nextPage : 1
     * prePage : 1
     * startTime : null
     * endTime : null
     * firstPage : true
     * lastPage : true
     */

    private int status;
    private String msg;
    private int pageNum;
    private int totalPages;
    private int pageSize;
    private int totalCounts;
    private boolean hasNextPage;
    private boolean hasPrePage;
    private int nextPage;
    private int prePage;
    private Object startTime;
    private Object endTime;
    private boolean firstPage;
    private boolean lastPage;
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

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public boolean isHasPrePage() {
        return hasPrePage;
    }

    public void setHasPrePage(boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public Object getStartTime() {
        return startTime;
    }

    public void setStartTime(Object startTime) {
        this.startTime = startTime;
    }

    public Object getEndTime() {
        return endTime;
    }

    public void setEndTime(Object endTime) {
        this.endTime = endTime;
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * userIdxCode : 47927
         * userName : hwq
         * cellPhone : 15918855375
         * createTime : 2019-11-19
         * level : Cosy Friend
         * registerJoint : hwq(15918855375)
         */

        private int userIdxCode;
        private String userName;
        private String cellPhone;
        private String createTime;
        private String level;
        private String registerJoint;

        public int getUserIdxCode() {
            return userIdxCode;
        }

        public void setUserIdxCode(int userIdxCode) {
            this.userIdxCode = userIdxCode;
        }

        public String getUserName() {
            return TextUtils.isEmpty(userName)?"":userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getCellPhone() {
            return TextUtils.isEmpty(cellPhone)?"":cellPhone;
        }

        public void setCellPhone(String cellPhone) {
            this.cellPhone = cellPhone;
        }

        public String getCreateTime() {
            return TextUtils.isEmpty(createTime)?"":createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getLevel() {
            return TextUtils.isEmpty(level)?"":level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getRegisterJoint() {
            return TextUtils.isEmpty(registerJoint)?"":registerJoint;
        }

        public void setRegisterJoint(String registerJoint) {
            this.registerJoint = registerJoint;
        }
    }
}
