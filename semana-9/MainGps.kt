package com.tallerapp.evaluacion9

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.dynamic.SupportFragmentWrapper
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainGps : AppCompatActivity(), OnMapReadyCallback {

    // Declaración de variable que podra ser usada por toda la clase
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gps)

        createFragment()

    }

    // Función permitir integrar el mapa a la interfaz
    private fun createFragment() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    // Permite señalar que cuando el mapa sea creado este sea visto en la visualización y pueda ser usado
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarker()

    }

    // Función para definir una cordenada fija en el mapa, en este caso, el centro de distribución representado a través de la Plaza de la Independencia de Concepción
    private fun createMarker() {
        // LatLng captura la latitud y la longitud
        val coordinates = LatLng(-36.82743603489232, -73.05014374088343)
        // Creación del marcador que identificara al centro de distribución en el mapa
        val marker = MarkerOptions().position(coordinates).title("Centro de distribución")
        map.addMarker(marker)
        // Código que permite hacer zoom a la ubicación marcada
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f), // 18f corresponde a la cantidad de zoom
            4000, // corresponde a los milisegundos que tardará en hacer zoom
            null
        )
    }
}