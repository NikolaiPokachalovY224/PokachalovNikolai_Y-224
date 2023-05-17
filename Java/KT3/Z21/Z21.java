import java.util.HashMap;
import java.util.Map;
public class Z21 {
    private Map<Character, Character> keypadMapping;
    public Z21() {
        keypadMapping = createKeypadMapping();
    }
    private Map<Character, Character> createKeypadMapping() {
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put('1', '7');
        mapping.put('2', '8');
        mapping.put('3', '9');
        mapping.put('4', '4');
        mapping.put('5', '5');
        mapping.put('6', '6');
        mapping.put('7', '1');
        mapping.put('8', '2');
        mapping.put('9', '3');
        mapping.put('0', '0');
        return mapping;
    }
    public String convertToPhoneKeypad(String input) {
        StringBuilder convertedInput = new StringBuilder();
        for (char digit : input.toCharArray()) {
            if (keypadMapping.containsKey(digit)) {
                convertedInput.append(keypadMapping.get(digit));
            }
        }
        return convertedInput.toString();
    }
}
