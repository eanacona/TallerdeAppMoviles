package com.tallerapp.evaluacion6

import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.lang.Math.toRadians
import kotlin.math.* //Import que permite utilizar las funciones matemáticas del lenguaje Kotlin

class MainGps : AppCompatActivity() {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient //variable que nos permite autorizar al usuario para que nos de acceso a su ubicación
    private lateinit var locationTv: TextView //variable para localizar a la vista con los resultados de la geolocalización

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_gps)

        locationTv = findViewById(R.id.locationTv)
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        getCurrentLocation()
    }

    // función para obtener permisos para acceder a la ubicación y en caso que no se tengan estos sean solicitados
    private fun getCurrentLocation(){
        if(ActivityCompat.checkSelfPermission( // este if es para conocer si el sistema tiene o no tiene acceso a los permisos de localización
                this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
                this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ){
            ActivityCompat.requestPermissions( //en caso que no se tengan estos permisos, la aplicación solicita estos permisos
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                1
            )
            return
        }

        //evento que se activa si se ha dado o no permisos para acceder a la ubicación
        fusedLocationProviderClient.lastLocation.addOnSuccessListener { location: Location? ->
            if (location == null){
                locationTv.text = "No se pudo obtener la ubicación"
            } else {
                val latitud = location.latitude //latitud y longitud obtenida por medio de la posición del GPS del usuario
                val longitud = location.longitude
                val latitud2 = -36.826944 //Latitud Plaza de la Independecia de Concepción
                val longitud2 = -73.049722 //Longitud Plaza de la Independecia de Concepción
                val tierra = 6371 // Radio de La Tierra
                val lat1rad = toRadians(latitud) //convierte el valor de la latitud y longitud por medio del metodo toRadians a radianes, sin tener que confeccionar una ecuación pertinente
                val lon1rad = toRadians(longitud)
                val lat2rad = toRadians(latitud2)
                val lon2rad = toRadians(longitud2)

                val deltalat = lat2rad - lat1rad
                val deltalon = lon2rad - lon1rad

                val a =
                    sin(deltalat/2) * sin(deltalat/2) +
                            cos(lat1rad) * cos(lat2rad) *
                            sin(deltalon/2) * sin(deltalon/2)

                val c = 2 * atan2(sqrt(a), sqrt(1 - a))

                val dist = tierra * c

                locationTv.text = "Latitud: $latitud \n Longitud: $longitud \n Usted se encuentra a %.2f".format(dist) + " kilómetros de la bodega"
                /* print out que verá el usuario en la pantalla de la aplicación
                *  %2f format es para que el resultado final se encuetre limitado a dos decimales y que no salga el resultado con la totalidad de ellos
                */
            }
        }
    }

    // metodo para revisar la respuesta a la solicitud de los permisos
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResult: IntArray
    ){
        super.onRequestPermissionsResult(requestCode, permissions, grantResult)

        if (requestCode == 1 && grantResult.isNotEmpty() && grantResult[0] == PackageManager.PERMISSION_GRANTED)
            getCurrentLocation()

    }

}