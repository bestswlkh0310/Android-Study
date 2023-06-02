package com.example.mappractice

import android.util.Log
import com.example.mappractice.databinding.ActivityMainBinding
import com.example.mappractice.mapView.ClickEvent
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint

class MarkerManager {
    var mbinding: ActivityMainBinding ?= null
    val binding get() = mbinding!!
    val TAG: String = "로그"

    fun createMarker(latitude: Double?, longitude: Double?): MapPOIItem {
        Log.d(TAG, "MarkerManager - createMarker() called")
        
        val marker = MapPOIItem()
        marker.apply {
            itemName = "내 위치"   // 마커 이름
            mapPoint = MapPoint.mapPointWithGeoCoord(latitude!!, longitude!!)   // 좌표
            markerType = MapPOIItem.MarkerType.CustomImage          // 마커 모양 (커스텀)
            customImageResourceId = R.drawable.user               // 커스텀 마커 이미지
            selectedMarkerType = MapPOIItem.MarkerType.CustomImage  // 클릭 시 마커 모양 (커스텀)
            customSelectedImageResourceId = R.drawable.user       // 클릭 시 커스텀 마커 이미지
            isCustomImageAutoscale = true      // 커스텀 마커 이미지 크기 자동 조정
            setCustomImageAnchor(0.5f, 1.0f)    // 마커 이미지 기준점
        }
        return marker
//        MainActivity().mapView.addPOIItem(marker)
//        MainActivity().mapView.setMapViewEventListener(ClickEvent())
    }

    fun myMarker(): MapPOIItem {
        val marker = MapPOIItem()
        marker.apply {
            itemName = "내 위치"   // 마커 이름
            Log.d(TAG, "${MainActivity().latitude} - ${MainActivity().longitude}")
            mapPoint = MapPoint.mapPointWithGeoCoord(MainActivity().latitude, MainActivity().longitude)   // 좌표
            markerType = MapPOIItem.MarkerType.CustomImage          // 마커 모양 (커스텀)
            customImageResourceId = R.drawable.user               // 커스텀 마커 이미지
            selectedMarkerType = MapPOIItem.MarkerType.CustomImage  // 클릭 시 마커 모양 (커스텀)
            customSelectedImageResourceId = R.drawable.user       // 클릭 시 커스텀 마커 이미지
            isCustomImageAutoscale = true      // 커스텀 마커 이미지 크기 자동 조정
            setCustomImageAnchor(0.5f, 1.0f)    // 마커 이미지 기준점
        }
        return marker
    }
}