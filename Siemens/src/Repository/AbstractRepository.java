package Repository;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<Entity> implements iRepository<Entity> {
    protected ArrayList<Entity> list = new ArrayList<Entity>();

    @Override
    public void addEntity(Entity entity) { this.list.add(entity); }

    @Override
    public void removeEntity(Entity entity) { this.list.remove(entity); }

    @Override
    public void updateEntity(Entity oldEntity, Entity newEntity) {
        this.list.remove(oldEntity);
        this.list.add(newEntity);
    }

    @Override
    public ArrayList<Entity> getAllEntities() { return this.list; }
}
