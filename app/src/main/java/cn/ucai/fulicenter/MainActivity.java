package cn.ucai.fulicenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    int index, currentIndex;
    RadioButton[] rbs = new RadioButton[5];
    @BindView(R.id.layout_new_good)
    RadioButton mLayoutNewGood;
    @BindView(R.id.layout_Boutique)
    RadioButton mLayoutBoutique;
    @BindView(R.id.layout_Category)
    RadioButton mLayoutCategory;
    @BindView(R.id.layout_Cart)
    RadioButton mLayoutCart;
    @BindView(R.id.layout_Personal)
    RadioButton mLayotuPersonal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        rbs[0] = mLayoutNewGood;
        rbs[1] = mLayoutBoutique;
        rbs[2] = mLayoutCategory;
        rbs[3] = mLayoutCart;
        rbs[4] = mLayotuPersonal;
    }

    public void onCheckedChange(View view) {
        switch (view.getId()) {
            case R.id.layout_new_good:
                index=0;
                break;
            case R.id.layout_Boutique:
                index=1;
                break;
            case R.id.layout_Category:
                index=2;
                break;
            case R.id.layout_Cart:
                index=3;
                break;
            case R.id.layout_Personal:
                index=4;
                break;
        }
        if (index != currentIndex) {
            setRadioStatus();
        }
    }

    private void setRadioStatus() {
        for(int i=0;i<rbs.length;i++) {
            if (index != i) {
                rbs[i].setChecked(false);
            } else {
                rbs[i].setChecked(true);
            }
        }
        currentIndex = index;
    }
}
