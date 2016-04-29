package com.example.danielcalle.just_java;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view) {
        displayQuantity(quantity);
        int price = calculatePrice();
        displayMessage(createOrderSumary(price));
    }

    /**
     * Calculates the price of the order.
     *
     * //@param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    public void increment(View view){
        quantity ++;
        displayQuantity(quantity);
    }

    public void decrement(View view){
        if(quantity >= 1) {
            quantity--;
            displayQuantity(quantity);
        }
        else{
            Toast.makeText(getApplicationContext(), "No se puede decrementar", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int cantidad) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + cantidad);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private String createOrderSumary(int price){
        String message = "Name: Marcelo\nCantidad: "+quantity+"\nTotal: $"+price+"\nGracias!";
        return message;
    }
}
