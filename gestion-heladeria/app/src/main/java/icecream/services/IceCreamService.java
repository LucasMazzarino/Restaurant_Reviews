package icecream.services;

import icecream.models.IceCreamFlavor;
import icecream.repository.IceCreamRepository;

public class IceCreamService {
    private final IceCreamRepository repository;

    public IceCreamService() {
        this.repository = IceCreamRepository.getInstance();
    }

    public void addFlavor(String flavorName, Integer quantity) {
        IceCreamFlavor iceCreamFlavor = new IceCreamFlavor(flavorName, quantity);
        repository.addFlavor(iceCreamFlavor);
    }

    public Boolean sellFlavor(String flavorName, Integer quantity) {
        return repository.sellFlavor(flavorName, quantity);
    }

    public  void displayInventory() {
        repository.displayInventory();
    }
}
