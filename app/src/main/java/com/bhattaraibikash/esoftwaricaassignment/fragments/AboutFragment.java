package com.bhattaraibikash.esoftwaricaassignment.fragments;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;

import com.bhattaraibikash.esoftwaricaassignment.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    WebView webViewFrame;
    ProgressBar pbar;

    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        webViewFrame = (WebView) view.findViewById(R.id.webView);
        pbar = (ProgressBar) view.findViewById(R.id.progressBar1);
        webViewFrame.loadUrl("https://softwarica.edu.np/");

        // Enable Javascript
        WebSettings webSettings = webViewFrame.getSettings();
        webSettings.setJavaScriptEnabled(true);
//        webViewFrame.setWebViewClient(new WebViewClient());

        webViewFrame.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap facIcon) {
                pbar.setVisibility(View.VISIBLE);
                webViewFrame.setVisibility(View.GONE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                webViewFrame.setVisibility(View.VISIBLE);
                pbar.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }
}
