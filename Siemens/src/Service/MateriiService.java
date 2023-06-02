package Service;

import Model.materii;
import Repository.MateriiRepo;
import Validation.MateriiValidation;

public class MateriiService {
    private final MateriiRepo materiiRepo;
    private final MateriiValidation materiiValidation;
    public MateriiService(MateriiRepo materiiRepo, MateriiValidation materiiValidation) {
        this.materiiRepo = materiiRepo;
        this.materiiValidation = materiiValidation;
    }
    public String addMaterie(String nume, int credite) throws Exception {
        materii materie = new materii(nume, credite);
        try {
            materiiValidation.validate(materie);
        }
        catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        if (materiiRepo.entityExists(nume)) throw new Exception("Materia exista deja.");
        materiiRepo.addEntity(materie);
        return "Materie Adaugata.";
    }
    public String removeMaterie(String nume) throws Exception {
        if (!materiiRepo.entityExists(nume)) throw new Exception("Materia nu exista.");
        materii materie = materiiRepo.getEntityByNume(nume);
        materiiRepo.removeEntity(materie);
        return "Materie Adaugata.";
    }
    public String updateMaterie(String nume, int credite) throws Exception {
        materii materie = new materii(nume, credite);
        try {
            materiiValidation.validate(materie);
        }
        catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        if (!materiiRepo.entityExists(nume)) throw new Exception("Materia nu exista.");
        materiiRepo.updateEntity(materiiRepo.getEntityByNume(nume), materie);
        return "Materie Modificata.";
    }
    public String displayMaterie() throws Exception {
        String list = "";
        for (materii materie : materiiRepo.getAllEntities()) {
            list += materie.display();
        }
        if (list.equals("")) throw new Exception("Nu exista materii.\n");
        return list;
    }
}
