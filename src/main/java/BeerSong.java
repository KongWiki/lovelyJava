/**
 * @Time: 19-10-13上午9:20
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BeerSong {
    public static void main(String[] args) {
        int beerNum = 99;
        String word = "bottles";

        while(beerNum > 0){
            if(beerNum == 1){
                word = "bottle";
            }
            System.out.println(beerNum + " " + word + " of beer on the wall");
            System.out.println(beerNum + " " + word + " of beer.");
            System.out.println("Take on down,");
            System.out.println("pass it arount.");
            beerNum -= 1;

            if(beerNum > 1){
                System.out.println(beerNum + " " + word + "of beer on the wall");
            }else{
                System.out.println("No more bottles of ber on the wall");

            }
        }
    }
}
