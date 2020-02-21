/**
 * @Time: 19-10-13上午10:22
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
class Movie {
    String title;
    String genre;
    int rating;

    void playIt(){
        System.out.println("Playing the movie");
        System.out.println(5.0/2);
    }
}


public class MovieTestDrive{
    public static void main(String[] args) {
        Movie one = new Movie();
        one.title = "Gone with the Stock";
        one.genre = "Tragic";
        one.rating = -2;

        Movie two = new Movie();
        two.title = "Lost in Cubicle Space";
        two.genre = "Comedy";
        two.rating = -5;
        two.playIt();

        Movie three = new Movie();
        three.title = "Byte Club";
        three.genre = "Tragic but ultimately uplifiting";
        three.rating = 127;


    }
}

