class TiffinBox<T> {
     private T meal;
     public void setMeal(T meal) {
          this.meal = meal;
     }
     public T getMeal() {
          return meal;
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

public class Main3 {
     public static void main(String[] args) {
          TiffinBox<VegMeal> tiffin1 = new TiffinBox<>();
          tiffin1.setMeal(new VegMeal());
          System.out.println(tiffin1.getMeal());

          TiffinBox<NonVegMeal> tiffin2 = new TiffinBox<>();
          tiffin2.setMeal(new NonVegMeal());
          System.out.println(tiffin2.getMeal());
     }
}

// Use of Generic Class