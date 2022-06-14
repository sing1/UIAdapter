package sing.uiadapter.demo;

import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display mDisplay = getWindowManager().getDefaultDisplay();
        int W = mDisplay.getWidth();
        int H = mDisplay.getHeight();

        setContentView(R.layout.main_activity);

        Button button = (Button) findViewById(R.id.button);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) button.getLayoutParams();
        button.setText("控件尺寸 = " + params.width + "x" + params.height +
                "\n分辨率 = " + W + "x" + H +
                "\n" + W + "/" + params.width + "=" + twoDemal((double) params.width / W) +
                "\n" + H + "/" + params.height + "=" + twoDemal((double) params.height / H));

        Log.e("SystemParams",MySystemParams.getInstance(this).toString());
    }

    // 将double类型的数据保留两位小数
    public static String twoDemal(double num) {
        DecimalFormat dFormat = new DecimalFormat("##0.00");
        String result = dFormat.format(num);
        return result;
    }
}