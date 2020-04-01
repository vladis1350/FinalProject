package com.vladis1350.enumCategory;

public enum Category {
    FRUIT("Fruit"),
    VEGETABLES("Vegetables"),
    CLOTHES("Clothes"),
    TECHNICAL_GOODS("Technical goods"),
    BUILDING_PRODUCTS("Building products"),
    DAIRY_PRODUCTS("Dairy products"),
    MEAT_PRODUCTS("Meat products"),
    SPORTS_AND_RECREATION("Sport and recreation"),
    BAKERY_PRODUCTS("Bakery products"),
    PRODUCTS_FOR_CHILDREN("Products for children");

    private final String roleCode;

    Category(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleCode() {
        return roleCode;
    }
}
