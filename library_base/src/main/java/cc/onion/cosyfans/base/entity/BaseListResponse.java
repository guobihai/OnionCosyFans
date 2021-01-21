package cc.onion.cosyfans.base.entity;

/**
 * @Author guobihai
 * @Created 2019-05-10
 * @Editor lyy
 * @Edited 2019-05-10
 * @Type
 * @Layout
 * @Api
 */
public class BaseListResponse<T> {
    private String status;
    private String msg;
    private BaseData<T> data;
    private boolean succeed;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BaseData<T> getData() {
        return data;
    }

    public void setData(BaseData<T> data) {
        this.data = data;
    }

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }
}
