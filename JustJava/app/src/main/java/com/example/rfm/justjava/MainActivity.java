package com.example.rfm.justjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import static android.R.attr.duration;
import static android.R.id.message;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity >= 100) {
            Toast.makeText(this, "Maximum of coffee is 100", Toast.LENGTH_SHORT).show();
        } else {
            displayQuantity(quantity += 1);
        }
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void decrement(View view) {
        if (quantity <= 1) {
            Toast.makeText(this, "Minimum of coffee is 1", Toast.LENGTH_SHORT).show();
        } else {
            displayQuantity(quantity -= 1);
        }
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.wipped_cream_checkbox);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        EditText nameField = (EditText) findViewById(R.id.name_field);
        boolean hasWippedCream = whippedCreamCheckBox.isChecked();
        boolean hasChocolate = chocolateCheckBox.isChecked();
        int totalPrice = calculatePrice(hasWippedCream,hasChocolate);
        String name = nameField.getText().toString();
        String message = createOrderSummary(totalPrice,hasWippedCream,hasChocolate,name);
        //displayMessage(message);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, "JustJava Order from " +name);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Show the summary of the order.
     *
     */
    private String createOrderSummary(int total, boolean addWippedCream, boolean addChocolate, String name) {
        String msg = "Name: " + name;
        msg += "\nAdd Wipped Cream " + addWippedCream;
        msg += "\nAdd Chocolate " + addChocolate;
        msg += "\nQuantity: " + quantity;
        msg += "\nTotal: $" + total;
        msg += "\nThank you !";
        return msg;
    }

    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice(boolean hasWippedCream, boolean hasChocolate) {
        int basePrice = 5;

        if(hasWippedCream){
            basePrice = basePrice + 1;
        }
        if (hasChocolate){
            basePrice = basePrice + 2;
        }

        return quantity * basePrice;
    }

    /**
     * This method displays the given text on the screen.
     */
    //private void displayMessage(String message) {
    //    TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
    //    orderSummaryTextView.setText(message);
    //}

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int quantity) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }
}