package Repository;

import Model.elev_student;
import Model.materii;

import java.io.BufferedReader;
import java.io.FileReader;

public class MateriiRepo extends AbstractRepository<materii> {
    public materii getEntityByNume(String nume) {
        for (materii materie : this.getAllEntities()) {
            if (materie.getNume().equals(nume)) {
                return materie;
            }
        }
        return null;
    }

    public boolean entityExists(String nume) {
        for (materii materie : this.getAllEntities()) {
            if (materie.getNume().equals(nume)) {
                return true;
            }
        }
        return false;
    }

    public void readFiles() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\Programe\\Projects\\Siemens\\src\\Repository\\materii.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(";");
                materii materie = new materii(words[0], Integer.parseInt(words[1]));
                this.addEntity(materie);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
