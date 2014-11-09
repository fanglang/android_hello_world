package net.fang_lang.helloworld;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.content.DialogInterface;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    public void btnSend_onClick(View view) {
        final EditText txtName = (EditText)findViewById(R.id.txtName);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ダイアログのテスト")
            .setMessage(String.format("こんにちは、%sさん！！", txtName.getText()))
            .setPositiveButton("はい",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        _showName(txtName);
                    }
                }
            )
            .setNegativeButton("いいえ",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        _showAnonymousName();
                    }
                }
            )
            .show();
    }

    public void _showName(EditText txtName) {
        TextView txtResult = (TextView)findViewById(R.id.txtResult);
        txtResult.setText(String.format("こんにちは、%sさん！！", txtName.getText()));
    }

    public void _showAnonymousName() {
        TextView txtResult = (TextView)findViewById(R.id.txtResult);
        txtResult.setText("誰だ！貴様は！！");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
