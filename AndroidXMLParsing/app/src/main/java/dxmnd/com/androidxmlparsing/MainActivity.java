package dxmnd.com.androidxmlparsing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 2017-08-06 URL 입력
        List<ParsingData> list = getData("");

        Log.e(TAG, list.toString());
    }

    private List<ParsingData> getData(String URL) {
        XMLParsing xmlParsing = new XMLParsing(URL);
        List<ParsingData> list = new ArrayList<>();
        try {
            list = xmlParsing.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return list;
    }
}
