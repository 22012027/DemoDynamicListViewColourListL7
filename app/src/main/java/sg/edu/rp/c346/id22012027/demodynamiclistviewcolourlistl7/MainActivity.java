package sg.edu.rp.c346.id22012027.demodynamiclistviewcolourlistl7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextColour;
    Button buttonAddItem;
    Button buttonRemoveItem;
    Button buttonUpdateItem;
    ListView listViewColour;
    ArrayAdapter aaColour;
    EditText editTextIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextColour=findViewById(R.id.editTextColour);
        buttonAddItem=findViewById(R.id.buttonAddItem);
        buttonRemoveItem=findViewById(R.id.buttonRemoveItem);
        buttonUpdateItem=findViewById(R.id.buttonUpdateItem);
        listViewColour=findViewById(R.id.listViewColour);
        editTextIndex=findViewById(R.id.editTextIndex);

        ArrayList<String> alColours = new ArrayList<String>();
        alColours.add("red");
        alColours.add("orange");

        aaColour= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);
        listViewColour.setAdapter(aaColour);

        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextIndex.getText().toString().isEmpty()) {
                    String colour= editTextColour.getText().toString();
                    alColours.add(colour);
                    aaColour.notifyDataSetChanged();
                } else {
                    String colour= editTextColour.getText().toString();
                    String indexStr= editTextIndex.getText().toString();
                    int index= Integer.parseInt(indexStr);
                    alColours.add(index, colour);
                }
            }
        });

        buttonRemoveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour= editTextColour.getText().toString();
                alColours.remove(colour);
                aaColour.notifyDataSetChanged();
            }
        });

        buttonUpdateItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour= editTextColour.getText().toString();
                int index=Integer.parseInt(editTextIndex.getText().toString());
                alColours.set(index, colour);
                aaColour.notifyDataSetChanged();
            }
        });

        listViewColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();    }
        });
    }
}