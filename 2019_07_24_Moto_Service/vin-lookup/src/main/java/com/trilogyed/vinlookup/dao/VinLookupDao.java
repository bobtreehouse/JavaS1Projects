package com.trilogyed.vinlookup.dao;

import com.trilogyed.vinlookup.model.Vehicle;

public interface VinLookupDao {

    Vehicle getVehicleByVin  (String vin);
}
