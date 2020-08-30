package com.blueeyelab.cgpa.cgpacalculator;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class FeedbackActivity extends AppCompatActivity {

    EditText nameEdit,messageEdit;
    Button sendButton,clearButton;
    String strName,strMessage;
    Intent intent;
    LinearLayout rootLayout_feed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        nameEdit=(EditText)findViewById(R.id.fullname_id);
        messageEdit=(EditText)findViewById(R.id.message_id);
        sendButton=(Button)findViewById(R.id.send_email_id);
        clearButton=(Button)findViewById(R.id.clear_email_id);
        rootLayout_feed=(LinearLayout)findViewById(R.id.feed_rootlayout_id);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Feedback");

        //Back Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameEdit.setText("");
                messageEdit.setText("");
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strName=nameEdit.getText().toString();
                strMessage=messageEdit.getText().toString();
                if(strName.matches("") || strMessage.matches(""))
                {
                    Snackbar.make(rootLayout_feed,"Write your name and message",Snackbar.LENGTH_SHORT).show();
                }
                else
                {
                    intent=new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"shihabcse1@gmail.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT,strName);
                    intent.putExtra(Intent.EXTRA_TEXT,strMessage);

                    intent.setType("message/rfc822");
                    startActivity(Intent.createChooser(intent,"Select Email Sending App"));
                }
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
