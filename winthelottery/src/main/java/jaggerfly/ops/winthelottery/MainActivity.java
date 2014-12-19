package jaggerfly.ops.winthelottery;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends RoboActivity {

    @InjectView(R.id.btnJagger)
    ImageButton btnJagger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJagger.setOnClickListener(btnJagger_onClickListener);

    }

    private View.OnClickListener btnJagger_onClickListener = new View.OnClickListener() {
        String message="";
        @Override
        public void onClick(final View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());


            message=(getString(R.string.thanks)+"\n"+getString(R.string.about)) ;
            builder.setTitle(R.string.company_name);

            builder.setMessage(message);
            builder.setCancelable(true);

            final AlertDialog dlg = builder.create();

            dlg.show();

            final Timer t = new Timer();
            t.schedule(new TimerTask() {
                public void run() {
                    dlg.dismiss(); // when the task active then close the dialog
                    t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                }
            }, 3000); // after 3 second (or 3000 miliseconds), the task will be active.


        }
    };

}
