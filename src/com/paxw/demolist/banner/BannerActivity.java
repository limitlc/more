package com.paxw.demolist.banner;


import com.paxw.demolist.R;
import com.paxw.demolist.banner.utils.GetBannerData;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;


public class BannerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        RelativeLayout bannerContent = (RelativeLayout) findViewById(R.id.banner_cont);
        BannerBaseView banner = new MainBannerView(this);
        bannerContent.addView(banner);
        banner.update(GetBannerData.getBannerData());
    }




}
