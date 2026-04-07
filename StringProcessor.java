import java.util.List;
import java.util.function.*;
 
public class StringProcessor {
 
    /**
     * processStrings:
     *   @param words      - боловсруулах үгсийн жагсаалт
     *   @param predicate  - шүүх нөхцөл  (5-с урт үгс)
     *   @param function   - хувиргах үйл  (урвуулах)
     *   @param consumer   - хэвлэх үйл   (том үсгээр + угтвар)
     */
    public static void processStrings(
            List<String>         words,
            Predicate<String>    predicate,
            Function<String,String> function,
            Consumer<String>     consumer) {
 
        words.stream()
             .filter(predicate)      // 1) Шүү
             .map(function)          // 2) Урвуул
             .forEach(consumer);     // 3) Хэвлэ
    }
}
 