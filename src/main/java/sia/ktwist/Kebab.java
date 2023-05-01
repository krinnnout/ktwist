package sia.ktwist;

import java.util.List;
import lombok.Data;

@Data
public class Kebab {

    private String name;

    private List<Ingredient> ingredientList;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setIngredientList(List <Ingredient> ingredientList){
        this.ingredientList = ingredientList;
    }

    public List<Ingredient> getIngredientList(){
        return ingredientList;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Kebab kebab = (Kebab) o;
        return name.equals(kebab.name) &&
                ingredientList.equals(kebab.ingredientList);
    }


    @Override
    public String toString(){
        return "Kebab{" + "name = '" + name + '\'' + ", ingredients: " + ingredientList + '}';
    }
}
