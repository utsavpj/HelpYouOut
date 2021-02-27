package com.example.helpyouout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class MusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

//
//        public static int[] covers = {R.drawable.peach, R.drawable.album2, R.drawable.album3, R.drawable.peach, R.drawable.album2, R.drawable.album3 };
//        public static String[] song = {"Make War", "Shadow", "Black Parade","Make War", "Shadow", "Black Parade" };
//
//
//            PagerContainer container = (PagerContainer) findViewById(R.id.pager_container);
//            final ViewPager pager = container.getViewPager();
//            pager.setAdapter(new MyPagerAdapter());
//            pager.setClipChildren(false);
//            //
//            pager.setOffscreenPageLimit(15);
//
//            boolean showTransformer = getIntent().getBooleanExtra("showTransformer",true);
//
//
//            if(showTransformer){
//
//                new CoverFlow.Builder()
//                        .with(pager)
//                        .scale(0.3f)
//                        .pagerMargin(getResources().getDimensionPixelSize(R.dimen.pager_margin))
//                        .spaceSize(0f)
//                        .build();
//
//            }else{
//                pager.setPageMargin(30);
//            }
//            final TextView tv_song = (TextView) findViewById(R.id.tv_song);
//            pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//                @Override
//                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//                }
//
//                @Override
//                public void onPageSelected(int position) {
//                    tv_song.setText(song[position]);
//                    RelativeLayout relativeLayout = (RelativeLayout) pager.getAdapter().instantiateItem(pager, 0);
//                    ViewCompat.setElevation(relativeLayout.getRootView(), 8.0f);
//                    Palette palette = Palette.from(drawableToBitmap(covers[position])).generate();
//                    setStatusBar(palette);
//                }
//
//                @Override
//                public void onPageScrollStateChanged(int state) {
//
//                }
//            });
//        }
//
//
//        private class MyPagerAdapter extends PagerAdapter {
//
//            @Override
//            public Object instantiateItem(ViewGroup container, int position) {
//
//                View view = LayoutInflater.from(MusicActivity.this).inflate(R.layout.item_cover,null);
//                ImageView imageView =  view.findViewById(R.id.image_cover);
//                imageView.setImageDrawable(getResources().getDrawable(covers[position]));
//                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                container.addView(view);
//                return view;
//            }
//
//            @Override
//            public void destroyItem(ViewGroup container, int position, Object object) {
//                container.removeView((View)object);
//            }
//
//            @Override
//            public int getCount() {
//                return covers.length;
//            }
//
//            @Override
//            public boolean isViewFromObject(View view, Object object) {
//                return (view == object);
//            }
//        }
//        public void setStatusBar(Palette palette){
//            Window window = getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                Palette.Swatch vibrant = palette.getDominantSwatch();
//                if (vibrant != null) {
//                    window.setStatusBarColor(vibrant.getRgb());
//                }
//
//            }
//        }
//
//
//        public Bitmap drawableToBitmap(int id) {
//            Bitmap bitmap = null;
//            Drawable drawable = getResources().getDrawable(id);
//            if (drawable instanceof BitmapDrawable) {
//                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
//                if(bitmapDrawable.getBitmap() != null) {
//                    return bitmapDrawable.getBitmap();
//                }
//            }
//
//            if(drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
//                bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
//            } else {
//                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
//            }
//
//            Canvas canvas = new Canvas(bitmap);
//            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
//            drawable.draw(canvas);
//            return bitmap;
//        }
//
//

    }
}