interface Icecream {
     String makeIceCream();
}
class VanillaIceCream implements Icecream {
    public String makeIceCream() {
        return "VanillaIceCream";
    }
}
abstract class IcecreamDecorator implements Icecream {
    Icecream icecream;
    IcecreamDecorator(Icecream icecream) {
        this.icecream = icecream;
    }
    public String makeIceCream() {
        return icecream.makeIceCream();
    }
}
 
class ChocoIcecreamDecorator extends IcecreamDecorator {
    ChocoIcecreamDecorator(Icecream icecream) {
        super(icecream);
    }
    public String makeIceCream() {
        return icecream.makeIceCream() + " Choco chips";
    }
}

class CrunchIcecreamDecorator extends IcecreamDecorator {
    CrunchIcecreamDecorator(Icecream icecream) {
        super(icecream);
    }
    public String makeIceCream() {
        return icecream.makeIceCream() + " crunch";
    }
}

class Main {
    public static void main(String args[]) {
        Icecream vanilla = new VanillaIceCream();
        System.out.println(vanilla.makeIceCream());
        Icecream choco = new ChocoIcecreamDecorator(vanilla);
        System.out.println(choco.makeIceCream());
        Icecream crunch = new CrunchIcecreamDecorator(choco);
        System.out.println(crunch.makeIceCream());
    }
}
