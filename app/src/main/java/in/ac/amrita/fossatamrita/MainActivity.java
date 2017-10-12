package in.ac.amrita.fossatamrita;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    connect();
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    private void connect() throws  IOException{
        PostExample.main(new String[] {"Sp0i" , "Sparker0i"});
    }
}
