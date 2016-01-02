package in.wptrafficanalyzer.listviewwithimagesandtext;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_TITLE="in.wptrafficanalyzer.listviewwithimagesandtext.TITLE";
    public final static String EXTRA_DETAIL="in.wptrafficanalyzer.listviewwithimagesandtext.DETAIL";
    public final static String EXTRA_PRICE="in.wptrafficanalyzer.listviewwithimagesandtext.PRICE";
    public final static String EXTRA_IMAGE="in.wptrafficanalyzer.listviewwithimagesandtext.IMAGE";
	
	// Array of strings storing country names
    String[] countries = new String[] {
            "One Hand 58 Lot R15 V.2 On Sale ",
            "Cbr 250 ",
            "Bajaj Pulsar Rs 200 ",
            "R15 V2 ",
            "Pulsar 220 Model 2015 ",
            "Modified Gixxer",
            "Yamaha Fzs Orange ",
            "Suzuki Gsr 600",
            "Royal Enfield Bullet (fresh Condition On Sale) ",
            "Tvs Apache Rtr160"
    };
    String[] price = new String[] {
            "120000 ",
            "250000 ",
            "200700 ",
            "400000",
            "250000",
            "230000",
            "230000",
            "630000",
            "530000",
            "160000"
    };
    
    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] flags = new int[]{
    		R.drawable.one,
    		R.drawable.two,
    		R.drawable.three,
    		R.drawable.four,
    		R.drawable.five,
    		R.drawable.six,
    		R.drawable.seven,
    		R.drawable.eight,
    		R.drawable.nine,
    		R.drawable.ten
    };
	
    // Array of strings to store currencies
    String[] currency = new String[]{
    	"Electric Start , Alloy Wheels , Tubeless Tyres , Digital Display Panel , LED Tail Light , Front Disc Brake , Rear Disc Brake, Very good in condition urgent sell, i want to sell this because i want to go abroad",
            "Bike One Hand ho. Tax pani 2073 samma clear xa. Condition A-One xa. Call me 9843212633 for more info, Very good in condition urgent sell, i want to sell this because i want to go abroad",
            "urgent sale contact with given phone no. Bike colour black and red    _contact no has changed plz contact in: 9860776456, Very good in condition urgent sell, i want to sell this because i want to go abroad",
            "Well maintained. Clean outlook. Maintinence free. Excellent conditions. Everything is fine. Driving is carefully., Rear Disc Brake, Very good in condition urgent sell, i want to sell this because i want to go abroad",
            "Bike brand new jastai cha no problem at all only 8000km ran.price fixed and final don't call me to bargain.one more thing 1 year ko tax baki cha 72/73 buyer should pay the tax if you want to buy it please call me only if you agree my price.",
            "I wanna buy another bike so m selling it.. condition is very good..Fresh xa. no exchange. .serious buyers can give a call and have a talk.., i want to sell this because i want to go abroad",
            "I want to ride r15 soo i would like to sell or exchange my bike with r15 v2 with lot above 60.., i want to sell this because i want to go abroad",
            "Bike ekdamai fresh n excellent condition ma xa.. Time to time maintenance gareko ho n line manxe lai zero rupees ko kharcha lagnexa... Very good in condition urgent sell, i want to sell this because i want to go abroad",
            "Bike gives near abt 40.6/ltr mileage and jus run 27000km... Believe garnu bike ekdamai fresh xa ma sanga aako bike bhayera ma yo bike bechna lageko... Bike hernus ra chalaunus i m sure u will b satisfied..",
            "Plz plz serious buyer call/text me on 9845021472 or 9808420299, Front Disc Brake , Rear Disc Brake, Very good in condition urgent sell, i want to sell this because i want to go abroad"
    };
    
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

      
        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();        
        
        for(int i=0;i<10;i++){
        	HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", countries[i]);
            hm.put("cur", currency[i]);
            hm.put("flag", Integer.toString(flags[i]) );
            hm.put("price",price[i]);
            aList.add(hm);        
        }
        
        // Keys used in Hashmap
        String[] from = { "flag","txt","cur","price" };
        
        // Ids of views in listview_layout
        int[] to = { R.id.flag,R.id.txt,R.id.cur,R.id.pri};
        
        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_layout, from, to);
        
        // Getting a reference to listview of main.xml layout file
        ListView listView = ( ListView ) findViewById(R.id.listview);

        // Setting the adapter to the listView
        listView.setAdapter(adapter);
//       android:gravity="right" Toast.makeText(MainActivity.this, "WTF", Toast.LENGTH_LONG).show();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "ID" + id, Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra(EXTRA_TITLE,countries[position]);
                intent.putExtra(EXTRA_DETAIL,currency[position]);
                intent.putExtra(EXTRA_PRICE,price[position]);
//                intent.putExtra(EXTRA_IMAGE,flags[position]);

                Bundle addinfo = new Bundle();
                addinfo.putInt(EXTRA_IMAGE, flags[position]);
                intent.putExtras(addinfo);
                startActivity(intent);



            }
        });
    }
}