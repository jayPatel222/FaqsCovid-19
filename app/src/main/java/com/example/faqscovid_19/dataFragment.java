package com.example.faqscovid_19;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class dataFragment extends Fragment {

    View viewLocal;
    TextView countryOrRegion, confirmedCases, deathCases, recoveredCases;
    Button updateData;
    List<CovidData> countryObjects;
    int positionOnSpinner;
    Spinner countrySpinner;
    //ArrayAdapter<CovidData> adapter;
    ArrayAdapter<CharSequence> adapter;
    RequestQueue QUEUE;
    String url;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        url = "https://api.smartable.ai/coronavirus/stats/global?Subscription-Key=1a3e9cd5b22c4a9b86885d5ce7a1ce3d";
        countryObjects = new ArrayList<>();
        Log.e("BEFORE!", "BEFORE!");
        QUEUE = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
        httpGET(url);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewLocal = inflater.inflate(R.layout.fragment_data, container, false);

        countrySpinner = viewLocal.findViewById(R.id.data_spinner);
        updateData = viewLocal.findViewById(R.id.data_button);

        countryOrRegion = viewLocal.findViewById(R.id.data_country_name);
        confirmedCases = viewLocal.findViewById(R.id.data_confirmed);
        deathCases = viewLocal.findViewById(R.id.data_deaths);
        recoveredCases = viewLocal.findViewById(R.id.data_recovered);

        //adapter = new ArrayAdapter<>(viewLocal.getContext(), android.R.layout.simple_spinner_item, countryObjects);
        adapter = ArrayAdapter.createFromResource(viewLocal.getContext(), R.array.data_country_names, R.layout.custom_spinner_items);

        countrySpinner.setAdapter(adapter);

        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionOnSpinner = countrySpinner.getSelectedItemPosition();
                displayCovidData(objectToShow(positionOnSpinner));
            }
        });

        return viewLocal;
    }

    public void httpGET(String url)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                this::parsingData, Throwable::printStackTrace
        );
        QUEUE.add(stringRequest);
    }

    public void parsingData(String jsonText) {
        try {
            String totalCases, newCases, totalDeaths, newDeaths, totalRecovered, newRecovered;

            JSONObject rootObject = new JSONObject(jsonText);
            JSONObject parentList = rootObject.getJSONObject("stats");

            NumberFormat insertComma = NumberFormat.getNumberInstance(Locale.US);

            totalCases = insertComma.format(Integer.valueOf(parentList.getString("totalConfirmedCases")));
            newCases = insertComma.format(Integer.valueOf(parentList.getString("newlyConfirmedCases")));
            totalDeaths = insertComma.format(Integer.valueOf(parentList.getString("totalDeaths")));
            newDeaths = insertComma.format(Integer.valueOf(parentList.getString("newDeaths")));
            totalRecovered = insertComma.format(Integer.valueOf(parentList.getString("totalRecoveredCases")));
            newRecovered = insertComma.format(Integer.valueOf(parentList.getString("newlyRecoveredCases")));

            newCases = "+" + newCases;
            newDeaths = "+" + newDeaths;
            newRecovered = "+" + newRecovered;

            CovidData global = new CovidData("Global Stats", totalCases, newCases, totalDeaths,
                    newDeaths, totalRecovered, newRecovered);

            countryObjects.add(global);

            JSONArray countryArray = parentList.getJSONArray("breakdowns");

            for (int i = 0; i < countryArray.length(); ++i){
                JSONObject countryParent = countryArray.getJSONObject(i);
                JSONObject countryChild = countryParent.getJSONObject("location");
                String countryName = countryChild.getString("countryOrRegion");

                totalCases = insertComma.format(Integer.valueOf(countryParent.getString("totalConfirmedCases")));
                newCases = insertComma.format(Integer.valueOf(countryParent.getString("newlyConfirmedCases")));
                totalDeaths = insertComma.format(Integer.valueOf(countryParent.getString("totalDeaths")));
                newDeaths = insertComma.format(Integer.valueOf(countryParent.getString("newDeaths")));
                totalRecovered = insertComma.format(Integer.valueOf(countryParent.getString("totalRecoveredCases")));
                newRecovered = insertComma.format(Integer.valueOf(countryParent.getString("newlyRecoveredCases")));

                newCases = "+" + newCases;
                newDeaths = "+" + newDeaths;
                newRecovered = "+" + newRecovered;

                CovidData c1 = new CovidData(countryName, totalCases, newCases, totalDeaths,
                        newDeaths, totalRecovered, newRecovered);
                countryObjects.add(c1);
            }
            displayCovidData(countryObjects.get(0));
            System.out.println(countryObjects);
        }
        catch (JSONException e){
                Log.e("Parsing Error...",url);
        }
    }

    public CovidData objectToShow(int index)
    {
        return countryObjects.get(index);
    }

    public void displayCovidData(CovidData data){

        countryOrRegion.setText(data.getCountryName());

        SpannableString redColorCases = new SpannableString(data.getNewCases());
        redColorCases.setSpan(new ForegroundColorSpan(Color.RED),0,data.getNewCases().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        confirmedCases.setText(TextUtils.concat(data.getTotalCases(), " (", redColorCases, ")"));

        SpannableString redColorDeaths = new SpannableString(data.getNewDeaths());
        redColorDeaths.setSpan(new ForegroundColorSpan(Color.RED), 0, data.getNewDeaths().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        deathCases.setText(TextUtils.concat(data.getTotalDeaths(), " (", redColorDeaths, ")"));

        SpannableString greenColorRecovered = new SpannableString(data.getNewRecovered());
        greenColorRecovered.setSpan(new ForegroundColorSpan(Color.rgb(74,184,72)), 0, data.getNewRecovered().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        recoveredCases.setText(TextUtils.concat(data.getTotalRecovered(), " (", greenColorRecovered, ")"));
    }
}

