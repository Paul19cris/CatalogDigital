import Repository.ElevStudentRepo;
import Repository.MateriiRepo;
import UI.UI;
import Service.ElevStudentService;
import Service.MateriiService;
import Utils.Utils;
import Validation.*;

public class Main {
    public static void main(String[] args) {
        MateriiRepo materiiRepo = new MateriiRepo();
        materiiRepo.readFiles();
        ElevStudentRepo elevStudentRepo = new ElevStudentRepo();
        elevStudentRepo.readFiles();

        MateriiValidation materiiValidation = new MateriiValidation();
        MateriiService materiiService = new MateriiService(materiiRepo, materiiValidation);

        Utils utils = new Utils();
        ElevStudentValidation elevStudentValidation = new ElevStudentValidation();
        ElevStudentService elevStudentService = new ElevStudentService(elevStudentRepo, elevStudentValidation, materiiRepo, utils);

        UI ui = new UI(materiiService, elevStudentService);

        ui.run();
    }
}