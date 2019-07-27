package com.trilogyed.vinlookup.ServiceLayer;


import com.trilogyed.vinlookup.ViewModel.VinLookupView;
import com.trilogyed.vinlookup.dao.VinLookupDao;
import com.trilogyed.vinlookup.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VinLookupService {
    VinLookupDao vinLookupDao;

    @Autowired
    public VinLookupService(VinLookupDao vinLookupDao) {this.vinLookupDao = vinLookupDao;}

    public VinLookupView findVehicleByVin (String vin) {
        Vehicle vehicle = vinLookupDao.getVehicleByVin(vin);
        if (vehicle == null) {
            return null;
        }else {
            return buildVinLookupView(vehicle);
        }
     }

     private VinLookupView buildVinLookupView (Vehicle vehicle) {
        VinLookupView vinlook = new VinLookupView();
        vinlook.setType(vehicle.getType());
        vinlook.setMake(vehicle.getMake());
        vinlook.setModel(vehicle.getModel());
        vinlook.setColor(vehicle.getColor());
        vinlook.setYear(vehicle.getYear());


    return vinlook;
    }
}
