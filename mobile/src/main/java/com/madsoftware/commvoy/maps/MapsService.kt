package com.madsoftware.commvoy.maps

import com.google.android.gms.maps.GoogleMap

class MapsService(mapInstance: GoogleMap) {

    /**
     * Constructor
     */
    init {
        var map = mapInstance
    }

    /**
     * Makes sure the user allows the map permission to get the users location.
     */
    fun getLocationPermission() {

    }

}