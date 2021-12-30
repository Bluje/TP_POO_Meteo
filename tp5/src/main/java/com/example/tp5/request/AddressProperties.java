package com.example.tp5.request;

public class AddressProperties {
    private AddressData properties;
    private CoordinatesData geometry;

    public AddressProperties(){
    }

    public AddressData getProperties() {
        return properties;
    }

    public void setProperties(AddressData properties) {
        this.properties = properties;
    }

    public CoordinatesData getGeometry() {
        return geometry;
    }

    public void setGeometry(CoordinatesData geometry) {
        this.geometry = geometry;
    }


}
