package fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.home.apostasjl.R;
import com.home.apostasjl.interf.MVP;
import com.home.apostasjl.view.ActMainV;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FrgHome.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FrgHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FrgHome extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

//    private HashMap<String, ActMainV.TabInfo> mapTabInfo = new HashMap<String, ActMainV.TabInfo>();
//    private PagerAdapter mPagerAdapter;
//    private int tabAtual=0;


    private MenuInflater menuInflater;
    private Menu menu;

    private View view;

    private MVP.PresenterImpl presenter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FrgHome() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public FrgHome(MVP.PresenterImpl presenter){

        this.presenter = presenter;




    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FrgHome.
     */
    // TODO: Rename and change types and number of parameters
    public static FrgHome newInstance(String param1, String param2) {
        FrgHome fragment = new FrgHome();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.frg_home, container, false);




        return view;
    }

//    private void setupViewPager(ViewPager viewPager) {
//
//        if(presenter!=null) {
//            ViewPagerAdapter adapter = new ViewPagerAdapter(this.getActivity().getSupportFragmentManager(), presenter.getFragmentos());
//            viewPager.setAdapter(adapter);
//        }
//    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }



    }


//    @Override
//    public void onStart() {
//        super.onStart();
//        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
//        setupViewPager(viewPager);
//
//        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(viewPager);
//
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }




}
