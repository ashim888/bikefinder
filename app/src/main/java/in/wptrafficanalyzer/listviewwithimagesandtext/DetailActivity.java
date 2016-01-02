package in.wptrafficanalyzer.listviewwithimagesandtext;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        ImageView image= (ImageView)findViewById(R.id.myDetailImage);
        TextView price =(TextView)findViewById(R.id.myDetailPrice);
        TextView title = (TextView)findViewById(R.id.myDetailTitle);
        TextView detail= (TextView)findViewById(R.id.myDetailDetail);
        Button order=(Button)findViewById(R.id.order);

        Intent intent =getIntent();
        final String mainTitle=intent.getStringExtra(MainActivity.EXTRA_TITLE);
        String mainDetail=intent.getStringExtra(MainActivity.EXTRA_DETAIL);
        String mainPrice=intent.getStringExtra(MainActivity.EXTRA_PRICE);

//        int image_link = getIntent().getIntExtra(MainActivity.EXTRA_IMAGE, R.drawable.default);
//        image.setImageResource(image_link);
        Bundle bundle = this.getIntent().getExtras();
        int pic = bundle.getInt(MainActivity.EXTRA_IMAGE);

        /* Set Values to the views */
        price.setText(mainPrice);
        title.setText(mainTitle);
        detail.setText(mainDetail);
        image.setImageResource(pic);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "ORDER FOR BIKE "+ mainTitle);
                intent.putExtra(Intent.EXTRA_TEXT, "I WANT THIS BIKE "+ mainTitle+" So can meet and talk");
                intent.setData(Uri.parse("mailto:default@recipient.com")); // or just "mailto:" for blank
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
