package com.example.myapplication

import android.Manifest
import android.Manifest.permission
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.LocationManager.GPS_PROVIDER
import android.location.LocationManager.NETWORK_PROVIDER
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.myapplication.databinding.ActivityMapsBinding
import androidx.annotation.NonNull
import androidx.core.app.ActivityCompat
import android.Manifest.permission.ACCESS_COARSE_LOCATION

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.Context


class MapsActivity : AppCompatActivity(), OnMapReadyCallback
{

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var locationManager: LocationManager
    private lateinit var locationListener: LocationListener
    var lattitude:Double=0.00
    var longitude:Double=0.00
    lateinit var location:Location

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        if (ActivityCompat.checkSelfPermission(this,
                permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this,
                arrayOf<String>(permission.ACCESS_FINE_LOCATION, permission.ACCESS_COARSE_LOCATION),
                1)
        } else {
        }
        val locationManager: LocationManager =
            getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Toast.makeText(getApplicationContext(), "GPS not working", Toast.LENGTH_SHORT).show()
        } else if (!locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            Toast.makeText(getApplicationContext(), "Network is not working", Toast.LENGTH_SHORT)
                .show()
        } else {
            Toast.makeText(getApplicationContext(), "fetching location", Toast.LENGTH_SHORT).show()
        }
        val locationListener: LocationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                lattitude = location.latitude
                longitude = location.longitude
            }
        }
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                0,
                0f,
                locationListener)
            // locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,);
        }
        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)!!
        if (location != null) {
            lattitude = location!!.latitude
            longitude = location!!.longitude
            Toast.makeText(this@MapsActivity, "" + location!!.latitude, Toast.LENGTH_SHORT).show()
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(lattitude, longitude)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker at your place"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}

