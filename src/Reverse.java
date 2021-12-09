import java.util.ArrayList;

public class Reverse {

    static ArrayList<String> plates = new ArrayList<String>();
    static ArrayList<String> plates2 = new ArrayList<String>();

    static boolean _DEBUG = true;


    static void generator(int n, String letters, String prefix, boolean first) {
        if (prefix.length() == n) {
            if(first) plates.add(prefix);
            else {
                plates.forEach((plate) -> {
//                    plates2.add(plate + " " + prefix);
                    plates2.add(prefix + " " + plate);

                    if(_DEBUG)  System.out.println(prefix + " " + plate);
                });
            }
        } else {
            for (int i = 0; i < letters.length(); i++) {
                generator(n, letters, prefix + letters.charAt(i), first);
            }
        }
    }


    public static void main(String[] args) {

        generator(3, "0123456789", "",true);
        plates2 = (ArrayList<String>) plates.clone();

        generator(3, "abcdefghijklmnopqrstuvwxyz".toUpperCase(), "", false);
        System.out.println(plates2.size());
    }
}
