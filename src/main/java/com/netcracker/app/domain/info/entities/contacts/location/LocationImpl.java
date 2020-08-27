package com.netcracker.app.domain.info.entities.contacts.location;

public class LocationImpl implements Location {

    private String name;

    private Type type;

    private Location parent;

    public LocationImpl(String name, Type type, Location parent) {
        setName(name);
        setType(type);
        setParent(parent);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void setParent(Location parent) {
        this.parent = parent;
    }

    @Override
    public String getParentName() {
        return parent.getName();
    }

    @Override
    public Location getTopLocation() {
        if (this.getParentName() == null) {
            return this;
        } else {
            return parent.getTopLocation();
        }
    }

    @Override
    public boolean isCorrect() {
        if (this.parent == null || type.compareTo(parent.getType()) > 0
                && parent.isCorrect()) {
            return true;
        }
        return false;
    }

    @Override
    public String getAddress() {
        String currentName;
        if (name.contains(".") && (name.indexOf(".") == name.length() - 1
                || name.indexOf(".") + 1 == name.indexOf(" "))) {
            currentName = name;
        } else {
            currentName = type.getNameForAddress() + name;
        }
        if (parent == null) {
            return currentName;
        } else {
            return currentName + ", " + parent.getAddress();
        }
    }

    @Override
    public String toString() {
        return this.getName() + " (" + this.getType() + ")";
    }
}
