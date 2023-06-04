import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner scan =new Scanner(System.in);
        //vorod be bakhsh command line
        //yek araye az amaliat ha darim
        amaliat amaliats=new amaliat(scan);
        //vorod be barname
        user_view comshow=new user_view();
        comshow.wellcome();
        amaliats.vorod();

    }
}
