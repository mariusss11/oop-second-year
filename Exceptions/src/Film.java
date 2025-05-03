import java.util.Scanner;

class Film {
    private String titlu;
    private int durata;
    private int rating;

    public Film(String titlu, int durata, int rating) {
        this.titlu = titlu;
        this.durata = durata;
        setRating(rating);
    }

    public void setRating(int nouRating) {
        if (nouRating < 1 || nouRating > 5) {
            throw new IllegalArgumentException("Rating-ul trebuie sa fie intre 1 si 5.");
        }
        this.rating = nouRating;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Film film = null;
        try {
            String titlu = scanner.nextLine();
            int durata = scanner.nextInt();
            int rating = scanner.nextInt();

            film = new Film(titlu, durata, rating);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
