package com.example.trupti.myurl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Modal> arraylistdata=new ArrayList<Modal>();



    String jsonstr="{\n" +
            "    \"response\": {\n" +
            "        \"result\": \"success\",\n" +
            "        \"data\": [\n" +
            "            {\n" +
            "                \"title\": \"HEADER 1\",\n" +
            "                \"description\": \"Lorem Ipsum Dummy Data\",\n" +
            "                \"image\": \"https://s.w.org/about/images/wordpress-logo-notext-bg.png\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"title\": \"HEADER 2\",\n" +
            "                \"description\": \"Dummy Data and Testing\",\n" +
            "                \"image\": \"https://s.w.org/about/images/wordpress-logo-notext-bg.png\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"title\": \"HEADER 3\",\n" +
            "                \"description\": \"Lorem Ipsum Dummy Data\",\n" +
            "                \"image\": \"https://s.w.org/about/images/wordpress-logo-notext-bg.png\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String title=null, description=null;
        String image =null;


        ListView lv=(ListView)findViewById(R.id.lview);
        Customadpter adpter=new Customadpter(this,arraylistdata);
        lv.setAdapter(adpter);


        try {

            JSONObject rootjsonObject=new JSONObject(jsonstr);

            JSONObject response=rootjsonObject.getJSONObject("response");

           // String rootresult=response.getString("result");




            JSONArray jsonArray= response.getJSONArray("data");
            for (int i=0; i< jsonArray.length() ; i++) {

                JSONObject myobj=jsonArray.getJSONObject(i);

                title=myobj.getString("title");
                description=myobj.getString("description");
                image=myobj.getString("image");


                Modal md=new Modal();
                md.setAtitle(title);
                md.setAdescription(description);
                md.setAimage(image);

                arraylistdata.add(md);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }




//        js();




//    private void js() {
//
//        try {
//
//            JSONObject rootjsonObject=new JSONObject(jsonstr);
//
//            JSONObject response=rootjsonObject.getJSONObject("response");
//
//            String rootresult=response.getString("result");
//
//
//            JSONArray jsonArray= response.getJSONArray("data");
//            for (int i=0; i< jsonArray.length() ; i++)
//            {
//                JSONObject myobj = jsonArray.getJSONObject(i);
//
//                String titleroot=myobj.getString("title");
//
//
//            }
//
//
//
//            TextView tv=(TextView)findViewById(R.id.datatext);
//            tv.setText("data"+"\n"+rootresult+"\n"+);
//
//
//
//
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


    }
}













