interface Food{
   void foodEating();
}
class Coco implements Food {
    @Override
    public void foodEating() {
        System.out.println("This is coco");
    }
}
class Maza implements Food {
    @Override
    public void foodEating() {
        System.out.println("This is maza");
    }
}

class Frooti implements Food {
    @Override
    public void foodEating() {
        System.out.println("This is frooti");
    }
}

class Gaurav {
    private Food _food;
    Gaurav(Food temp) {
        _food = temp;
    }
    public void exe() {
        _food.foodEating();
    }
}

public class Main {
    public static void main(String[] args) {
        Gaurav _gaurav = new Gaurav(new Frooti());
        _gaurav.exe();
}
}
