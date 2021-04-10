package kg.megacom.models;

import kg.megacom.enums.PhoneColor;
import kg.megacom.enums.PhoneType;

public class Phone {

    private PhoneType phoneType;
    private PhoneColor phoneColor;
    private int price;

    public Phone( PhoneType phoneType, PhoneColor phoneColor, int price) {

        this.phoneType = phoneType;
        this.phoneColor = phoneColor;
        this.price = price;
    }



    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public PhoneColor getPhoneColor() {
        return phoneColor;
    }

    public void setPhoneColor(PhoneColor phoneColor) {
        this.phoneColor = phoneColor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneType=" + phoneType +
                ", phoneColor=" + phoneColor +
                ", price=" + price +
                '}';
    }
}
