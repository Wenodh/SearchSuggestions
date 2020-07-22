package com.wenodh.searchsuggestions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val scan = "Nogozo is a local e-commerce company, first of its kind, currently active in Agra. Nogozo provides its users with a platform to access their local city market and shops with maximum comfort at no cost. The categories of shopping we are serving for now includes Groceries, Dairies, Veggies, Stationaries, Electronics, Fashion, Hardware and Fast Food Outlets. We are a community that aims to build a comfortable and health-conscious market environment. We dream to create an online marketing platform that maximizes the profit and comfort of both our consumers and retailers. We have some excellent features like multi-convenient delivery options, price comparison, health safety, every product in the showcase and the most important feature that makes us ahead in the field of e-commerce, i.e. we provide home businesses with an online platform to sell their limited street business to multiple squares across the city. For any query you can contact us: www.linkedin.com/company/nogozocare/"
    val hello:List<String> = scan.split(" ").map { it}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = AutoCompleteAdapter(this,R.layout.item_auto_complete_text_view,hello)
        actv.threshold = 1
        actv.setAdapter(adapter)
    }
}



