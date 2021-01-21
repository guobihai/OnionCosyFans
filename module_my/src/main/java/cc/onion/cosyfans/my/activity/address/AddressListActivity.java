package cc.onion.cosyfans.my.activity.address;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yanzhenjie.recyclerview.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.SwipeMenuItem;

import java.util.List;

import cc.onion.cosyfans.base.BaseToolBarActivity;
import cc.onion.cosyfans.base.exception.ExceptionCode;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.view.loadView.ULoadView;
import cc.onion.cosyfans.item.entity.SkuBaseEntity;
import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.module_my.databinding.MyAddressListBinding;
import cc.onion.cosyfans.my.adapter.AddressListAdapter;
import cc.onion.cosyfans.my.entity.AddressListEntity;
import cc.onion.cosyfans.my.entity.request.AddressRequest;
import cc.onion.cosyfans.my.viewdModel.AddressListAndroidViewModel;
import io.reactivex.disposables.Disposable;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.activity.address
 * @ClassName: AddressListActivity
 * @Description: 地址列表
 * @Author: guobihai
 * @CreateDate: 2019-12-11 10:53
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-11 10:53
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Route(path = RouterPath.MyCosy.ROUTE_MIME_ADDRESS_LIST)
public class AddressListActivity extends BaseToolBarActivity<MyAddressListBinding, AddressListAndroidViewModel>{


    AddressListAdapter addressListAdapter;

    private ULoadView loadVew;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_address_list);
        setToolbarTitle("收货地址");
        mBinding.setModel(mViewModel);
    }

    @Override
    public void initData() {
        super.initData();
        iniReclycView();
        loadVew = new ULoadView(mBinding.body);
        loadVew.showLoading();
       loadData();
    }





    private void loadData() {
        AddressRequest request = new AddressRequest();
        request.setRequestSign(request.getKeyMap());
        mViewModel.getAddressList(request, new ResponseListener<AddressListEntity>() {
            @Override
            public void loadSuccess(AddressListEntity data) {
                loadVew.hide();
                if(data.getData() != null && data.getData().size() >0){
                    mViewModel.isShow.set(false);
                    addressListAdapter.setNewData(data.getData());
                    addressListAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                if (ExceptionCode.NO_NERWORK_ERROR.equals(errorCode)) {
                    loadVew.showNetworkError(v -> {
                        // 无网络
                        loadVew.showLoading();
                        loadData();
                    });
                } else {
                    loadVew.showError("数据加载失败：" + errorMsg, v -> {
                        loadVew.showLoading();
                        loadData();
                    });
                }
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addDisposable(disposable);
            }
        });
    }

    private void iniReclycView() {
        // 创建菜单：
        SwipeMenuCreator mSwipeMenuCreator = (leftMenu, rightMenu, position) -> {
            SwipeMenuItem deleteItem = new SwipeMenuItem(mContext); // 各种文字和图标属性设置。
            deleteItem.setText("删除");
            deleteItem.setBackgroundColor(getResources().getColor(R.color.orange));
            deleteItem.setTextColor(getResources().getColor(R.color.white));
            deleteItem.setWidth(200);
            deleteItem.setHeight(150);
            rightMenu.addMenuItem(deleteItem); // 在Item左侧添加一个菜单。
        };

        addressListAdapter = new AddressListAdapter(this,null);
        mBinding.rlAddressLsit.setSwipeMenuCreator(mSwipeMenuCreator);
        mBinding.rlAddressLsit.setLayoutManager(new LinearLayoutManager(this,1,false));
        mBinding.rlAddressLsit.setAdapter(addressListAdapter);
        addressListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                AddressListEntity.DataBean model = (AddressListEntity.DataBean) adapter.getItem(position);
                Intent intent = new Intent();
                intent.putExtra("address",model);
                setResult(10000,intent);
                finish();
            }
        });
    }
}
