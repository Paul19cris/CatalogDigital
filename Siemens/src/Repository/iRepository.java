package Repository;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public interface iRepository<Entity> {
    void addEntity(Entity entity);
    void removeEntity(Entity entity);
    void updateEntity(Entity oldEntity, Entity newEntity);
    ArrayList<Entity> getAllEntities();
    Entity getEntityByNume(String nume);
    boolean entityExists(String nume);
    void readFiles();
}
