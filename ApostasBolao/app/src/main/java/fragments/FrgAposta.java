package fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.home.apostasjl.R;
import com.home.apostasjl.enuns.EnuPalpite;
import com.home.apostasjl.interf.MVP;
import com.home.apostasjl.model.Cartela;
import com.home.apostasjl.model.Jogo;
import com.home.apostasjl.model.Palpite;
import com.home.apostasjl.model.Rodada;
import com.home.apostasjl.model.Time;
import com.home.apostasjl.suporte.DataUtils;
import com.home.apostasjl.suporte.Util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FrgAposta.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FrgAposta#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FrgAposta extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Cartela cartela;
    private TextView totalPalpites;

    View view;

    private MVP.PresenterImpl presenter;

    private OnFragmentInteractionListener mListener;



    public FrgAposta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FrgAposta.
     */
    // TODO: Rename and change types and number of parameters
    public static FrgAposta newInstance(String param1, String param2) {
        FrgAposta fragment = new FrgAposta();
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

        View view = inflater.inflate(R.layout.frg_aposta, container, false);

        this.view = view;

        preencherCartela();

        return view;
    }






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

    @SuppressLint("ValidFragment")
    public FrgAposta(MVP.PresenterImpl presenter){

        this.presenter = presenter;

    }


    public void apostar(){
        boolean condicao=true;

        for(Palpite palpite : cartela.getPalpites()){

            if(palpite==null){
                condicao = false;
                break;
            }
        }

        if(condicao){

            Toast.makeText(view.getContext(), "Aposta enviada com sucesso!!!", Toast.LENGTH_LONG).show();

        }else {

            Toast.makeText(view.getContext(), "Por favor, preencha todos os jogos", Toast.LENGTH_LONG).show();

        }


    }


    @SuppressLint({"NewApi", "ClickableViewAccessibility"})
    public void preencherCartela() {
        int estiloTimes = R.style.TextAppearance_AppCompat_Body2;

        //Ele vai pegar do webservice
        cartela = new Cartela();


        totalPalpites = view.findViewById(R.id.txt_total_palpites_cartela);

        Button btnEnviarAposta = view.findViewById(R.id.btn_enviar_jogo);

        btnEnviarAposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apostar();
            }
        });

        btnEnviarAposta.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        Button btnView = (Button) view;
                        view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP:
                        // Your action here on button click
                    case MotionEvent.ACTION_CANCEL: {
                        Button btnView = (Button) view;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                }
                return false;
            }
        });

        TableLayout tabela = view.findViewById(R.id.tbl_aposta);

        tabela.setStretchAllColumns(true);
        Rodada rodada = new Rodada();
        rodada.setId(1);
        rodada.setEncerrada(false);

        rodada.setLstJogos(Util.preencherJogos());

        for(final Jogo jogo: rodada.getLstJogos()) {
            TableRow linhaJogo = null;
            TextView txtRivais;
            TextView txtData;
            LinearLayout linearLayout;

            for (Map.Entry<Time, Time> rival : jogo.getJogadas().entrySet()) {

                linhaJogo = new TableRow(view.getContext());
                linhaJogo.setBackgroundColor(getResources().getColor(R.color.gramado));

                linearLayout = new LinearLayout(view.getContext());

                linearLayout.setOrientation(LinearLayout.VERTICAL);

                txtRivais = new TextView(view.getContext());

                txtData = new TextView(view.getContext());
                txtData.setPadding(3,3,3,3);

                txtRivais.setText(rival.getKey().getNome() + " X " + rival.getValue().getNome());

                txtRivais.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                txtRivais.setPadding(3,3,3,3);
                txtRivais.setTextAppearance(estiloTimes);

                txtRivais.setTextColor(getResources().getColor(R.color.colorLinha));

                txtData.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                txtData.setText(" Data: "+ DataUtils.converterData(jogo.getData()));
                txtData.setTextAppearance(estiloTimes);

                txtData.setTextColor(getResources().getColor(R.color.colorLinha));

                RadioGroup radioGroup = new RadioGroup(view.getContext());
                radioGroup.setOrientation(LinearLayout.HORIZONTAL);

                RadioButton optTimeCasa = new RadioButton(view.getContext());
                optTimeCasa.setId(R.id.time_casa);
                optTimeCasa.setText(EnuPalpite.CASA.getDescricao());
                optTimeCasa.setTextAppearance(R.style.TextAppearance_AppCompat_Caption);
                optTimeCasa.setTextColor(getResources().getColor(R.color.colorLinha));


                RadioButton optEmpate = new RadioButton(view.getContext());
                optEmpate.setId(R.id.empate);
                optEmpate.setText(EnuPalpite.EMPATE.getDescricao());
                optEmpate.setTextAppearance(R.style.TextAppearance_AppCompat_Caption);
                optEmpate.setTextColor(getResources().getColor(R.color.colorLinha));

                RadioButton optTimeFora = new RadioButton(view.getContext());
                optTimeFora.setId(R.id.time_fora);
                optTimeFora.setText(EnuPalpite.FORA.getDescricao());
                optTimeFora.setTextAppearance(R.style.TextAppearance_AppCompat_Caption);
                optTimeFora.setTextColor(getResources().getColor(R.color.colorLinha));


                radioGroup.addView(optTimeCasa);

                radioGroup.addView(optEmpate);

                radioGroup.addView(optTimeFora);

                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {

                        Palpite novoPalpite = null;

                        switch (i) {
                            case R.id.time_casa:
                                Toast.makeText(view.getContext(), "Foi Selecionada a opção Casa", Toast.LENGTH_SHORT).show();

                                novoPalpite = new Palpite(EnuPalpite.CASA);

                                break;
                            case R.id.empate:

                                Toast.makeText(view.getContext(), "Foi Selecionada a opção Empate", Toast.LENGTH_SHORT).show();

                                novoPalpite = new Palpite(EnuPalpite.EMPATE);
                                break;
                            case R.id.time_fora:
                                Toast.makeText(view.getContext(), "Foi Selecionada a opção Fora", Toast.LENGTH_SHORT).show();
                                novoPalpite = new Palpite(EnuPalpite.FORA);
                                break;
                        }

                        cartela.getPalpites()[jogo.getId()] = novoPalpite;
                        totalPalpites.setText("TOTAL: "+atualizarTotal());

                    }
                });

                linearLayout.addView(txtRivais);

                linearLayout.addView(txtData);

                linearLayout.addView(radioGroup);

                linhaJogo.addView(linearLayout);

            }

            View separadorLinha = new View(view.getContext());
            separadorLinha.setMinimumHeight(8);
            separadorLinha.setBackgroundColor(getResources().getColor(R.color.separadorLinha));

            tabela.addView(separadorLinha);

            tabela.addView(linhaJogo);
        }

        View separadorTabela = new View(view.getContext());
        separadorTabela.setMinimumHeight(8);
        separadorTabela.setBackgroundColor(getResources().getColor(R.color.separadorLinha));



        tabela.addView(separadorTabela);

    }

    private String atualizarTotal(){
        Integer contador=0;

        for(Palpite palpite : cartela.getPalpites()){

            if(palpite!=null){

                contador++;
            }
        }

        return contador.toString();
    }

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
