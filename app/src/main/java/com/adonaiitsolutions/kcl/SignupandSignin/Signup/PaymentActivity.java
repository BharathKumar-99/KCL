package com.adonaiitsolutions.kcl.SignupandSignin.Signup;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



import com.adonaiitsolutions.kcl.R;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;


import org.json.JSONObject;


public class PaymentActivity extends Activity implements PaymentResultListener {
    private static final String TAG = PaymentActivity.class.getSimpleName();
    String Phone,Email;
    View vie;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_payment);

        Checkout.preload(getApplicationContext());

        // Payment button created by you in XML layout
        Button button = findViewById(R.id.btn_pay);

        button.setOnClickListener(this::startPayment);

        TextView privacyPolicy = findViewById(R.id.txt_privacy_policy);

        privacyPolicy.setOnClickListener(v -> {
            Intent httpIntent = new Intent(Intent.ACTION_VIEW);
            httpIntent.setData(Uri.parse("https://razorpay.com/sample-application/"));
            startActivity(httpIntent);
        });
    }

    public void startPayment(View vi) {
        this.vie=vi;
        final Activity activity = this;

        final Checkout co = new Checkout();
co.setKeyID("rzp_test_I9bLBsYMiIzN1P");
        try {
            JSONObject options = new JSONObject();
            options.put("name", "KCL");
            options.put("description", "Membership Charges");
            //You can omit the image option to fetch the image from dashboard
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            options.put("currency", "INR");
            options.put("amount", "100000");

            JSONObject preFill = new JSONObject();
            preFill.put("email", Email);
            preFill.put("contact", Phone);

            options.put("prefill", preFill);

            co.open(this, options);
        } catch (Exception e) {
            Toast.makeText(activity, "Error in payment: " + e.getMessage(), Toast.LENGTH_SHORT)
                    .show();
            e.printStackTrace();
        }
    }

    @Override
    public void onPaymentSuccess(String razorpayPaymentID) {
        try {
            Toast.makeText(this, "Payment Successful: " + razorpayPaymentID, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "Payment Failed", e);
        }
    }

    @Override
    public void onPaymentError(int code, String response) {
        try {
            Toast.makeText(this, "Payment failed: " + code + " " + response, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e(TAG, "Exception in onPaymentError", e);
        }
    }
}
