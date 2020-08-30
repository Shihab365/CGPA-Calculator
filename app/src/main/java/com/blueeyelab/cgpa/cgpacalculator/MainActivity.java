package com.blueeyelab.cgpa.cgpacalculator;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double crd_add=0;
    double total_add=0;
    Button addButton,refrButton;
    EditText edt1,edt2;
    ListView itemsListView;
    TextView cgpa_text;
    ArrayList<Items> list= new ArrayList<>();
    NumberFormat format;
    LinearLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refrButton=(Button)findViewById(R.id.refresh_btn_id);
        addButton=(Button) findViewById(R.id.add_id);
        edt1=(EditText) findViewById(R.id.credit_id);
        edt2=(EditText) findViewById(R.id.gpa_id);
        cgpa_text=(TextView)findViewById(R.id.total_id);
        itemsListView  = (ListView)findViewById(R.id.listview_id);
        rootLayout  = (LinearLayout) findViewById(R.id.rootlayout_id);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String credit = edt1.getText().toString();
                String gpa = edt2.getText().toString();

                if (credit.matches("") || gpa.matches(""))
                {
                    Snackbar.make(rootLayout,"Enter Credit and GPA",Snackbar.LENGTH_SHORT).show();
                }
                else
                {
                    double c = Double.parseDouble(credit);
                    double g = Double.parseDouble(gpa);
                    
                    double t = c * g;

                    if (g >= 4.00) {
                        String total = "A+";
                        String rmk = "Outstanding";
                        Items item = new Items(credit, gpa, total, rmk);
                        item.getRmk();
                        item.getCredit();
                        item.getGpa();
                        item.getTotal();
                        list.add(item);
                    }
                    if (g >= 3.75 && g <= 3.99) {
                        String total = "A";
                        String rmk = "Excellent";
                        Items item = new Items(credit, gpa, total, rmk);
                        item.getRmk();
                        item.getCredit();
                        item.getGpa();
                        item.getTotal();
                        list.add(item);
                    }
                    if (g >= 3.50 && g <= 3.74) {
                        String total = "A-";
                        String rmk = "Very Good";
                        Items item = new Items(credit, gpa, total, rmk);
                        item.getRmk();
                        item.getCredit();
                        item.getGpa();
                        item.getTotal();
                        list.add(item);
                    }
                    if (g >= 3.25 && g <= 3.49) {
                        String total = "B+";
                        String rmk = "Good";
                        Items item = new Items(credit, gpa, total, rmk);
                        item.getRmk();
                        item.getCredit();
                        item.getGpa();
                        item.getTotal();
                        list.add(item);
                    }
                    if (g >= 3.00 && g <= 3.24) {
                        String total = "B";
                        String rmk = "Satisfactory";
                        Items item = new Items(credit, gpa, total, rmk);
                        item.getRmk();
                        item.getCredit();
                        item.getGpa();
                        item.getTotal();
                        list.add(item);
                    }
                    if (g >= 2.75 && g <= 2.99) {
                        String total = "B-";
                        String rmk = "Above Average";
                        Items item = new Items(credit, gpa, total, rmk);
                        item.getRmk();
                        item.getCredit();
                        item.getGpa();
                        item.getTotal();
                        list.add(item);
                    }
                    if (g >= 2.50 && g <= 2.74) {
                        String total = "C+";
                        String rmk = "Average";
                        Items item = new Items(credit, gpa, total, rmk);
                        item.getRmk();
                        item.getCredit();
                        item.getGpa();
                        item.getTotal();
                        list.add(item);
                    }
                    if (g >= 2.25 && g <= 2.49) {
                        String total = "C";
                        String rmk = "Below Average";
                        Items item = new Items(credit, gpa, total, rmk);
                        item.getRmk();
                        item.getCredit();
                        item.getGpa();
                        item.getTotal();
                        list.add(item);
                    }
                    if (g >= 2.00 && g <= 2.24) {
                        String total = "D";
                        String rmk = "Pass";
                        Items item = new Items(credit, gpa, total, rmk);
                        item.getRmk();
                        item.getCredit();
                        item.getGpa();
                        item.getTotal();
                        list.add(item);
                    }
                    if (g < 2.00) {
                        String total = "F";
                        String rmk = "Fail";
                        Items item = new Items(credit, gpa, total, rmk);
                        item.getRmk();
                        item.getCredit();
                        item.getGpa();
                        item.getTotal();
                        list.add(item);
                    }

                    crd_add += c;
                    total_add += t;

                    format = new DecimalFormat("#.##");

                    Double avg = total_add / crd_add;
                    String cv = format.format(avg).toString();
                    String avgs = Double.toString(Double.parseDouble(cv));


                    final CustomListAdapter adapter = new CustomListAdapter(MainActivity.this, list);

                    refrButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            edt1.setText("");
                            edt2.setText("");
                            cgpa_text.setText("");
                            list.clear();
                            adapter.notifyDataSetChanged();
                        }
                    });
                    itemsListView.setAdapter(adapter);

                    cgpa_text.setText(avgs);
                    edt2.setText("");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_items,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.about_id)
        {
            startActivity(new Intent(MainActivity.this,AboutActivity.class));
        }
        if(item.getItemId()==R.id.feedback_id)
        {
            startActivity(new Intent(MainActivity.this,FeedbackActivity.class));
        }
        if(item.getItemId()==R.id.share_id)
        {
            Intent i=new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_TEXT,"CGPA Calculator https://play.google.com");
            startActivity(Intent.createChooser(i,"Share Via"));
        }
        return super.onOptionsItemSelected(item);
    }
}
