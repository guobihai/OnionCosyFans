package cc.onion.cosyfans.my.interfaces;

import android.view.View;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.interfaces
 * @ClassName: ItemOnClickInterface
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/15 15:30
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/15 15:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ItemOnClickInterface<T> {
    void onClick(View view, T data,int type);

    void onLongClick(View view, T data,int type);
}
