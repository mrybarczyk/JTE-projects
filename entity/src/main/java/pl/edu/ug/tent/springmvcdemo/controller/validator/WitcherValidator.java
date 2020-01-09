package pl.edu.ug.tent.springmvcdemo.controller.validator;

import pl.edu.ug.tent.springmvcdemo.domain.Witcher;

public class WitcherValidator {
    public static boolean validateWitcher(Witcher w){
        if (w.getName().isEmpty()) return false;
        return true;
    }
}
