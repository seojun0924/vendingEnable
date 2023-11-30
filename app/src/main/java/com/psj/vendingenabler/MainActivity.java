
package com.psj.vendingenabler;

import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.psj.vendingenabler.databinding.ActivityMainBinding;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate and get instance of binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // set content view to binding's root
        setContentView(binding.getRoot());
        Context c = getApplicationContext();
        PackageManager pm = c.getPackageManager();
        try {
            pm.setApplicationEnabledSetting("com.android.vending", PackageManager.COMPONENT_ENABLED_STATE_ENABLED, 0);
            finish();
        } catch (Exception e) {
           /* try { // These were made to log exceptions to file instead of showing them
                File f = new File(c.getExternalFilesDir(null), "log.txt");
                BufferedWriter writer = new BufferedWriter(new FileWriter(f));
                writer.write(e.getMessage());
            } catch (Exception e2) {
                e2.printStackTrace();
            } */
            TextView t = findViewById(R.id.text);
            t.setText(e.getMessage());
            
            // e.printStackTrace();
            
        }
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }
}
