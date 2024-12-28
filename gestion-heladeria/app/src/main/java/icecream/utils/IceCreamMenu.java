package icecream.utils;

import icecream.controllers.IceCreamController;

public class IceCreamMenu {
    private final IceCreamController controller;;
    private final IHandler handler;

    public IceCreamMenu(IceCreamController controller, IHandler handler) {
        this.controller = controller;
        this.handler = handler;
    }

    public IceCreamMenu(IHandler handler) {
        this(new IceCreamController(), handler);
    }

    public void displayMenu() {
        handler.writeLine("Bienvenido al sistema de inventarios de helados");

        while (true) {
            handler.writeLine("\nSelecciona una opcion:");
            handler.writeLine("1.  Agregar helado");
            handler.writeLine("2. Vender healdo");
            handler.writeLine("3. Ver inventario");
            handler.writeLine("4. Salir");
            handler.writeLine("Seleccione una opción: ");

            int option = Integer.compare(handler.readLine());

            switch (option){
                
            }

        }

    }

}
