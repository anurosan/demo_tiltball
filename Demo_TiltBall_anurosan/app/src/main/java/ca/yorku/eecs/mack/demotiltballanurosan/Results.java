package ca.yorku.eecs.mack.demotiltballanurosan;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Results extends Activity {
    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        Bundle b = getIntent().getExtras();
        int wallHits = b.getInt("wallHits");
        double aveLapTime = b.getDouble("averageLapTime");
        double inPathPercent = b.getDouble("percentInPathTime");
        int lap = b.getInt("targetLaps");

        TextView lapsTV = findViewById(R.id.paramLaps);
        TextView lapTimeTV = findViewById(R.id.paramAveLapTime);
        TextView wallHitsTV = findViewById(R.id.paramWallHits);
        TextView inPathTV = findViewById(R.id.paramInPathPercent);

        String ph = "Laps =" + lap;
        lapsTV.setText(ph);
        ph = "Lap time = " + aveLapTime + " s (mean/lap)";
        lapTimeTV.setText(ph);
        ph = "Wall hits = " + wallHits;
        wallHitsTV.setText(ph);
        ph = "In-path time = " + inPathPercent + "%";
        inPathTV.setText(ph);

    }

    public void clickSetup(View view) {
        Intent i = new Intent(getApplicationContext(), DemoTiltBallSetup.class);
        startActivity(i);
    }

    public void clickExit(View view) {
        super.onDestroy(); // cleanup
        this.finish(); // terminate
    }
}
