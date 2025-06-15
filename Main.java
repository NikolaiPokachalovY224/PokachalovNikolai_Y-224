import java.io.*;
import java.util.*;
import java.util.regex.*;

class ExitException extends RuntimeException {}

class CalculatorModel {
    private final List<String> history = new ArrayList<>();
    private static final String HISTORY_FILE_NAME = "calculator_history.log";

    public CalculatorModel() {
        loadHistory();
    }

    public double calculate(String expression) throws Exception {
        expression = expression.replace(',', '.')
                              .replace("^", "**")
                              .replaceAll("\\s+", "");
        
        if (expression.isEmpty()) {
            throw new Exception("Введено пустое выражение.");
        }

        double result = evaluateExpression(expression);
        history.add(expression + " = " + result);
        saveHistory();
        return result;
    }

    private double evaluateExpression(String expression) throws Exception {
        Pattern parenthesisPattern = Pattern.compile("\\(([^()]*?)\\)");
        Matcher m = parenthesisPattern.matcher(expression);

        while (m.find()) {
            String subExp = m.group(1);
            
            if (subExp.isEmpty()) {
                throw new Exception("Пустые скобки.");
            }

            double subResult = evaluateExpression(subExp);
            expression = expression.replace(m.group(0), String.valueOf(subResult));
            m = parenthesisPattern.matcher(expression);
        }

        return evaluateWithoutBrackets(expression);
    }

    private double evaluateWithoutBrackets(String expression) throws Exception {
        List<String> tokens = tokenizeExpression(expression);
        
        tokens = processUnaryOperators(tokens);
        
        if (tokens.isEmpty()) {
            throw new Exception("Пустое выражение после обработки.");
        }
        
        for (int i = tokens.size() - 1; i >= 0; i--) {
            if ("**".equals(tokens.get(i))) {
                if (i == 0 || i == tokens.size() - 1 || 
                    !isNumber(tokens.get(i-1)) || !isNumber(tokens.get(i+1))) {
                    throw new Exception("Неверное выражение для возведения в степень: " + 
                                        (i > 0 ? tokens.get(i-1) : "") + "**" + 
                                        (i < tokens.size() - 1 ? tokens.get(i+1) : ""));
                }
                double left = Double.parseDouble(tokens.get(i-1));
                double right = Double.parseDouble(tokens.get(i+1));
                double result = Math.pow(left, right);
                tokens.set(i-1, String.valueOf(result));
                tokens.remove(i);
                tokens.remove(i);
                i--;
            }
        }
        
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            if ("*".equals(token) || "/".equals(token) || "%".equals(token) || "//".equals(token)) {
                if (i == 0 || i == tokens.size() - 1 || 
                    !isNumber(tokens.get(i-1)) || !isNumber(tokens.get(i+1))) {
                    throw new Exception("Неверное выражение для операции '" + token + "': " +
                                        (i > 0 ? tokens.get(i-1) : "") + token +
                                        (i < tokens.size() - 1 ? tokens.get(i+1) : ""));
                }
                double left = Double.parseDouble(tokens.get(i-1));
                double right = Double.parseDouble(tokens.get(i+1));
                
                if (right == 0 && ("/".equals(token) || "//".equals(token) || "%".equals(token))) {
                    throw new ArithmeticException("Деление на ноль");
                }
                
                double result = 0;
                switch (token) {
                    case "*": result = left * right; break;
                    case "/": result = left / right; break;
                    case "//": result = Math.floor(left / right); break;
                    case "%": result = left % right; break;
                }
                
                tokens.set(i-1, String.valueOf(result));
                tokens.remove(i);
                tokens.remove(i);
                i--;
            }
        }
        
        if (tokens.isEmpty()) {
            throw new Exception("Пустое или некорректное выражение после всех операций.");
        }
        
        if (!isNumber(tokens.get(0))) {
             throw new Exception("Неверное начало выражения: " + tokens.get(0) + ". Ожидалось число.");
        }

        double result = Double.parseDouble(tokens.get(0));
        for (int i = 1; i < tokens.size(); i += 2) {
            if (i + 1 >= tokens.size()) {
                throw new Exception("Незавершенное выражение после оператора: " + tokens.get(i));
            }
            
            String op = tokens.get(i);
            String nextToken = tokens.get(i+1);

            if (!isNumber(nextToken)) {
                 throw new Exception("Неверный операнд после оператора '" + op + "': " + nextToken);
            }
            
            double num = Double.parseDouble(nextToken);

            if ("+".equals(op)) result += num;
            else if ("-".equals(op)) result -= num;
            else {
                throw new Exception("Неизвестный или неправильно расположенный оператор: " + op);
            }
        }
        
        return result;
    }

    private List<String> tokenizeExpression(String expression) throws Exception {
        List<String> tokens = new ArrayList<>();
        Matcher m = Pattern.compile("(\\d+(?:\\.\\d+)?|\\.\\d+|\\*\\*|//|[+\\-*/%])").matcher(expression);
        int lastMatchEnd = 0;
        while (m.find()) {
            if (m.start() > lastMatchEnd) {
                throw new Exception("Неизвестные символы или неверный формат выражения: " + expression.substring(lastMatchEnd, m.start()));
            }
            tokens.add(m.group());
            lastMatchEnd = m.end();
        }
        if (lastMatchEnd < expression.length()) {
            throw new Exception("Неизвестные символы или неверный формат выражения: " + expression.substring(lastMatchEnd));
        }
        return tokens;
    }

    private List<String> processUnaryOperators(List<String> tokens) throws Exception {
        List<String> processed = new ArrayList<>();
        double currentSign = 1.0; 

        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);

            boolean isUnaryContext = (i == 0 || isOperator(tokens.get(i-1)));

            if ("+".equals(token) && isUnaryContext) {
                continue; 
            } else if ("-".equals(token) && isUnaryContext) {
                currentSign *= -1.0;
                continue; 
            }
            
            if (isNumber(token)) {
                double num = Double.parseDouble(token);
                processed.add(String.valueOf(num * currentSign));
                currentSign = 1.0; 
            } else {
                processed.add(token);
                currentSign = 1.0; 
            }
        }
        
        if (currentSign != 1.0) {
             throw new Exception("Неверное выражение: унарный оператор в конце выражения.");
        }
        
        return processed;
    }

    private boolean isOperator(String token) {
        return token.matches("[+\\-*/%]|\\*\\*|//");
    }

    private boolean isNumber(String token) {
        return token.matches("-?\\d+(?:\\.\\d+)?(?:[eE][+\\-]?\\d+)?|\\.\\d+");
    }

    public List<String> getHistory() {
        return new ArrayList<>(history);
    }

    public void saveSelectedEquations(List<Integer> indices, String userInput) {
        List<String> selected = new ArrayList<>();
        for (int i : indices) {
            if (i >= 0 && i < history.size()) {
                selected.add(history.get(i));
            } else {
                System.out.println("Предупреждение: Индекс " + i + " вне диапазона истории и будет проигнорирован.");
            }
        }
        if (!selected.isEmpty()) {
            saveToFile(selected, getExportFile(userInput, "selected_equations.log"), true);
        } else {
            System.out.println("Нет уравнений для сохранения.");
        }
    }

    public void exportHistory(String userInput) {
        if (!history.isEmpty()) {
            saveToFile(history, getExportFile(userInput, "full_history.log"), true);
        } else {
            System.out.println("История пуста, нечего экспортировать.");
        }
    }

    private File getExportFile(String userInput, String defaultFileName) {
        if (userInput == null || userInput.isEmpty()) {
            return new File(defaultFileName);
        }
        
        File file = new File(userInput);
        if (file.isDirectory()) {
            return new File(file, defaultFileName);
        }
        
        if (!userInput.contains(".")) {
            return new File(userInput + ".log");
        }
        
        return file;
    }

    private void saveToFile(List<String> data, File file, boolean append) {
        try {
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                if (!parentDir.mkdirs()) {
                    System.out.println("Ошибка: Не удалось создать директории для пути: " + parentDir.getAbsolutePath());
                    return;
                }
            }
            
            try (PrintWriter writer = new PrintWriter(new FileWriter(file, append))) {
                for (String item : data) {
                    writer.println(item);
                }
                System.out.println("Файл успешно сохранен/дополнен: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Ошибка сохранения: " + e.getMessage());
            System.out.println("Рекомендуется указать другой путь или имя файла.");
        }
    }

    private void loadHistory() {
        File file = new File(HISTORY_FILE_NAME);
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    history.add(scanner.nextLine());
                }
            } catch (IOException e) {
                System.out.println("Ошибка загрузки истории: " + e.getMessage());
            }
        }
    }

    private void saveHistory() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(new File(HISTORY_FILE_NAME), false))) { 
            for (String item : history) {
                writer.println(item);
            }
        } catch (IOException e) {
            System.out.println("Ошибка сохранения истории: " + e.getMessage());
        }
    }
}

class CalculatorView {
    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("\nМеню калькулятора:");
        System.out.println("1. Вычислить выражение");
        System.out.println("2. Просмотреть историю");
        System.out.println("3. Экспортировать всю историю");
        System.out.println("4. Сохранить выбранные уравнения");
        System.out.println("5. Выход");
        System.out.print("Выберите действие (1-5): ");
    }

    public int getMenuChoice() {
        try {
            String input = scanner.nextLine().trim();
            
            if (input.matches("[1-5]")) {
                return Integer.parseInt(input);
            }
            
            if (input.matches(".*[+\\-*/^().,].*") || 
                (input.matches(".*\\d.*") && input.length() > 1)) {
                System.out.println("\nОшибка: Вы ввели математическое выражение вместо выбора пункта меню.");
                System.out.println("Пожалуйста, сначала выберите пункт 1 для вычисления выражений.");
                return -1;
            }
            
            try {
                int choice = Integer.parseInt(input);
                if (choice < 1 || choice > 5) {
                    System.out.println("Ошибка: Введите число от 1 до 5.");
                    return -2;
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Неверный формат ввода. Пожалуйста, введите число от 1 до 5.");
                return -2;
            }
        } catch (NoSuchElementException e) {
            throw new ExitException();
        }
    }

    public String getExpression() {
        try {
            System.out.print("Введите выражение: ");
            return scanner.nextLine().trim();
        } catch (NoSuchElementException e) {
            throw new ExitException();
        }
    }

    public void showResult(double result) {
        System.out.println("Результат: " + result);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showHistory(List<String> history) {
        if (history.isEmpty()) {
            System.out.println("История пуста.");
            return;
        }
        System.out.println("\nИстория вычислений:");
        for (int i = 0; i < history.size(); i++) {
            System.out.println(i + ": " + history.get(i));
        }
    }

    public String getExportPath() {
        try {
            System.out.print("Введите путь для экспорта (оставьте пустым для значения по умолчанию): ");
            return scanner.nextLine().trim();
        } catch (NoSuchElementException e) {
            throw new ExitException();
        }
    }

    public List<Integer> getSelectedIndices() {
        try {
            System.out.print("Введите номера уравнений через пробел (например, 0 2 5): ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Ошибка: Не введены номера уравнений.");
                return Collections.emptyList();
            }
            
            String[] tokens = input.split("\\s+");
            List<Integer> indices = new ArrayList<>();
            List<String> invalidInputs = new ArrayList<>();
            
            for (String token : tokens) {
                try {
                    int index = Integer.parseInt(token);
                    indices.add(index);
                } catch (NumberFormatException e) {
                    invalidInputs.add(token);
                }
            }
            
            if (!invalidInputs.isEmpty()) {
                System.out.println("Предупреждение: Следующие введенные значения не являются числами и будут проигнорированы: " + String.join(", ", invalidInputs));
            }
            
            return indices;
        } catch (NoSuchElementException e) {
            throw new ExitException();
        }
    }
}

class CalculatorController {
    private final CalculatorModel model;
    private final CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        try {
            while (true) {
                try {
                    view.displayMenu();
                    int choice = view.getMenuChoice();

                    if (choice == -1 || choice == -2) {
                        continue; 
                    }

                    switch (choice) {
                        case 1:
                            calculateExpression();
                            break;
                        case 2:
                            view.showHistory(model.getHistory());
                            break;
                        case 3:
                            model.exportHistory(view.getExportPath());
                            break;
                        case 4:
                            view.showHistory(model.getHistory());
                            List<Integer> indices = view.getSelectedIndices();
                            if (!indices.isEmpty()) {
                                model.saveSelectedEquations(indices, view.getExportPath());
                            } else {
                                view.showMessage("Не выбрано ни одного уравнения для сохранения.");
                            }
                            break;
                        case 5:
                            view.showMessage("\nЗавершение работы программы...");
                            return;
                        default:
                            view.showMessage("Неверный выбор меню.");
                    }
                } catch (ExitException e) {
                    view.showMessage("\nЗавершение работы программы...");
                    return;
                } catch (Exception e) {
                    view.showMessage("Произошла неожиданная ошибка: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            view.showMessage("Критическая ошибка приложения: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void calculateExpression() {
        try {
            String expression = view.getExpression();
            double result = model.calculate(expression);
            view.showResult(result);
        } catch (ArithmeticException e) {
            view.showMessage("Математическая ошибка: " + e.getMessage());
        } catch (Exception e) {
            view.showMessage("Ошибка вычисления: " + e.getMessage());
            view.showMessage("Проверьте правильность введенного выражения.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);
        controller.run();
    }
}