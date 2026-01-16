package ma.projet.cycledeviev2;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    TextView tvState;
    GridView gridView;
    FloatingActionButton fabClose;
    Toolbar toolbar;

    private void updateState(String state) {
        tvState.setText("État actuel : " + state);
        Log.d("LIFECYCLE", state);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvState = findViewById(R.id.tvState);
        gridView = findViewById(R.id.gridView);
        fabClose = findViewById(R.id.fab_close);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        updateState("onCreate()");

        String[] data = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        gridView.setAdapter(adapter);

        fabClose.setOnClickListener(v -> finish());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_background) {
            moveTaskToBack(true);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateState("onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateState("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        updateState("onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        updateState("onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        updateState("onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        updateState("onDestroy()");
    }
}
