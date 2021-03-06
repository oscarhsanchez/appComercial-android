package gpovallas.app.medios;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import gpovallas.app.R;
import gpovallas.app.constants.GPOVallasConstants;

public class MeanGaleriaZoomActivity extends Activity {

    private static final String TAG = MeanGaleriaZoomActivity.class.getSimpleName();
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mean_galeria_zoom);

        mImageView = (ImageView) findViewById(R.id.image);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Picasso.with(this)
                    .load(extras.getString(GPOVallasConstants.PATH_IMAGE))
                    .error(R.drawable.logo_bg_orange)
                    .placeholder(R.drawable.logo_bg_orange)
                    .into(mImageView);
        }
    }
}
