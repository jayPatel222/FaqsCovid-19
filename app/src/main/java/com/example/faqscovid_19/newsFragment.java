package com.example.faqscovid_19;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class newsFragment extends Fragment{

    View viewLocal;
    RecyclerView myRecyclerView;
    RecyclerAdapter recyclerAdapter;
    List<News> myDataSet = new ArrayList<>();
    RequestQueue QUEUE;
    String url = "https://api.smartable.ai/coronavirus/news/global?Subscription-Key=1a3e9cd5b22c4a9b86885d5ce7a1ce3d";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toolbar toolbar = Objects.requireNonNull(getActivity()).findViewById(R.id.toolbar);
        TextView toolbarTitle = toolbar.findViewById(R.id.toolbar_title);
        getActivity().setTitle(null);
        toolbarTitle.setText(R.string.news);

        viewLocal = inflater.inflate(R.layout.fragment_news, container, false);

        myRecyclerView = viewLocal.findViewById(R.id.news_recycler_view);
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerAdapter = new RecyclerAdapter(getContext(), myDataSet);

        QUEUE = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
        httpGET(url);

        return viewLocal;
    }

    public void httpGET(String url)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    parsingData(response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            }
        );
        QUEUE.add(stringRequest);
    }

    public void parsingData(String jsonText) {
        try {
            String imageUrl;
            String time;
            String name;
            String title;
            String link;

            JSONObject rootObject = new JSONObject(jsonText);
            JSONArray rootNews = rootObject.getJSONArray("news");

                for (int i = 0; i < rootNews.length(); ++i){
                    JSONObject parentNews = rootNews.getJSONObject(i);
                    JSONObject sourceObject = parentNews.getJSONObject("provider");

                    if(!parentNews.isNull("images")){
                        JSONArray imageArray = parentNews.getJSONArray("images");
                        JSONObject mainImage = imageArray.getJSONObject(0);
                        imageUrl = mainImage.getString("url");
                    }
                    else{
                        imageUrl = "https://media4.s-nbcnews.com/i/newscms/2019_01/2705191/nbc-social-default_b6fa4fef0d31ca7e8bc7ff6d117ca9f4.png";
                    }

                    if(!parentNews.isNull("publishedDateTime") && parentNews.has("publishedDateTime")){
                        time = parentNews.getString("publishedDateTime").substring(0,10);
                    }else{
                        time = "null";
                    }

                    if(!sourceObject.isNull("name") && sourceObject.has("name")){
                        name = sourceObject.getString("name");
                    }else{
                        name = "null";
                    }

                    if(!parentNews.isNull("title") && parentNews.has("title")){
                        title = parentNews.getString("title");
                    }else{
                        title = "null";
                    }

                    if(!parentNews.isNull("webUrl") && parentNews.has("webUrl")){
                        link = parentNews.getString("webUrl");
                    }else{
                        link = "";
                    }
                    News n1 = new News(name, title, link, time, imageUrl);

                    myDataSet.add(n1);
                }
                myRecyclerView.setAdapter(recyclerAdapter);
        }
        catch (JSONException e){
            Log.e("No results...",url);
        }
    }
}

