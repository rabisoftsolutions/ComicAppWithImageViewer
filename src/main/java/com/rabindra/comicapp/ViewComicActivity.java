package com.rabindra.comicapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rabindra.comicapp.Adapter.MyViewPagerAdapter;
import com.rabindra.comicapp.Common.Common;
import com.rabindra.comicapp.Model.Chapter;
import com.wajahatkarim3.easyflipviewpager.BookFlipPageTransformer;

public class ViewComicActivity extends AppCompatActivity {
    ViewPager viewPager;
    TextView txt_chapter_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_comic);

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        txt_chapter_name = (TextView) findViewById(R.id.txt_chapter_name);

        Toolbar toolbar = (Toolbar)findViewById(R.id.viewcomic_toolbar);
        toolbar.setTitle(Common.chapterSelected.Name);
        //set icon
        toolbar.setNavigationIcon(R.drawable.ic_chevron_left_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fetchLinks(Common.chapterSelected);
    }

    private void fetchLinks(Chapter chapter) {
        if (chapter.Links !=null)
        {
            if (chapter.Links.size()>0)
            {
                MyViewPagerAdapter adapter = new MyViewPagerAdapter(getBaseContext(),chapter.Links);
                viewPager.setAdapter(adapter);

                //Animation
                BookFlipPageTransformer bookFlipPageTransformer = new BookFlipPageTransformer();
                bookFlipPageTransformer.setScaleAmountPercent(10f);
                viewPager.setPageTransformer(true,bookFlipPageTransformer);
            }
            else {
                Toast.makeText(this, "No Image Here", Toast.LENGTH_SHORT).show();
            }

        }
        else {
            Toast.makeText(this, "This Chapter is Translateing", Toast.LENGTH_SHORT).show();
        }


    }
}
