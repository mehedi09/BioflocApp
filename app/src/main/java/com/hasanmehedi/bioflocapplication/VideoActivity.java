package com.hasanmehedi.bioflocapplication;

import java.util.ArrayList;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;




import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;






public class VideoActivity extends AppCompatActivity {

    private static final String url = "jdbc:mysql://10.123.0.78:3307/minfiv_biofloc";
    private static final String user = "minfiv_biofloc";
    private static final String pass = "Mehedi2020";
    Button btnFetch,btnClear;
    TextView txtData;



    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Animatoo.animateFade(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        txtData = (TextView) this.findViewById(R.id.txtData);
        btnFetch = (Button) findViewById(R.id.btnFetch);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnFetch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
//    ConnectMySql connectMySql = new ConnectMySql();
//     connectMySql.execute("");




            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtData.setText("");
            }
        });

    }

//    private class ConnectMySql extends AsyncTask<String, Void, String> {
//        String res = "";
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            Toast.makeText(VideoActivity.this, "Please wait...", Toast.LENGTH_SHORT)
//                    .show();
//
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//                Connection con = DriverManager.getConnection(url, user, pass);
//                System.out.println("Databaseection success");
//
//                String result = "Database Connection Successful\n";
//                Statement st = con.createStatement();
//                ResultSet rs = st.executeQuery("select distinct Country from tblCountries");
//                ResultSetMetaData rsmd = rs.getMetaData();
//
//                while (rs.next()) {
//                    result += rs.getString(1).toString() + "\n";
//                }
//                res = result;
//            } catch (Exception e) {
//                e.printStackTrace();
//                res = e.toString();
//            }
//            return res;
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            txtData.setText(result);
//        }
//    }


}