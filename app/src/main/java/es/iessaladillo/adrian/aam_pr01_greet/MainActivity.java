package es.iessaladillo.adrian.aam_pr01_greet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener,
        OnCheckedChangeListener {

    private EditText txtName;
    private CheckBox chkPolite;
    @SuppressWarnings("FieldCanBeLocal")
    private Button btnGreet;
    private TextView lblGreet;
    private EditText txtSurname;
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews() {
        txtName = findViewById(R.id.txtName);
        txtSurname = findViewById(R.id.txtSurname);
        chkPolite = findViewById(R.id.chkPolite);
        btnGreet = findViewById(R.id.btnGreet);
        btnReset = findViewById(R.id.btnReset);

        lblGreet = findViewById(R.id.lblGreet);
        chkPolite.setOnCheckedChangeListener(this);
        btnGreet.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnGreet) {
            greet();

        }else if (id == R.id.btnReset) {
            reset();

        }
    }

    private void reset() {
        lblGreet.setText(R.string.reset);
        txtName.setText(R.string.reset);
        txtSurname.setText(R.string.reset);
        chkPolite.setChecked(false);
    }

    private void greet() {
        if (chkPolite.isChecked()) {
            lblGreet.setText(getString(R.string.main_activity_greet_polite) + " " + txtName.getText() + " "+ txtSurname.getText());
        }else{
            lblGreet.setText(getString(R.string.main_activity_greet_impolite) + " " + txtName.getText() + " " + txtSurname.getText());

        }


    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

}
