package cc.onion.cosyfans.item.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.item.entity.response.ItemDetailEntity;
import cc.onion.cosyfans.module_item.R;


/**
 * 满折减
 * @author guobihai
 * @email:guobihai@163.com
 *
 */
public class DisscountListAdapter extends BaseQuickAdapter<ItemDetailEntity.DataBean.ItemDetailPromotionLevelDTOBean.CfPromotionLevelDTOSBean, BaseViewHolder> {

    private Context mContext;
    List<ItemDetailEntity.DataBean.ItemDetailPromotionLevelDTOBean.CfPromotionLevelDTOSBean> mDataList;
    private int currentPosition = 0;
    private CloseDialogListener closeDialogListener;

    public DisscountListAdapter(@Nullable FragmentActivity data,
                                List<ItemDetailEntity.DataBean.ItemDetailPromotionLevelDTOBean.CfPromotionLevelDTOSBean> dataList,CloseDialogListener closeDialogListener) {
        super(R.layout.item_disscount_list_item);
        this.mDataList = dataList;
        this.closeDialogListener = closeDialogListener;
    }

    @Override
    protected void convert(BaseViewHolder helper, ItemDetailEntity.DataBean.ItemDetailPromotionLevelDTOBean.CfPromotionLevelDTOSBean item) {
        helper.setText(R.id.tv_disscount_left,item.getPromotionLabel());
        helper.getView(R.id.layout_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //活动列表
                ARouter.getInstance()
                        .build(RouterPath.Cart.ROUTE_CART_PATH_ACTIVITY)
                        .withString("promotionId", TypeUtils.toString(item.getPromotionId()))
                        .navigation();
                closeDialogListener.closeView();
            }
        });



    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }



    public interface   CloseDialogListener{

        void closeView();
    }
}
