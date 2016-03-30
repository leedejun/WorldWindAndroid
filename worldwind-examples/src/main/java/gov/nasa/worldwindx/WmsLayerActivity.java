/*
 * Copyright (c) 2016 United States Government as represented by the Administrator of the
 * National Aeronautics and Space Administration. All Rights Reserved.
 */

package gov.nasa.worldwindx;

import android.os.Bundle;

import gov.nasa.worldwind.geom.Sector;
import gov.nasa.worldwind.ogc.WmsLayer;
import gov.nasa.worldwind.ogc.WmsLayerConfig;

public class WmsLayerActivity extends BasicGlobeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configure an OGC Web Map Service (WMS) layer to display the sea surface temperature layer from
        // NASA's Near Earth Observations WMS.
        WmsLayerConfig config = new WmsLayerConfig();
        config.serviceAddress = "http://neowms.sci.gsfc.nasa.gov/wms/wms";
        config.wmsVersion = "1.1.1"; // NEO server works best with WMS 1.1.1
        config.layerNames = "MYD28M"; // Sea surface temperature (MODIS)
        WmsLayer layer = new WmsLayer(new Sector().setFullSphere(), 1e3, config); // 1km resolution

        // Add the WMS layer to the World Window before the Atmosphere layer.
        int index = this.getWorldWindow().getLayers().indexOfLayerNamed("Atmosphere");
        this.getWorldWindow().getLayers().addLayer(index, layer);
    }
}
