package Validation;

import Model.elev_student;

public class ElevStudentValidation {
    public boolean validate(elev_student elevStudent) throws Exception {
        if (elevStudent.getNume().length() < 4) {
            throw new Exception("Numele trebuie sa fie mai lung de 4 caractere.");
        }
        if (elevStudent.getNota() < 0 || elevStudent.getNota() > 10) {
            throw new Exception("Nota trebuie sa fie intre 0 si 10.");
        }
        return true;
    }
}
