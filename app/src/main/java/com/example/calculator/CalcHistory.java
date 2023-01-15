package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class CalcHistory extends AppCompatActivity {

    private ArrayList<String> exps;
    private RecyclerView opHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_history);

        opHistory = findViewById(R.id.opHistory);
        exps = new ArrayList<String>();

        ArrayList<String> GetExpressions = new ArrayList<String>();
        GetExpressions = getIntent().getStringArrayListExtra("ExpressionText");

        //exps = (ArrayList<String>) GetExpressions.clone();
        for (int i=GetExpressions.size()-1; i>=0; i--)
        {
            exps.add(GetExpressions.get(i));
        }

        RecyclerAdapter ourListAdapter = new RecyclerAdapter(exps);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        opHistory.setLayoutManager(layoutManager);
        opHistory.setItemAnimator(new DefaultItemAnimator());
        opHistory.setAdapter(ourListAdapter);



        /*for (int i=GetExpressions.size()-1; i>=0; i--)
        {
            exps.add(GetExpressions.get(i));
        }*/
        //GetExpressions.clear();
    }

    public void Back(View view)
    {
        finish();
    }


    public void AdaugaExpresion(View view)
    {
        /*EditText Nume = findViewById(R.id.Nume);
        studenti.add(Nume.getText().toString());
        Nume.getText().clear();*/


    }
}