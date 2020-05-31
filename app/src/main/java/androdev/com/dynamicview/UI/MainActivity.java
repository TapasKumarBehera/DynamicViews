package androdev.com.dynamicview.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import androdev.com.dynamicview.R;
import androdev.com.dynamicview.Utils.GlobalVariables;
import androdev.com.dynamicview.Utils.GlobalView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    LayoutInflater mLayoutInflater;
    ViewGroup viewGroupContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //view group or the container of views
        viewGroupContainer = findViewById(R.id.llParentLayout);

        //initialize the inflater
        mLayoutInflater = getLayoutInflater();

        populateViews();
    }

    /**
     * Populate the views based on the input type
     **/
    private void populateViews(){

        View view;
        String[] country = { "India", "USA", "China", "Japan", "Other"};

        ArrayList<String> inputTypeLst = createCustomViews();
        Log.d(TAG,"listViews"+inputTypeLst.size());

        for (int i = 0; i < inputTypeLst.size(); i++) {


            Log.d(TAG, "populateViews: "+inputTypeLst.get(i)+" == "+"Test "+i);
            view = GlobalView.populateCustomView(this,mLayoutInflater,viewGroupContainer,inputTypeLst.get(i),"Test "+i);
            if(inputTypeLst.get(i).equals(GlobalVariables.INPUT_LIST)){
                Spinner spinner = view.findViewById(R.id.generic_spinner_view);

                ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
                aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(aa);

            }

            viewGroupContainer.addView(view);
        }
    }

    /**
     * This is a static view creation but you can get from an API or a config created based on the requirement
     * You can add 'n' number of fields of different types of input type
     * The good pratice is configure this field in a config and  update the view based on the config
     **/
    private ArrayList<String> createCustomViews(){

        ArrayList<String> list = new ArrayList();
        list.add(GlobalVariables.INPUT_TEXT);
        list.add(GlobalVariables.INPUT_NUMBER);
        list.add(GlobalVariables.INPUT_LIST);
        list.add(GlobalVariables.INPUT_TEXT);

        return list;
    }

    /**
     * InCase you want to add something then you can add below the container view
     **/
    public void testButton(View view) {
        Toast.makeText(this, "TestButton Clicked", Toast.LENGTH_SHORT).show();
    }
}
