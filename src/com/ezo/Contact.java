package com.ezo;

public class Contact {
    private String name, phone, address;

    public Contact() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String phone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String address() {
        return address;
    }

    public String toString() {
        return name + ", " + phone + ", " + address;
    }
}
