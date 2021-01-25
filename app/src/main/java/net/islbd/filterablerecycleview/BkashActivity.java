package net.islbd.filterablerecycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.softbd.aamarpay.PayByAamarPay;
import com.softbd.aamarpay.interfaces.OnPaymentRequestListener;
import com.softbd.aamarpay.model.OptionalFields;
import com.softbd.aamarpay.model.PaymentResponse;
import com.softbd.aamarpay.model.RequiredFields;
import com.softbd.aamarpay.utils.Params;

public class BkashActivity extends AppCompatActivity {

    private Context mContext;
    private Activity mActivity;

    private Button btn_pay_now;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bkash);

        mContext = BkashActivity.this;
        mActivity = BkashActivity.this;

        btn_pay_now = findViewById(R.id.btn_pay_now);
        btn_pay_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ammarpay();
            }
        });
    }

    private void ammarpay() {
        RequiredFields requiredFields = new RequiredFields(
                "Kothabondhu",
                "shakhawat@islbd.net",
                "Dhaka",
                "City",
                "State",
                "1234",
                "Country",
                "0123456789",
                "Description",
                "1",
                Params.CURRENCY_BDT,
                "A205230",
                "aamarpay",
                "28c78bb1f45112f5d40b956fe104645a",
                "https://sandbox.aamarpay.com/success.php",
                "https://sandbox.aamarpay.com/failed.php",
                "https://sandbox.aamarpay.com/failed.php"
        );
        OptionalFields optionalFields = new OptionalFields(
                "cus address 2",
                "cus fax",
                "ship name",
                "ship address1",
                "ship address 2",
                "ship city",
                "ship state",
                "ship postcode",
                "ship country",
                "optional string",
                "optional string",
                "optional string",
                "optional string"
        );
        PayByAamarPay.getInstance(mContext, requiredFields, optionalFields).payNow(new OnPaymentRequestListener() {
            @Override
            public void onPaymentResponse(int paymentStatus, PaymentResponse paymentResponse) {
                System.out.println("paymentStatus: " + paymentStatus);
                //Here you can view all the response in one place
                System.out.println("Response: " + new Gson().toJson(paymentResponse));
            }
        });
    }
}