package sia.ktwist;

import java.util.Objects;
import lombok.Data;

@Data
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

    public Ingredient(String id, String name, Type type){
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    public Type getType(){
        return type;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Ingredient ingredient = (Ingredient) o;
        return id.equals(ingredient.id) &&
                name.equals(ingredient.name) &&
                type == ingredient.type;
    }

    @Override
    public int hashCode(){
        return  Objects.hash(id, name, type);
    }


    @Override
    public String toString(){
        return "id: " + id + '\'' + "name: " + name + '\'' + "type: " + type;
    }
}
