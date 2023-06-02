package Repository;

import Model.elev_student;

import java.io.BufferedReader;
import java.io.FileReader;

public class ElevStudentRepo extends AbstractRepository<elev_student> {
    public elev_student getEntityByNume(String nume) {
        for (elev_student elevStudent : this.getAllEntities()) {
            if (elevStudent.getNume().equals(nume)) {
                return elevStudent;
            }
        }
        return null;
    }

    public boolean entityExists(String nume) {
        for (elev_student elevStudent : this.getAllEntities()) {
            if (elevStudent.getNume().equals(nume)) {
                return true;
            }
        }
        return false;
    }

    public void readFiles() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\Programe\\Projects\\Siemens\\src\\Repository\\elevi_studenti.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(";");
                elev_student elevStudent = new elev_student(words[0], words[1], Integer.parseInt(words[2]));
                this.addEntity(elevStudent);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
