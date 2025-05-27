// Define the interface
interface Playable {
    void play();
}

// Implementing class Guitar
class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Playing the guitar with strumming.");
    }
}

// Implementing class Piano
class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Playing the piano with keys.");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Playable guitar = new Guitar();
        Playable piano = new Piano();

        guitar.play();  // Output: Playing the guitar with strumming.
        piano.play();   // Output: Playing the piano with keys.
    }
}
