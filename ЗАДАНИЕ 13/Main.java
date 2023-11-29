import java.util.*;

class Department {
    String name;
    String workingHours;

    public Department(String name, String workingHours) {
        this.name = name;
        this.workingHours = workingHours;
    }
}

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Store {
    Map<String, Department> departments;
    Map<String, List<Product>> products;
    Scanner scanner;

    public Store() {
        departments = new HashMap<>();
        products = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void addDepartment(String name, String workingHours) {
        Department department = new Department(name, workingHours);
        departments.put(name, department);
        products.put(name, new ArrayList<>());
        System.out.println("Отдел добавлен: " + name);
    }

    public void removeDepartment(String name) {
        products.remove(name);
        departments.remove(name);
        System.out.println("Отдел удален: " + name);
    }

    private void updateDepartment(String oldName, String newWorkingHours, String newName) {
        Department newDepartment = new Department(newName, newWorkingHours);
        departments.remove(oldName);
        departments.put(newName, newDepartment);

        List<Product> productList = products.get(oldName);
        products.remove(oldName);
        products.put(newName, productList);
    }

    public void editDepartment(String name) {
        Department department = departments.get(name);
        if (department != null) {
            System.out.println("Текущие часы работы отдела " + name + ": " + department.workingHours);
            System.out.print("Введите новые часы работы в формате 00:00-00:00: ");
            String newWorkingHours = scanner.nextLine();

            System.out.println("Текущее название отдела " + name + ": " + department.name);
            System.out.print("Введите новое название отдела: ");
            String newName = scanner.nextLine();

            updateDepartment(name, newWorkingHours, newName);

            System.out.println("Отдел " + newName + " обновлен.");
        } else {
            System.out.println("Отдел с именем " + name + " не найден.");
        }
    }

    public void addProduct(String departmentName, String productName, double price) {
        Product product = new Product(productName, price);
        List<Product> productList = products.get(departmentName);
        productList.add(product);
        System.out.println("Товар добавлен: " + productName);
    }

    public void removeProduct(String departmentName, String productName) {
        List<Product> productList = products.get(departmentName);
        productList.removeIf(product -> product.name.equals(productName));
        System.out.println("Товар удален: " + productName);
    }

    public void editProduct(String departmentName, String productName) {
        List<Product> productList = products.get(departmentName);
        for (Product product : productList) {
            if (product.name.equals(productName)) {
                System.out.println("Текущая цена товара " + productName + ": " + product.price);
                System.out.print("Введите новую цену товара: ");
                double newPrice = scanner.nextDouble();
                product.price = newPrice;

                System.out.println("Текущее название товара " + productName + ": " + product.name);
                System.out.print("Введите новое название товара: ");
                scanner.nextLine(); // consume the newline character
                String newName = scanner.nextLine();
                product.name = newName;

                System.out.println("Товар " + newName + " обновлен.");
                return;
            }
        }
        System.out.println("Товар с именем " + productName + " в отделе " + departmentName + " не найден.");
    }

    public void showProductsInDepartment(String departmentName) {
        List<Product> productList = products.get(departmentName);
        System.out.println("Товары в отделе " + departmentName + ":");
        for (Product product : productList) {
            System.out.println(product.name + " - Цена: " + product.price);
        }
    }

    public void showDepartmentsWithoutProducts() {
        System.out.println("Отделы без товаров:");
        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            if (entry.getValue().isEmpty()) {
                System.out.println(entry.getKey());
            }
        }
    }

    public void showAllDepartments() {
        System.out.println("Все отделы в магазине:");
        for (Map.Entry<String, Department> entry : departments.entrySet()) {
            System.out.println(entry.getKey() + " - Часы работы: " + entry.getValue().workingHours);
        }
    }

    public void showAllProducts() {
        System.out.println("Весь список товаров в магазине:");
        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            for (Product product : entry.getValue()) {
                System.out.println(entry.getKey() + " - " + product.name + " - Цена: " + product.price);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Store store = new Store();

            while (true) {
                System.out.println("1. Добавить отдел");
                System.out.println("2. Удалить отдел");
                System.out.println("3. Редактировать отдел");
                System.out.println("4. Добавить товар");
                System.out.println("5. Удалить товар");
                System.out.println("6. Редактировать товар");
                System.out.println("7. Показать товары в отделе");
                System.out.println("8. Показать отделы без товаров");
                System.out.println("9. Показать все отделы");
                System.out.println("10. Показать весь список товаров");
                System.out.println("11. Выйти");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Введите название отдела: ");
                        String departmentName = scanner.nextLine();
                        System.out.print("Введите часы работы отдела в формате 00:00-00:00: ");
                        String workingHours = scanner.nextLine();
                        store.addDepartment(departmentName, workingHours);
                        break;
                    case 2:
                        System.out.print("Введите название отдела для удаления: ");
                        departmentName = scanner.nextLine();
                        store.removeDepartment(departmentName);
                        break;
                    case 3:
                        System.out.print("Введите название отдела для редактирования: ");
                        departmentName = scanner.nextLine();
                        store.editDepartment(departmentName);
                        break;
                    case 4:
                        System.out.print("Введите название отдела: ");
                        departmentName = scanner.nextLine();
                        System.out.print("Введите название товара: ");
                        String productName = scanner.nextLine();
                        System.out.print("Введите цену товара: ");
                        double price = scanner.nextDouble();
                        store.addProduct(departmentName, productName, price);
                        break;
                    case 5:
                        System.out.print("Введите название отдела: ");
                        departmentName = scanner.nextLine();
                        System.out.print("Введите название товара для удаления: ");
                        productName = scanner.nextLine();
                        store.removeProduct(departmentName, productName);
                        break;
                    case 6:
                        System.out.print("Введите название отдела: ");
                        departmentName = scanner.nextLine();
                        System.out.print("Введите название товара для редактирования: ");
                        productName = scanner.nextLine();
                        store.editProduct(departmentName, productName);
                        break;
                    case 7:
                        System.out.print("Введите название отдела: ");
                        departmentName = scanner.nextLine();
                        store.showProductsInDepartment(departmentName);
                        break;
                    case 8:
                        store.showDepartmentsWithoutProducts();
                        break;
                    case 9:
                        store.showAllDepartments();
                        break;
                    case 10:
                        store.showAllProducts();
                        break;
                    case 11:
                        System.exit(0);
                }
            }
        }
    }
}
