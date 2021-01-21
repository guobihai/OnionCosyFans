package cc.onion.cosyfans.item.entity;

import java.io.Serializable;

public class CFCouponDTO implements Serializable {

    private static final long serialVersionUID = 7080621501438309177L;
    /**
     * couponActivityId : 19580
     * couponLabel : 满499减80, 满299减30, 满199减15...
     */

    private int couponActivityId;
    private Object couponLabel;

    public int getCouponActivityId() {
        return couponActivityId;
    }

    public void setCouponActivityId(int couponActivityId) {
        this.couponActivityId = couponActivityId;
    }

    public Object getCouponLabel() {
        return couponLabel;
    }

    public void setCouponLabel(Object couponLabel) {
        this.couponLabel = couponLabel;
    }
}
