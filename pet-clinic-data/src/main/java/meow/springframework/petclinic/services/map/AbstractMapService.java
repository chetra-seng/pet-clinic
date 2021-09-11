package meow.springframework.petclinic.services.map;

import meow.springframework.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long>{
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        if(object != null){
            if(object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }
        else{
            throw new RuntimeException("Object can't be null");
        }

        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    Long getNextId(){
        Long nextVal = null;
        try{
            nextVal = Collections.max(map.keySet()) + 1;
        }
        catch(NoSuchElementException ex){
            nextVal = 1L;
        }
        return nextVal;
    }
}
