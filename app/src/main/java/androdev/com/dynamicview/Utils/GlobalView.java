package androdev.com.dynamicview.Utils;
import android.content.Context;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androdev.com.dynamicview.R;

public class GlobalView {

    GlobalView(){

    }
    
    public static View populateCustomView(Context context, LayoutInflater layoutInflater, ViewGroup viewGroup,String inputType,String fieldName){
        
        View  view = null;

        if(inputType.equals(GlobalVariables.INPUT_TEXT)) {
            view = layoutInflater.inflate(R.layout.generic_layout_field_view, viewGroup, false);
            EditText editText = view.findViewById(R.id.generic_edit_text);
            editText.setHint("Enter "+fieldName);
            TextView fieldNameG = view.findViewById(R.id.generic_field_name);
            fieldNameG.setText(fieldName);
        }else if(inputType.equals(GlobalVariables.INPUT_NUMBER)){
            view = layoutInflater.inflate(R.layout.generic_layout_field_view, viewGroup, false);
            EditText editText = view.findViewById(R.id.generic_edit_text);
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            TextView fieldNameG = view.findViewById(R.id.generic_field_name);
            fieldNameG.setText(fieldName);
        }else if(inputType.equals(GlobalVariables.INPUT_LIST)){
            view = layoutInflater.inflate(R.layout.generic_layout_list_view, viewGroup, false);
        }

        //Date | Time | Scanner | etc you can add based on requirement


        return view;
    }
}
