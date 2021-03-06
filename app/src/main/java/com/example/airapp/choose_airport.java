package com.example.airapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class  choose_airport extends AppCompatActivity implements View.OnClickListener {

    // variable initialization
    private ListView listViewAirport;
    private ArrayList<AirPort> arrayListAirport;
    private AdapterListAirport adapterAirport;
    private ImageView backImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_airport);

        // Variable initialization
        arrayListAirport = new ArrayList<>();
        listViewAirport = findViewById(R.id.listViewAirport);
        backImage = findViewById(R.id.backImage);

        // handle
        loadDataToListAirport();
        adapterAirport = new AdapterListAirport(getBaseContext(),R.layout.layout_airport,arrayListAirport);
        listViewAirport.setAdapter(adapterAirport);
        listViewAirport.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent data = new Intent();
                        saveDataToIntent(data,i);
                        finish();
                }
        });
        backImage.setOnClickListener(this);
    }

    public void saveDataToIntent(Intent i,int index){
        String abbreviations = arrayListAirport.get(index).getAbbreviations();
        String provinceCity = arrayListAirport.get(index).getProvinceOrCity();
        i.putExtra("IDAirport",abbreviations);
        i.putExtra("ProvinceCity",provinceCity);
        setResult(RESULT_OK,i);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.backImage) {
            finish();
        }
    }

    public void loadDataToListAirport() {
        arrayListAirport.add(new AirPort(1,"HAN","H?? N???i","S??n bay qu???c t??? N???i B??i"));
        arrayListAirport.add(new AirPort(2,"BMV","Bu??n M?? Thu???t","S??n bay qu???c n???i Bu??n M?? Thu???t"));
        arrayListAirport.add(new AirPort(3,"SGN","H??? Ch?? Minh","S??n bay qu???c t??? T??n S??n Nh???t"));
        arrayListAirport.add(new AirPort(4,"DNA","???? N???ng","S??n bay ???? N???ng"));
        arrayListAirport.add(new AirPort(5,"VCA","C???n Th??","S??n bay C???n Th??"));
        arrayListAirport.add(new AirPort(6,"DIN","??i???n Bi??n Ph???","S??n bay ??i???n Bi??n Ph???"));
        arrayListAirport.add(new AirPort(7,"VII","Ngh??? An","S??n bay Vinh"));
        arrayListAirport.add(new AirPort(8,"HPH","H???i Ph??ng","S??n bay H???i Ph??ng"));
        arrayListAirport.add(new AirPort(9,"PXU","Gia Lai","S??n bay Pleiku"));
        arrayListAirport.add(new AirPort(10,"VCS","V??ng T??u","S??n bay C??n ?????o"));
        arrayListAirport.add(new AirPort(11,"PQC","Ki??n Giang","S??n bay Ph?? Qu???c"));
    }
}