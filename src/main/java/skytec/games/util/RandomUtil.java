package skytec.games.util;

import java.util.Random;

public class RandomUtil {
    public static int randomRange(int min, int max){
        return (int) ((Math.random() * (max-min) + min));
    }
    public static boolean randomBoolean(){
        return (new Random()).nextBoolean();
    }
}
