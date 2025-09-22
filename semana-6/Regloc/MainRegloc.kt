package com.tallerapp.evaluacion6

import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainRegloc : AppCompatActivity() {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var locationTv: TextView
    //private lateinit var guardar: Button
    //private lateinit var latitud: Location
    //private lateinit var longitud: Location

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference
    private lateinit var persongps: PersonGps


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regloc)

        locationTv = findViewById(R.id.locationTv)
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        //guardar = findViewById(R.id.guardar)
        //latitud = latitud
        //longitud = longitud
        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.getReference("semana6")
        persongps = PersonGps()


        getCurrentLocation()

        //guardar.setOnClickListener {
        //val locationTv: String = locationTv.getText().toString()
        //val latitud: Double = latitud.latitude.toDouble()
        //val longitud: Double = longitud.longitude.toDouble()

        //addDataToFirebase(locationTv)
        //}
    }

    private fun getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(
                this, android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
                this, android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                1
            )
            return
        }

        fusedLocationProviderClient.lastLocation.addOnSuccessListener { location: Location? ->
            if (location == null) {
                locationTv.text = "No se pudo obtener la ubicación"
            } else {
                val latitud = location.latitude
                val longitud = location.longitude
                locationTv.text = "Latitud: $latitud \n Longitud: $longitud"
                val locationTv: String = locationTv.getText().toString()
                addDataToFirebase(locationTv)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResult: IntArray
    ){
        super.onRequestPermissionsResult(requestCode, permissions, grantResult)

        if (requestCode == 1 && grantResult.isNotEmpty() && grantResult[0] == PackageManager.PERMISSION_GRANTED)
            getCurrentLocation()

    }

    private fun addDataToFirebase (locationTv: String) {
    persongps.locationTv = locationTv
    //persongps.latitud = latitud
    // persongps.longitud = longitud

    databaseReference.push().setValue(persongps)
    .addOnSuccessListener {
    }
    .addOnFailureListener {
    }

    }

}