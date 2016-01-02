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
    	"Electric Start , Alloy Wheels , Tubeless Tyres , Digital Display Panel , LED Tail Light , Front Disc Brake , Rear Disc Brake, Very good in condition urgent sell, i want to sell this because i want to go abroad",
            "Electric Start , Alloy Wheels , Tubeless Tyres , Digital Display Panel , LED Tail Light , Front Disc Brake , Rear Disc Brake, Very good in condition urgent sell, i want to sell this because i want to go abroad",
            "Electric Start , Alloy Wheels , Tubeless Tyres , Digital Display Panel , LED Tail Light , Front Disc Brake , Rear Disc Brake, Very good in condition urgent sell, i want to sell this because i want to go abroad",
            "Electric Start , Alloy Wheels , Tubeless Tyres , Digital Display Panel , LED Tail Light , Front Disc Brake , Rear Disc Brake, Very good in condition urgent sell, i want to sell this because i want to go abroad",
            "Electric Start , Alloy Wheels , Tubeless Tyres , Digital Display Panel , LED Tail Light , Front Disc Brake , Rear Disc Brake, Very good in condition urgent sell, i want to sell this because i want to go abroad",
            "Electric Start , Alloy Wheels , Tubeless Tyres , Digital Display Panel , LED Tail Light , Front Disc Brake , Rear Disc Brake, Very good in condition urgent sell, i want to sell this because i want to go abroad",
            "Electric Start , Alloy Wheels , Tubeless Tyres , Digital Display Panel , LED Tail Light , Front Disc Brake , Rear Disc Brake, Very good in condition urgent sell, i want to sell this because i want to go abroad",
            "Electric Start , Alloy Wheels , Tubeless Tyres , Digital Display Panel , LED Tail Light , Front Disc Brake , Rear Disc Brake, Very good in condition urgent sell, i want to sell this because i want to go abroad",
            "Electric Start , Alloy Wheels , Tubeless Tyres , Digital Display Panel , LED Tail Light , Front Disc Brake , Rear Disc Brake, Very good in condition urgent sell, i want to sell this because i want to go abroad"
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