import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CODEWARS{
    public static void main(String[] args) {
        List<String> contacts = Arrays.asList("jones", "thompson", "brown", "taylor", "bow", "smith", "cox", "timmons");
        String keystrokes = "2";
        List<String> predictions = CODEWARS.predict(contacts, keystrokes);
        System.out.println("Predictions for keystrokes '" + keystrokes + "':");
        for (String prediction : predictions) {
            System.out.println(prediction);
        }
        keystrokes = "269";
        predictions = CODEWARS.predict(contacts, keystrokes);
        System.out.println("Predictions for keystrokes '" + keystrokes + "':");
        for (String prediction : predictions) {
            System.out.println(prediction);
        }
        keystrokes = "234567892345";
        predictions = CODEWARS.predict(contacts, keystrokes);
        System.out.println("Predictions for keystrokes '" + keystrokes + "':");
        for (String prediction : predictions) {
            System.out.println(prediction);
        }
    }
    public static List<String> predict(List<String> contacts, String keystrokes) {
        List<String> predictions = new ArrayList<>();

        for (String contact : contacts) {
            if (isPredictionMatch(contact, keystrokes)) {
                predictions.add(contact);
            }
        }
        return predictions;
    }
    private static boolean isPredictionMatch(String contact, String keystrokes) {
        if (keystrokes.length() == 0) {
            return true; // Если нажатий нет, считаем, что предсказание соответствует всем контактам
        }
        String[] groups = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        int currentIndex = 0;
        for (char keystroke : keystrokes.toCharArray()) {
            int groupIndex = Character.getNumericValue(keystroke);

            if (groupIndex < 0 || groupIndex >= groups.length) {
                return false; // Если введенный символ не соответствует допустимым нажатиям на клавишах
            }
            String group = groups[groupIndex];
            // Проверяем, совпадает ли символ контакта с символом группы нажатия
            if (currentIndex >= contact.length() || group.indexOf(contact.charAt(currentIndex)) == -1) {
                return false;
            }
            currentIndex++;
        }
        return currentIndex <= contact.length();
    }
}