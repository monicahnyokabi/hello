package ke.co.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    tvRegister.setOnClickListener {
      val intent = Intent(baseContext, RegistrationActivity::class.java)
      startActivity(intent)
    }

    btnLogin.setOnClickListener {
      var userName = etUserName.text.toString()
      var password = etPassword.text.toString()
      Toast.makeText(baseContext, password, Toast.LENGTH_SHORT).show()
      startActivity(Intent(baseContext, CoursesActivity::class.java))

      public class MainActivity extends AppCompatActivity  {
      private ProgressBar progressBar;
      private MyProgressBar pb;
      private int progressStatus = 0;
      private ImageView ImageView;
      private Handler= new Handler ();

      @Override
      protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById (R.id.progressBar);
        ImageView imageView =(ImageView) findViewById (R.id.imageView);
        pb = new MyProgressBar (this);

        //Long operation by thread
        new Thread (new Runnable () {
          public void run() {
            while (progressStatus < 100) {
              progressStatus += 4;
              //Update progress bar with completion of operation
              handler.post(new Runnable () {
                public void run() {
                  progressBar.setProgress(progressStatus);
                  pb.setProgress(progressStatus);
                }
              });
              try {
                try {
                  // Sleep for 300 milliseconds.
                  //Just to display the progress slowly
                  Thread.sleep(300);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            }
          }).start();
        }

        class MyProgressBar extends ProgressBar
        {
          public MyProgressBar (Context context) {
            super(context);
          }

          @Override
          public void setProgress(int progress)
          {
            super.setProgress(progress);
            if (progress == this.getMax()) {
              //Do stuff when progress is max
              Intent intent = new Intent(MainActivity.this, SecondActivity.class);
              startActivity(intent);
            }
          }
        }

      }
    }
}@Override
    val
            value: Any
    value = public boolean onCreateOptionsMenu(Menu: menu)
      getMenuInflater().inflate(R.menu.menu_main, menu);
      return true;
    }
