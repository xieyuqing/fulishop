package cn.ucai.fulicenter.controller.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.fulicenter.R;
import cn.ucai.fulicenter.application.I;
import cn.ucai.fulicenter.controller.fragment.NewGoodsFragment;
import cn.ucai.fulicenter.view.MFGT;


public class BoutiqueChildActivity extends AppCompatActivity {

    @BindView(R.id.BoutiqueClild)
    TextView BoutiqueClild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boutique_child);
        ButterKnife.bind(this);

        String title = getIntent().getStringExtra(I.Boutique.TITLE);
        BoutiqueClild.setText(title);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, new NewGoodsFragment())
                .commit();
    }

    @OnClick(R.id.back)
    public void onClick() {
        MFGT.finish(BoutiqueChildActivity.this);
    }
}
