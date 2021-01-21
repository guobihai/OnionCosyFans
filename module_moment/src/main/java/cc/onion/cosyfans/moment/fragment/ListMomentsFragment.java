package cc.onion.cosyfans.moment.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cc.onion.cosyfans.base.BaseFragment;
import cc.onion.cosyfans.module_moment.R;
import cc.onion.cosyfans.module_moment.databinding.MomentFragmentListMomentsBinding;
import cc.onion.cosyfans.module_moment.BR;
import cc.onion.cosyfans.moment.adapter.MomentCenterAdapter;
import cc.onion.cosyfans.moment.entry.CenterInfoEntry;
import cc.onion.cosyfans.viewmodel.CenterViewModel;

import com.google.android.gms.plus.PlusOneButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment with a Google +1 button.
 * Use the {@link ListMomentsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListMomentsFragment extends BaseFragment<MomentFragmentListMomentsBinding, CenterViewModel> {
    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;


    private MomentCenterAdapter MmomentCenterAdapter;
    private List<CenterInfoEntry> centerInfoEntryList;


    public ListMomentsFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ListMomentsFragment newInstance(String param1, String param2) {
        ListMomentsFragment fragment = new ListMomentsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.moment_fragment_list_moments;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        mBinding.setViewModel(mViewModel);

        centerInfoEntryList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            centerInfoEntryList.add(new CenterInfoEntry());
        }

        initView();


    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        MmomentCenterAdapter = new MomentCenterAdapter(centerInfoEntryList);
        MmomentCenterAdapter.setEmptyView(R.layout.moment_nodata_layout,mBinding.smartRefreshLayout);
        mBinding.myOrderRecycleview.setLayoutManager(layoutManager);
        mBinding.myOrderRecycleview.setAdapter(MmomentCenterAdapter);
    }


}
