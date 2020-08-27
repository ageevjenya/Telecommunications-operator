package com.netcracker.app.domain.info.entities.contacts;

import com.netcracker.app.domain.info.entities.contacts.location.Location;
import com.netcracker.app.domain.info.entities.contacts.location.LocationImpl;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@MappedSuperclass
public abstract class AbstractContacts implements Contacts {
    public Integer getId() {
        return id;
    }

    @Id
    @GeneratedValue
    private Integer id;
    private String address;
    private String phone;
    private String workHours;

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) throws Exception {
        if (Location.isLocation(address)) {
            Map<String, String> locationMap = Location.setLocation(address);
            List<Location> locationList = new LinkedList<>();
            locationList.add(new LocationImpl(locationMap.get("COUNTRY"), Location.Type.COUNTRY, null));
            locationList.add(new LocationImpl(locationMap.get("REGION"), Location.Type.REGION, locationList.get(0)));
            locationList.add(new LocationImpl(locationMap.get("CITY"), Location.Type.CITY, locationList.get(1)));
            locationList.add(new LocationImpl(locationMap.get("DISTRICT"), Location.Type.DISTRICT, locationList.get(2)));
            locationList.add(new LocationImpl(locationMap.get("STREET"), Location.Type.STREET, locationList.get(3)));
            locationList.add(new LocationImpl(locationMap.get("BUILDING"), Location.Type.BUILDING, locationList.get(4)));
            locationList.add(new LocationImpl(locationMap.get("APARTMENT"), Location.Type.APARTMENT, locationList.get(5)));
            this.address = locationList.get(5).getAddress();
        } else {
            throw new Exception("Incorrect address");
        }
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {

        this.phone = phone;
    }

    @Override
    public String getWorkHours() {
        return workHours;
    }

    @Override
    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public AbstractContacts(String address, String phone, String workHours) throws Exception {
        setAddress(address);
        setPhone(phone);
        setWorkHours(workHours);
    }

    public AbstractContacts() {}
}
