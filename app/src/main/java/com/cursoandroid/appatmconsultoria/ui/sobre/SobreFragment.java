package com.cursoandroid.appatmconsultoria.ui.sobre;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cursoandroid.appatmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SobreFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SobreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SobreFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    public SobreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String descricao = "A ATM Consultoria tem como missão apoiar " +
                "organizações que desejam alcançar o sucesso através da" +
                " exelencia da busca pela qualidade";
        // Inflate the layout for this fragment
        return new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)
                .addGroup("Entre em contato")
                .addEmail("atendimento@atmconsultoria.com.br","Envie um email")
                .addWebsite("https://www.google.com/","Acesse nosso site")
                .addGroup("Redes sociais")
                .create();

        //return inflater.inflate(R.layout.fragment_sobre, container, false);

    }
}
