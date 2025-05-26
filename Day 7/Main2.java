class TiffinBox {
     private Object meal;
     public void setMeal(Object meal) {
          this.meal = meal;
     }
     public Object getMeal() {
          return this.meal;
     }
}

class VegMeal {
     public String toString() {
          return "Veg Meal!";
     }
}

class NonVegMeal {
     public String toString() {
          return "Non-Veg Meal!";
     }
}

public class Main2 {
     public static void main(String[] args) {
          TiffinBox t = new TiffinBox();
          VegMeal vm = new VegMeal();
          t.setMeal(vm);
          NonVegMeal nvm = (NonVegMeal)t.getMeal(); // Not possible to typecast
          System.out.println(nvm);
     }
}