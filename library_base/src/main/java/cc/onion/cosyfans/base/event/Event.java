package cc.onion.cosyfans.base.event;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.base.event
 * @ClassName: Event
 * @Description: eventBus封装
 * @Author: guobihai
 * @CreateDate: 2020-01-10 14:03
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-10 14:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Event<T> {

    private int code;
    private T data;

    public Event(int code) {
        this.code = code;
    }

    public Event(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
