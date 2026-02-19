class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public  class OverridingDemo {
    public static void main(String[] args) {

        // Parent reference, child object
        Animal obj = new Cat();
        obj.sound();   // Calls Cat's method
    }
}
