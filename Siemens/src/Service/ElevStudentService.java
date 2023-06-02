package Service;

import Model.elev_student;
import Model.materii;
import Repository.MateriiRepo;
import Repository.ElevStudentRepo;
import Utils.Utils;
import Validation.ElevStudentValidation;

import java.util.ArrayList;

public class ElevStudentService {
    private final ElevStudentRepo elevStudentRepo;
    private final ElevStudentValidation elevStudentValidation;
    private final MateriiRepo materiiRepo;
    private final Utils utils;
    public ElevStudentService(ElevStudentRepo elevStudentRepo, ElevStudentValidation elevStudentValidation, MateriiRepo materiiRepo, Utils utils) {
        this.elevStudentRepo = elevStudentRepo;
        this.elevStudentValidation = elevStudentValidation;
        this.materiiRepo = materiiRepo;
        this.utils = utils;
    }
    public String addElevStudent(String nume, String materie, int nota) throws Exception {
        elev_student elevStudent = new elev_student(nume, materie, nota);
        try {
            elevStudentValidation.validate(elevStudent);
        }
        catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        for (elev_student elevStudent1 : elevStudentRepo.getAllEntities()) {
            if (elevStudent1.getNume().equals(nume) && elevStudent1.getMaterie().equals(materie)) {
                throw new Exception("Elevul/Studentul exista deja la materia respectiva.");
            }
        }
        if (!materiiRepo.entityExists(materie)) {
            throw new Exception("Materia nu exista.");
        }
        for (elev_student elevStudent1 : elevStudentRepo.getAllEntities()) {
            if (elevStudent1.getNume().equals(nume)
                    && materiiRepo.getEntityByNume(elevStudent1.getMaterie()).getCredite() == 0
                    && materiiRepo.getEntityByNume(materie).getCredite() != 0) {
                throw new Exception("Materia aleasa este pentru studenti si nu poate fi adaugata unui elev.");
            }
            if (elevStudent1.getNume().equals(nume)
                    && materiiRepo.getEntityByNume(elevStudent1.getMaterie()).getCredite() != 0
                    && materiiRepo.getEntityByNume(materie).getCredite() == 0) {
                throw new Exception("Materia aleasa este pentru elevi si nu poate fi adaugata unui student.");
            }
        }
        elevStudentRepo.addEntity(elevStudent);
        return "Student Adaugat.";
    }
    public String removeElevStudent(String nume, String materie) throws Exception {
        for (elev_student elevStudent : elevStudentRepo.getAllEntities()) {
            if (elevStudent.getNume().equals(nume) && elevStudent.getMaterie().equals(materie)) {
                elevStudentRepo.removeEntity(elevStudent);
                return "Student Sters.";
            }
        }
        throw new Exception("Elevul/Studentul nu a fost gasit.");
    }
    public String updateElevStudent(String nume, String materie, int nota) throws Exception {
        elev_student elevStudent = new elev_student(nume, materie, nota);
        try {
            elevStudentValidation.validate(elevStudent);
        }
        catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        for (elev_student elevStudent1 : elevStudentRepo.getAllEntities()) {
            if (elevStudent1.getNume().equals(nume)
                    && materiiRepo.getEntityByNume(elevStudent1.getMaterie()).getCredite() == 0
                    && materiiRepo.getEntityByNume(materie).getCredite() != 0) {
                throw new Exception("Materia aleasa este pentru studenti si nu poate fi adaugata unui elev.");
            }
            if (elevStudent1.getNume().equals(nume)
                    && materiiRepo.getEntityByNume(elevStudent1.getMaterie()).getCredite() != 0
                    && materiiRepo.getEntityByNume(materie).getCredite() == 0) {
                throw new Exception("Materia aleasa este pentru elevi si nu poate fi adaugata unui student.");
            }
        }
        for (elev_student elevStudent1 : elevStudentRepo.getAllEntities()) {
            if (elevStudent1.getNume().equals(nume) && elevStudent1.getMaterie().equals(materie)) {
                elevStudentRepo.updateEntity(elevStudent1, elevStudent);
                return "Elev/Student modificat.";
            }
        }
        throw new Exception("Elevul/Studentul nu a fost gasit.");
    }
    public String displayElevStudent() throws Exception {
        String lista = "";
        for (elev_student elevStudent : elevStudentRepo.getAllEntities()) {
            lista += elevStudent.display();
        }
        if (lista.equals("")) throw new Exception("Nu exista elevi/studenti.\n");
        return lista;
    }
    public String aveargeElev() throws Exception {
        ArrayList<String> numeElevi = new ArrayList<>();
        String list = "";
        float medie = 0;
        float count = 0;
        for (elev_student elevStudent : elevStudentRepo.getAllEntities()) {
            if (materiiRepo.getEntityByNume(elevStudent.getMaterie()).getCredite() == 0
                    && !utils.checkIfEntityExistsInArray(elevStudent.getNume(), numeElevi)) {
                numeElevi.add(elevStudent.getNume());
            }
        }
        for (String elev : numeElevi) {
            medie = 0;
            count = 0;
            for (elev_student elevStudent : elevStudentRepo.getAllEntities()) {
                if (elevStudent.getNume().equals(elev)) {
                    medie += elevStudent.getNota();
                    count += 1;
                }
            }
            list += elev + " " + Float.toString(medie/count) + "\n";
        }
        if (list.equals("")) throw new Exception("Nu exista inca elevi.");
        return list;
    }
    public String aveargeStudent() throws Exception {
        String list = "";
        ArrayList<String> numeStudenti = new ArrayList<>();
        float medie = 0;
        float count = 0;
        for (elev_student elevStudent : elevStudentRepo.getAllEntities()) {
            if (materiiRepo.getEntityByNume(elevStudent.getMaterie()).getCredite() != 0
                    && !utils.checkIfEntityExistsInArray(elevStudent.getNume(), numeStudenti)) {
                numeStudenti.add(elevStudent.getNume());
            }
        }
        for (String student : numeStudenti) {
            medie = 0;
            count = 0;
            for (elev_student elevStudent : elevStudentRepo.getAllEntities()) {
                if (elevStudent.getNume().equals(student)) {
                    medie += elevStudent.getNota() * materiiRepo.getEntityByNume(elevStudent.getMaterie()).getCredite();
                    count += 1;
                }
            }
            list += student + " " + Float.toString(medie/count) + "\n";
        }
        if (list.equals("")) throw new Exception("Nu exista inca studenti.");
        return list;
    }
}
