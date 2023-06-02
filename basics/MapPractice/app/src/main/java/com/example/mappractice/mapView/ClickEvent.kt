package com.example.mappractice.mapView

import android.util.Log
import com.example.mappractice.MarkerManager
import com.example.mappractice.databinding.ActivityMainBinding
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

class ClickEvent(val mapView: MapView) : MapView.MapViewEventListener {
    val TAG: String = "로그"

    override fun onMapViewInitialized(p0: MapView?) {

    }

    override fun onMapViewCenterPointMoved(p0: MapView?, p1: MapPoint?) {
    }

    override fun onMapViewZoomLevelChanged(p0: MapView?, p1: Int) {
    }

    override fun onMapViewSingleTapped(p0: MapView?, p1: MapPoint?) {
    }

    override fun onMapViewDoubleTapped(p0: MapView?, point: MapPoint?) {
        val latitude = point?.mapPointGeoCoord?.latitude
        val longitude = point?.mapPointGeoCoord?.longitude
        val created_marker = MarkerManager().createMarker(latitude, longitude)

        mapView.addPOIItem(created_marker)
        Log.d(TAG, "latitude - $latitude, longitude - $longitude")
    }

    override fun onMapViewLongPressed(p0: MapView?, mapPoint: MapPoint?) {

    }

    override fun onMapViewDragStarted(p0: MapView?, p1: MapPoint?) {
    }

    override fun onMapViewDragEnded(p0: MapView?, p1: MapPoint?) {
    }

    override fun onMapViewMoveFinished(p0: MapView?, p1: MapPoint?) {
    }
}