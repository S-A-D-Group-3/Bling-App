package com.systemdict32.blingapp.Fragments;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.systemdict32.blingapp.Fragments.SubCategories.c10_1_CprAdultFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_1_VisualFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_2_VisualFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_3_VisualFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_4_VisualFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c7_1_VisualFragment;
import com.systemdict32.blingapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VisualPageHandlerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VisualPageHandlerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VisualPageHandlerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VisualPageHandlerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VisualPageHandlerFragment newInstance(String param1, String param2) {
        VisualPageHandlerFragment fragment = new VisualPageHandlerFragment();
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

    TypedArray imgs;
    ImageView imageView;
    TextView btn_visual_prev, btn_visual_next, tv_visual_cur_page;
    int pageNum = 0, pageLength;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_visual_page_handler, container, false);

        if(getParentFragment().getClass().equals(c10_1_VisualFragment.class)){
            imgs = getResources().obtainTypedArray(R.array.cpr_adult);
        }
        if(getParentFragment().getClass().equals(c10_2_VisualFragment.class)){
            imgs = getResources().obtainTypedArray(R.array.cpr_child);
        }
        if(getParentFragment().getClass().equals(c10_3_VisualFragment.class)){
            imgs = getResources().obtainTypedArray(R.array.cpr_infant);
        }
        if(getParentFragment().getClass().equals(c10_4_VisualFragment.class)){
            imgs = getResources().obtainTypedArray(R.array.cpr_compression);
        }
        if(getParentFragment().getClass().equals(c7_1_VisualFragment.class)){
            imgs = getResources().obtainTypedArray(R.array.choking_adult);
        }

        tv_visual_cur_page = view.findViewById(R.id.tv_visual_cur_page);
        btn_visual_prev = view.findViewById(R.id.btn_visual_prev);
        btn_visual_next = view.findViewById(R.id.btn_visual_next);
        imageView = view.findViewById(R.id.iv_visual_page);

        pageLength = imgs.length();
        imageView.setBackgroundResource(imgs.getResourceId(pageNum, 1));

        tv_visual_cur_page.setText(String.valueOf(pageNum + 1) + " / " + Integer.toString(pageLength));

        btn_visual_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pageNum < imgs.length() - 1){
                    pageNum++;
                    imageView.setBackgroundResource(imgs.getResourceId(pageNum, 1));
                    tv_visual_cur_page.setText(String.valueOf(pageNum + 1) + " / " + Integer.toString(pageLength));
                }
            }
        });

        btn_visual_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pageNum > 0){
                    pageNum--;
                    imageView.setBackgroundResource(imgs.getResourceId(pageNum, 1));
                    tv_visual_cur_page.setText(String.valueOf(pageNum + 1) + " / " + Integer.toString(pageLength));
                }
            }
        });

        return view;
    }
}