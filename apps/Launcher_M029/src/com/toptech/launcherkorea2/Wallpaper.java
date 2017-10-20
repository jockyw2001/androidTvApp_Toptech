package com.toptech.launcherkorea2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

/**
 * Wallpaper picker for the Home application. User can choose from
 * a gallery of stock photos.
 */
public class Wallpaper extends Activity implements
        AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    private static final String LOG_TAG = "Home";

    private Handler mHandler;
    private Toast mToast;

   ///wallpaper
    private static final Integer[] THUMB_IDS = {
            R.drawable.wallpaper01_icon,
            R.drawable.wallpaper02_icon,
            R.drawable.wallpaper03_icon,
            R.drawable.wallpaper04_icon,
            R.drawable.wallpaper05_icon,
    };
//wallpaper icon
    private static final Integer[] IMAGE_IDS = {
            R.drawable.wallpaper01,
            R.drawable.wallpaper02,
            R.drawable.wallpaper03,
            R.drawable.wallpaper04,
            R.drawable.wallpaper05,
    };

    private Gallery mGallery;
    private boolean mIsWallpaperSet;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.wallpaper);
        mGallery = (Gallery) findViewById(R.id.gallery);
        mGallery.setAdapter(new ImageAdapter(this));
        mGallery.setOnItemSelectedListener(this);
        mGallery.setOnItemClickListener(this);

        mHandler = new Handler();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsWallpaperSet = false;
    }

    public void onItemSelected(AdapterView parent, View v, int position, long id) {
        getWindow().setBackgroundDrawableResource(IMAGE_IDS[position]);
    }

    public void onItemClick(AdapterView parent, View v, int position, long id) {
        selectWallpaper(position);
    }

    /*
     * When using touch if you tap an image it triggers both the onItemClick and
     * the onTouchEvent causing the wallpaper to be set twice. Synchronize this
     * method and ensure we only set the wallpaper once.
     */
    private synchronized void selectWallpaper(int position) {
        if (mIsWallpaperSet) {
            return;
        }
        mIsWallpaperSet = true;
        try {
            InputStream stream = getResources().openRawResource(IMAGE_IDS[position]);
            setWallpaper(stream);

            mHandler.postDelayed(new Runnable() {
                
                @Override
                public void run() {
            setResult(RESULT_OK);
            finish();
                }
            }, 1000);
            if (mToast==null) {
            	showToast();
			} 
        } catch (IOException e) {
            Log.e(LOG_TAG, "Failed to set wallpaper " + e);
        }
    }

    public void onNothingSelected(AdapterView parent) {
    }
    //skye
    public void showToast() {
    	mToast=Toast.makeText(getApplicationContext(), getString(R.string.wallpaper_set), 100);
    	mToast.setGravity(Gravity.CENTER, 0, 0);
    	mToast.show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        selectWallpaper(mGallery.getSelectedItemPosition());
        return true;
    }

    public class ImageAdapter extends BaseAdapter {

        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return THUMB_IDS.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View convertView, ViewGroup parent) {
            ImageView i = new ImageView(mContext);

            i.setImageResource(THUMB_IDS[position]);
            i.setAdjustViewBounds(true);
            i.setLayoutParams(new Gallery.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            i.setBackgroundResource(android.R.drawable.picture_frame);
            return i;
        }

    }

}
