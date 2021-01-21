package cc.onion.cosyfans.module_search;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import cc.onion.cosyfans.base.BaseActivity;
import cc.onion.cosyfans.base.entity.SearchHouseData;
import cc.onion.cosyfans.base.entity.SearchItemData;
import cc.onion.cosyfans.base.event.Event;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.EventBusUtil;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.SoftKeyBoardUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.base.view.LabelsView;
import cc.onion.cosyfans.base.view.loadView.ILoadVew;
import cc.onion.cosyfans.base.view.loadView.ULoadView;
import cc.onion.cosyfans.base.viewmodel.SearchBaseViewModel;
import cc.onion.cosyfans.module_search.Envent.HoristerEnvent;
import cc.onion.cosyfans.module_search.adapter.HotWordAdapter;
import cc.onion.cosyfans.module_search.databinding.SearchListBinding;
import cc.onion.cosyfans.module_search.entity.HotRequest;
import cc.onion.cosyfans.module_search.entity.SearchHotWordEntity;
import cc.onion.cosyfans.module_search.viewModel.SearchViewModel;
import cc.onion.cosyfans.module_search.weight.HotWordLabelsView;
import io.reactivex.disposables.Disposable;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_search
 * @ClassName: SerarchItemListActivity
 * @Description: 项目搜索模块
 * @Author: guobihai
 * @CreateDate: 2020-01-01 15:52
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-01 15:52
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Route(path = RouterPath.Search.ROUTE_SEARCH_HOME)
public class SerarchItemListActivity extends BaseActivity<SearchListBinding, SearchViewModel>implements SearchBaseViewModel.LabelSearchListener<SearchHouseData> {



    private ILoadVew loadView;
    HotWordAdapter hotWordAdapter = null;


    /**
     * 热词搜素
     */
    List<SearchHotWordEntity.DataBean> searchDataList;
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.search_list;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void onLabelClick(LabelsView.Label label) {
        if(StringUtils.isNotEmpty(label.name)){
            mViewModel.searchText.set(label.name);
            mViewModel.showDelete.set(true);
            EventBusUtil.sendEvent(new Event(HoristerEnvent.SAVE_DATA));
        }

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void initData() {
        super.initData();
        // 避免过度绘制
        getWindow().setBackgroundDrawable(null);
        mBinding.history.setVisibility(View.VISIBLE);

        mBinding.setViewModel(mViewModel);
        mBinding.setBaseViewModel(mViewModel);
        mViewModel.setLabelSearchListener(this);
        mViewModel.showHistory.set(true);
        initWithUI();
        mBinding.imgLeft.setOnClickListener(v -> finish());
        initRootView();

    }

    private void initRootView() {
        mBinding.getRoot().setOnClickListener(v -> {
            SoftKeyBoardUtils.closeKeyBoard(this);
        });


        mBinding.etSearch.setOnFocusChangeListener((v, hasFocus) -> {
           if(StringUtils.isNotEmpty(mBinding.etSearch.getText())){
               mViewModel.showDelete.set(true);
           }else{
               mViewModel.showDelete.set(false);
           }

        });


    }


    private void initWithUI() {

        loadView = new ULoadView(mBinding.body);

        mViewModel.setSearchClass(SearchHouseData.class);

        mViewModel.initSearchView(this,findViewById(R.id.labels),null);


        loadView.showLoading();




        loadData();
        initSearchBar();

    }


    /**
     * 初始化搜索
     */
    private void initSearchBar() {
        mBinding.etSearch.setHint(getString(R.string.search));
        mBinding.etSearch.setOnEditorActionListener((v,actionId,event)-> {
            // onEditorAction
            if (actionId == EditorInfo.IME_ACTION_SEARCH || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_SEARCH)) {

                search(false);
                return true;
            }

            return false;
        });


    }

    private void search(boolean isLabel) {
        SoftKeyBoardUtils.closeKeyBoard(this);
        String searchText = mBinding.etSearch.getText().toString();


        // 写入数据库
        if (!isLabel) mViewModel.setLitePalData(new SearchHouseData(searchText, TypeUtils.toLong(new Date()).toString()));
        mViewModel.isShowlables.set(true);
        mViewModel.isShowNodata.set(false);
        //显示布局
        mViewModel.initSomeMoreLabels();
        mViewModel.displaySomeLabels();

    }



    /**
     * 初始化流式布局
     * @param data
     */
    private void initFlowLayout(List<SearchHotWordEntity.DataBean> data) {
        //设置多选数量
        mBinding.labelsHotWord.setCanSelected(true);
        mBinding.labelsHotWord.setMultiSelected(false);
        mBinding.labelsHotWord.setLabelClickListener(new HotWordLabelsView.OnLabelClickListener() {
            @Override
            public void onLabelClick(HotWordLabelsView.Label label) {
                if(StringUtils.isNotEmpty(label.name)){
                    //点击
                    EventBusUtil.sendEvent(new Event(HoristerEnvent.SAVE_DATA));
                    if(StringUtils.isNotEmpty(label.name)){
                        mViewModel.searchText.set(label.name);
                        mViewModel.showDelete.set(true);
                    }else{
                        mViewModel.showDelete.set(false);
                    }

                }

            }

            @Override
            public void onLongClick(HotWordLabelsView.Label label, String str) {
                //长按
//                ToastUtil.Short("删除" + label.name + "成功！");
//                LitePal.deleteAll(SearchData.class, "searchStr = ?", label.name);
//                mBinding.labels.getSelectedLabels().remove(label.id);
            }
        });

        List<HotWordLabelsView.Label> hotWordLable = new ArrayList<>();
        for (SearchHotWordEntity.DataBean model :data){
            hotWordLable.add(new HotWordLabelsView.Label(model.getId(),model.getHotWord()));
        }

        mBinding.labelsHotWord.setLabels(hotWordLable);


    }

    private void loadData() {
        HotRequest hotRequest = new HotRequest();
        hotRequest.setApplyTo(SearchType.TYPE_1);
        hotRequest.getKeyMap().put("applyTo", SearchType.TYPE_1);
        hotRequest.setKeyMap(hotRequest.getKeyMap());
        mViewModel.getHotWord(hotRequest, new ResponseListener<SearchHotWordEntity>() {
            @Override
            public void loadSuccess(SearchHotWordEntity data) {
                loadView.hide();
                if(data.getData() != null){
                    if(data.getData() != null && data.getData().size() >0){
                        //初始化布局
                        searchDataList = data.getData();
                        initFlowLayout(data.getData());
                    }
                }

            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                loadView.hide();
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });
    }



    @Override
    protected void receiveEvent(Event event) {
        // 接受到Event后的相关逻辑
        switch (event.getCode()) {
            case HoristerEnvent.SAVE_DATA:
                KLog.i("test","记录历史数据");
                search(false);

                break;
        }
    }




    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }
}
