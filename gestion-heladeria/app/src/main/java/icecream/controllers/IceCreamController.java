package icecream.controllers;

import icecream.services.IceCreamService;

public class IceCreamController {
    private final IceCreamService service;

    public IceCreamController() {
        this.service = new IceCreamService();
    }

    public void addFlavor(String flavorName,  Integer quantity) {
        service.addFlavor(flavorName, quantity);
        System.out.println("El sAbor se ha agregado correctamente.");
    }

    public void sellFlavor(String flavorName, Integer quantity) {
        if(service.sellFlavor(flavorName, quantity)) {
            System.out.println("El ha vendido el helado sabor: " + flavorName + " cantidad: " + quantity + " paletas");
        } else {
            System.out.println("No se pudo vender el Sabor.");
        }
    }

    public void displayInventory() {
        service.displayInventory();
    }
}

