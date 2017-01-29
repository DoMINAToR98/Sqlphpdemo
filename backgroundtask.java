package in.sodevan.sqlphpdemo;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by kartiksharma on 26/01/17.
 */

public class backgroundtask extends AsyncTask<String,Void,String> {
    Context ctx;

    backgroundtask(Context ctx){
     this.ctx=ctx;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String  doInBackground(String... params) {
        String reg_url="http://10.0.2.2/register.php";


        String method="register";
        if(method.equals("register"))
        {
            String Name=params[1];
            String Username=params[2];
            String Userpass=params[3];
            try {
                URL url=new URL(reg_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data= URLEncoder.encode("user","UTF-8")+ "=" + URLEncoder.encode(Name,"UTF-8")+"&"
                        +URLEncoder.encode("username","UTF-8")+ "=" + URLEncoder.encode(Username,"UTF-8")+"&"
                        +URLEncoder.encode("userpass","UTF-8")+ "=" + URLEncoder.encode(Userpass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream IS=httpURLConnection.getInputStream();
                IS.close();
                return "Registrastion success";



            } catch (MalformedURLException e) {
                e.printStackTrace();
                Log.d("Tag","wrong url");
            } catch (IOException e)
            {
                Log.d("Tag","oooono");
                e.printStackTrace();
            }
        }
        return "Fail";

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
    }
}
