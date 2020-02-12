package com.secuxtech.mysecuxpay.Activity;

import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.secuxtech.mysecuxpay.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class PaymentResultActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_result);

        Boolean result = getIntent().getExtras().getBoolean(PaymentDetailsActivity.PAYMENT_RESULT);

        ImageView imgviewRet = findViewById(R.id.imageView_result);
        int color = ContextCompat.getColor(this, R.color.colorPaymentFail);
        String resultStr = "Payment Failed";
        if (result){
            resultStr = "Payment Successful";
            color = ContextCompat.getColor(this, R.color.colorPaymentSuccess);

            imgviewRet.setImageResource(R.drawable.payment_success);
        }else{
            imgviewRet.setImageResource(R.drawable.payment_failed);
        }
        TextView textviewRet = findViewById(R.id.textView_payment_result);
        textviewRet.setTextColor(color);
        textviewRet.setText(resultStr);

        String amountStr = getIntent().getStringExtra(PaymentDetailsActivity.PAYMENT_AMOUNT);
        TextView textviewAmt = findViewById(R.id.textView_payment_amount);
        textviewAmt.setTextColor(color);
        textviewAmt.setText(amountStr);

        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
        Date date = Calendar.getInstance().getTime();
        TextView textviewDate = findViewById(R.id.textView_payment_date);
        textviewDate.setText(simpleDateFormat.format(date));

        String storename = getIntent().getStringExtra(PaymentDetailsActivity.PAYMENT_STORENAME);
        TextView textviewStoreName = findViewById(R.id.textView_storename_value);
        textviewStoreName.setText(storename);

    }
}
