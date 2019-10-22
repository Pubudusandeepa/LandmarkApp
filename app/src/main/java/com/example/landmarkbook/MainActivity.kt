package com.example.landmarkbook

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var landmarkName =ArrayList<String>()
        landmarkName.add("Pisa")
        landmarkName.add("Colosseum")
        landmarkName.add("Eiffel")
        landmarkName.add("London Bridge")

        val pisa = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.pisa)
        val colosseum = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.col)
        val eifal = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.eiffel)
        val londanbridge = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.londonbridge)

        val landmarkImages = ArrayList<Bitmap>()

        landmarkImages.add(pisa)
        landmarkImages.add(colosseum)
        landmarkImages.add(eifal)
        landmarkImages.add(londanbridge)

        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkName)
        listView.adapter = arrayAdapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(applicationContext,DetailActivity::class.java)
            intent.putExtra("name",landmarkName[i])

            val bitmap =landmarkImages[i]
            val chosen =Globals.Chosen
            chosen.chosenImage = bitmap
            startActivity(intent)

        }
    }
}
