
interface Player{

    void play();
}

class Footballer implements Player{

    @Override
    public void play() {
        System.out.println("I play football");
    }
}

class BasketballPlayer implements Player{

    @Override
    public void play() {
        System.out.println("I play basket");
    }
}

class VolleyballPlayer implements Player{

    @Override
    public void play() {
        System.out.println("I play volley");
    }
}

public class Ex2 {
    public static void main(String[] args) {
        Footballer football = new Footballer();
        BasketballPlayer basket = new BasketballPlayer();
        VolleyballPlayer volley = new VolleyballPlayer();

        football.play();
        basket.play();
        volley.play();
    }
}

