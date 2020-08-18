package com.netcracker.app.domain.info.entities.contacts.location;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Location {

    String LOCATION = "(COUNTRY:)([\\w\\s.,-]*)(REGION:)([\\w\\s.,-]*)(CITY:)([\\w\\s.,-]*)" +
            "(DISTRICT:)([\\w\\s.,-]*)(STREET:)([\\w\\s\\d.,-]*)(BUILDING:)([\\d\\s.,-/]*)(APARTMENT:)([\\d\\s.,-/]*)";

    static Map<String, String> setLocation(String address) {
        Map<String, String> mapLocation = new HashMap<>();
        mapLocation.put("COUNTRY", address.substring(8, address.indexOf("(REGION:)")).trim());
        mapLocation.put("REGION", address.substring(address.indexOf("(REGION:)") + 1, address.indexOf("(CITY:)")).trim());
        mapLocation.put("CITY", address.substring(address.indexOf("(CITY:)") + 1, address.indexOf("(DISTRICT:)")).trim());
        mapLocation.put("DISTRICT", address.substring(address.indexOf("(DISTRICT:)") + 1, address.indexOf("(STREET:)")).trim());
        mapLocation.put("STREET", address.substring(address.indexOf("(STREET:)") + 1, address.indexOf("(BUILDING:)")).trim());
        mapLocation.put("BUILDING", address.substring(address.indexOf("(BUILDING:)") + 1, address.indexOf("(APARTMENT:)")).trim());
        mapLocation.put("APARTMENT", address.substring(address.indexOf("(APARTMENT:)") + 1).trim());
        return mapLocation;
    }

    static boolean isLocation(String address) {
        Pattern pattern = Pattern.compile(Location.LOCATION);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }

    enum Type {
        COUNTRY(""),
        REGION("обл. "),
        CITY("г. "),
        DISTRICT("р-н "),
        STREET("ул. "),
        BUILDING("д. "),
        APARTMENT("кв. ");

        private String nameForAddress;

        private Type(String nameForAddress) {
            this.nameForAddress = nameForAddress;
        }

        public final String getNameForAddress() {
            return nameForAddress;
        }

        @Override
        public String toString() {
            String type = name();
            return type.charAt(0) + type.substring(1).toLowerCase();
        }
    }

    String getName();

    void setName(String name);

    Type getType();

    void setType(Type type);

    void setParent(Location parent);

    String getParentName();

    Location getTopLocation();

    boolean isCorrect();

    String getAddress();

    String toString();
}
