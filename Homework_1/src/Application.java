public class Application {

    public static void main(String[] args) {

        Kotik kitty = new Kotik("Daisy", 3, "Meowh");
        kitty.liveAnotherDay();
        System.out.println("\nKitty's name: " + kitty.getName());

        Kotik cat = new Kotik();
        cat.setName("Tom");
        cat.setWeight(2);
        cat.setMeow("Meow");
        cat.setHungerLevel(5);

        //   cat.liveAnotherDay();
        //   System.out.println("Cat's name: " + cat.getName());

        System.out.println("---------------------------------------");

        /**
         * Compare  cats' meowing
         */

        if (kitty.getMeow().equals(cat.getMeow())) {
            System.out.println("Cats meow the same");
        } else {
            System.out.println("Cats meow differently");
        }

        System.out.println("---------------------------------------");

        /**
         * Counting number of Cats
         */

        System.out.println("Number of cats created: " + Kotik.getCatCount());
    }
}
