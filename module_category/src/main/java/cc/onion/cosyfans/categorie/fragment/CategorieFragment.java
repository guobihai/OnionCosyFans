package cc.onion.cosyfans.categorie.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import cc.onion.cosyfans.base.BaseFragment;
import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.exception.ExceptionCode;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.ScreenUtils;
import cc.onion.cosyfans.base.utils.StatusBarUtils;
import cc.onion.cosyfans.base.utils.SystemUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.view.loadView.ILoadVew;
import cc.onion.cosyfans.base.view.loadView.ULoadView;
import cc.onion.cosyfans.categorie.BR;
import cc.onion.cosyfans.categorie.R;
import cc.onion.cosyfans.categorie.adapter.CategorieLeftListAdapter;
import cc.onion.cosyfans.categorie.adapter.CategorieRightListAdapter;
import cc.onion.cosyfans.categorie.databinding.CategorieFrgmHomeBinding;
import cc.onion.cosyfans.categorie.entity.responer.CategorieEntity;
import cc.onion.cosyfans.categorie.viewModel.CategorieViewModel;
import io.reactivex.disposables.Disposable;

/**
 * 分类模块界面
 *
 * @author anhuifxi
 * @created 2019/11/06
 */
@Route(path = RouterPath.Categorie.ROUTE_CATEGORRIE_PATH)
public class CategorieFragment extends BaseFragment<CategorieFrgmHomeBinding, CategorieViewModel> {

    public static CategorieFragment newInstance() {
        Bundle args = new Bundle();

        CategorieFragment fragment = new CategorieFragment();
        fragment.setArguments(args);
        return fragment;
    }



    //left
    CategorieLeftListAdapter categorieLeftListAdapter;
    //right
    CategorieRightListAdapter categorieRightListAdapter;
    private ILoadVew loadVew;

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.categorie_frgm_home;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }


    @Override
    public void initData() {
        super.initData();

        initStatusBar();
        initRecyclerView();
        loadData();
    }

    private void loadData() {
        loadVew = new ULoadView(mBinding.body);
        loadVew.showLoading();
        BaseRequestBean baseRequestBean = new BaseRequestBean();
        baseRequestBean.setRequestSign(baseRequestBean.getKeyMap());
                mViewModel.getCatetorieData(baseRequestBean, new ResponseListener<CategorieEntity>() {
                    @Override
                    public void loadSuccess(CategorieEntity data) {
                        KLog.i("test","加载分类数据成功:");
                        try {
                            loadVew.hide();

                        if(data.getData() != null && data.getData().size()>0){
                            //一级数据
                            List<CategorieEntity.DataBean> oneCategorieList = data.getData();
                            categorieLeftListAdapter.setNewData(oneCategorieList);
                            categorieLeftListAdapter.notifyDataSetChanged();
                            //二级数据展示
                            List<CategorieEntity.DataBean.ChildNodesBeanX> childNodesBeans = oneCategorieList.get(0).getChildNodes();
                            categorieRightListAdapter.setNewData(childNodesBeans);
                            categorieRightListAdapter.notifyDataSetChanged();
                        }

                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void loadFailed(String errorCode, String errorMsg) {
                        if (errorCode.equals(ExceptionCode.NO_NERWORK_ERROR)) {
                            loadVew.showNetworkError(v -> {
                                // 无网络
                                loadVew.showLoading();
                                loadData();
                            });
                        } else {
                            loadVew.showError("数据加载失败：" + errorCode + "\n" + errorMsg, v -> {
                                loadVew.showLoading();
                                loadData();
                            });
                        }
                    }

                    @Override
                    public void addDisposable(Disposable disposable) {
                        addSubscription(disposable);
                    }
                });
    }

    private void initRecyclerView() {


        categorieLeftListAdapter  = new CategorieLeftListAdapter(null,getActivity());
        //分组数据
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), 1, false);
        mBinding.rlCateLeftList.setLayoutManager(linearLayoutManager);
        mBinding.rlCateLeftList.setAdapter(categorieLeftListAdapter);
        categorieLeftListAdapter.setOnItemClickListener((adapter, view, position) -> {
            try {
            categorieLeftListAdapter.setCurrentPosition(position);
            categorieLeftListAdapter.notifyDataSetChanged();
            setRightDataViewShow(adapter, view, position);//设置右边数据刷新
            KLog.i("test","刷新的数据："+position);

            }catch (Exception e){
                e.printStackTrace();
            }
        });



        categorieRightListAdapter = new CategorieRightListAdapter(null,getActivity());
        //Right Adapter
        LinearLayoutManager linearLayoutManagerRight = new LinearLayoutManager(getActivity(), 1, false);
        mBinding.rlCateRightGrid.setLayoutManager(linearLayoutManagerRight);
        mBinding.rlCateRightGrid.setAdapter(categorieRightListAdapter);
        categorieRightListAdapter.setOnItemClickListener((adapter, view, position) -> {
            try {

            categorieRightListAdapter.setCurrentPosition(position);
            categorieRightListAdapter.notifyDataSetChanged();

            }catch (Exception e){
                e.printStackTrace();
            }


        });

    }

    //设置右边数据刷新
    private void setRightDataViewShow(BaseQuickAdapter adapter, View view, int position) {
        CategorieEntity.DataBean    model  = (CategorieEntity.DataBean) adapter.getItem(position);
        if(model.getChildNodes() != null && model.getChildNodes().size() >0){
            //重新刷新数据
            categorieRightListAdapter.setNewData(model.getChildNodes());
            categorieRightListAdapter.notifyDataSetChanged();
        }else{
            ToastUtil.Short("noe");
        }

    }

    /**
     * 初始化状态栏背景颜色
     */
    private void initStatusBar() {
        // 把状态栏的位置顶出来
        mBinding.contactsStatusBarCompat.getLayoutParams().height = ScreenUtils.getSystemBarHeight();
        if (SystemUtils.v19()) {
            mBinding.contactsStatusBarCompat.setVisibility(View.VISIBLE);
            mBinding.contactsStatusBarCompat.setAlpha(0);
        } else {
            mBinding.contactsStatusBarCompat.setVisibility(View.GONE);
        }
        if (StatusBarUtils.setMiuiStatusBarDarkMode(getActivity(), true) ||
                StatusBarUtils.setMeizuStatusBarDarkIcon(getActivity(), true)) {
            mBinding.contactsStatusBarCompat.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
        }



    }
}
