package pl.edu.ug.tent.springmvcdemo.validator;

import pl.edu.ug.tent.springmvcdemo.domain.Item;

public class ItemValidator {
    public static boolean validateItems(Item item){
        if (item.getQuantity() < 0) return false;
        if (item.getPrice() <= 0) return false;
        return true;
    }
}
