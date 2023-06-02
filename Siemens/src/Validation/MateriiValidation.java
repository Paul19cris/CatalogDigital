package Validation;

import Model.materii;

public class MateriiValidation {
    public boolean validate(materii materii) throws Exception {
        if (materii.getNume().length() < 4) {
            throw new Exception("Numele trebuie sa fie mai lung de 4 caractere.");
        }
        if (materii.getCredite() < 0 || materii.getCredite() > 10) {
            throw new Exception("Creditele trebuie sa fie intre 0 si 10.");
        }
        return true;
    }
}
