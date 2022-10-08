import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Store {

    private final List<User> user_array_list = new ArrayList<>();
    private final List<Product> productList = new ArrayList<>();
    private static int id = 1;
    private static String currentUser;
    private static int currentId;
    private static Roles currentRoles;

    public Store() {
        User admin = new User(0, "admin", "admin@mail.ru", "89118638485", "admin", Roles.ADMIN);
        this.user_array_list.add(admin);
        productList.add(new Product(1, ProductCategory.TOYS, "doll", "toy doll", new BigDecimal("100")));
        productList.add(new Product(2, ProductCategory.COMPUTERS , "apple", "computer apple", new BigDecimal("10000")));
        productList.add(new Product(3, ProductCategory.FURNITURE, "table", "wooden table", new BigDecimal("500")));
    }


    public boolean authorization(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Авторизация");
        System.out.println("Введите логин или email:");
        try {
            String login_email_user = scanner.nextLine();
            //scanner.nextLine();
            System.out.println("Введите пароль:");
            try {
                String password_user = scanner.nextLine();
                int k = 0;
                for(User user: user_array_list) {
                    if (user.getLogin().equals(login_email_user) || user.getEmail().equals(login_email_user)) {
                        if(user.getPassword().equals(password_user)) {
                            System.out.println("Вы успешно аутентифицировались");
                            currentUser = user.getLogin();
                            currentRoles = user.getRoles();
                            currentId = user.getId();
                            return true;
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("ошибка ввода пароля");
                authorization_and_registration();
                exit(0);
            }
        } catch (Exception e) {
            System.out.println("ошибка ввода логина или email -а ");
            authorization_and_registration();
            exit(0);
        }

        System.out.println("вы ввели не верный логин/email или пароль");
        return false;

    }

    public boolean registration(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Регистрация");
        System.out.println("Введите логин. Он может содержать буквы и цифры, не меньше 1 и не больше 20 символов");
        try {
            String login = scanner.nextLine();
            if (!login.matches("^[а-яА-ЯёЁa-zA-Z0-9]{1,20}$")){
                System.out.println("Вы ввели некорректный логин");
                return false;
            }
            //scanner.nextLine();
            System.out.println("Введите email:");
            String email = scanner.nextLine();
            if (!email.matches("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$")){
                System.out.println("Вы ввели некорректный email");
                return false;
            }
            //scanner.nextLine();
            System.out.println("Введите номер телефона:");
            String phoneNumber = scanner.nextLine();
            if (!phoneNumber.matches("^((\\+7|7|8)+([0-9]){10})$")){
                System.out.println("Вы ввели некорректный номер телефона");
                return false;
            }
            System.out.println("Введите пароль. Он должен быть не менее 8 символов, должен содержать строчные и прописные латинские буквы, цифры, спецсимволы:");
            String password = scanner.nextLine();
            if (!password.matches("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")){
                System.out.println("Вы ввели некорректный пароль");
                return false;
            }
            User new_user = new User(id, login, email, phoneNumber, password, Roles.CLIENT);
            user_array_list.add(new_user);
            id++;
            System.out.println("Вы успешно зарегистрировались в системе");
            return true;

        } catch (Exception e) {
            System.out.println("ошибка ввода");
            authorization_and_registration();
            exit(0);
        }
        return false;


    }

    public void authorization_and_registration(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - зарегистрироваться в системе\n2 - войти в систему\n0 - exit");

        try {
            int operation = scanner.nextInt();
            switch (operation){
                case 1:
                    while (!registration()){
                        System.out.println("Ошибка регистрации");
                    }
                    authorization_and_registration();
                    break;
                case 2:
                    while (!authorization()) {
                        System.out.println("Ошибка авторизации");
                    }

                    if (currentRoles.equals(Roles.CLIENT)) {
                        System.out.println("Добро пожаловать в магазин! в качестве пользователя " + currentUser);
                        clientInterface();
                    } else if (currentRoles.equals(Roles.ADMIN)) {
                        System.out.println("Добро пожаловать в магазин! в качестве аминистратора " + currentUser);
                        adminInterface();
                        if (currentRoles.equals(Roles.CLIENT)) {
                            clientInterface();
                        }
                    }
                    break;
                case 0:
                    exit(0);
                    break;
                default:
                    System.out.println("ведите корректное название операции");
                    authorization_and_registration();
            }
        } catch (Exception e) {
            System.out.println("введите корректное наименование операции");
            authorization_and_registration();
            exit(0);
        }
    }
    public void clientInterface(){
        while (true) {
            System.out.println("Вам доступны следующие операции: \n1 - просмотр товаров, которые вы можете купить в нашем магазине\n2 - вернуться в начало\n0 - exit");
            try {
                Scanner scanner = new Scanner(System.in);
                int operation = scanner.nextInt();
                switch (operation) {
                    case 1:
                        lookAtProduct();
                        break;
                    case 2:
                        authorization_and_registration();
                        break;
                    case 0:
                        exit(0);
                        break;
                }
            } catch (Exception e) {
                System.out.println("некорректый ввод операции");
                clientInterface();
            }
        }
    }
    public void adminInterface() {
        Scanner scanner = new Scanner(System.in);
        //boolean flag = false;
        while (currentRoles.equals(Roles.ADMIN)) {
            System.out.println("Вам доступны следующие операции: \n1 - просмотр всех клиентов" +
                    "\n2 - изменение роли клиентов\n3 - просмотр товаров\n4 - добавление товара\n5 - удаление товара\n0 - exit");
            try {
                int operation = scanner.nextInt();
                switch (operation) {
                    case 1:
                        lookAtClients(Roles.ADMIN);
                        break;
                    case 2:
                        System.out.println("Введите id клиента, которому хотите сменить роль: ");
                        try {
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            try {
                                System.out.println("Введите роль на которую хотите сменить текущую:");
                                String role = scanner.nextLine();
                                Roles currentRole = null;
                                for (Roles roles: Roles.values()) {
                                    if (role.equals(roles.toString())) {
                                        currentRole = roles;
                                    }
                                }
                                if (currentRole == null) {
                                    throw new Exception("такой роли не существует");
                                } else {
                                    changeClientsRole(currentRoles, id, currentRole);
                                    if (id == currentId) {
                                        currentRoles = currentRole;
                                    }
                                }

                            } catch (Exception e) {
                                System.out.println("вы ввели некорректную роль");
                                adminInterface();
                            }

                        } catch (Exception e) {
                            System.out.println("вы ввели некорректный id");
                            adminInterface();
                        }

                        break;
                    case 3:
                        lookAtProduct();
                        break;
                    case 4:
                        addProduct();
                        break;
                    case 5:
                        delProduct();
                        break;
                    case 0:
                        exit(0);
                        break;
                    default:
                        System.out.println("операции под введенным номером не существует");
                }
            } catch (Exception e){
                System.out.println("вы ввели некорректное значение");
                adminInterface();
            }

        }
    }
    void lookAtClients(Roles role) {
        if (role.equals(Roles.ADMIN)) {
            for (User user: user_array_list) {
                System.out.println(user.getId()+ " " + user.getLogin() + " " + user.getEmail() + " " + user.getPhoneNumber() + " " + user.getRoles());
            }
        }

    }
    void changeClientsRole(Roles role, int id, Roles changeRole) {
        int k = 0;
        if (role.equals(Roles.ADMIN)) {
            for (User user_change: user_array_list) {
                if(user_change.getId() == id) {
                    user_change.setRoles(changeRole);
                    lookAtClients(Roles.ADMIN);
                    k++;
                }
            }
        } else if (role.equals(Roles.CLIENT)) {
            System.out.println("У вас нет прав не измение ролей");
            adminInterface();
            exit(0);
        }
        if (k == 0) {
            System.out.println("Клинта с таким id в системе не за регистрировано");
        }
    }
    public void lookAtProduct() {
        System.out.println("Доступные товары магазина: ");
        for (Product product: productList){
            System.out.println(product.getId() + " " + product.getProductCategory() + " " + product.getNameOfProduct() + " " + product.getDescriptionOfProduct() + " " + product.getPrice());
        }
    }
    public void delProduct(){
        Product delProduct = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id товара: ");
        try {
            int id = scanner.nextInt();
            for (Product product: productList) {
                if(product.getId() == id) {
                    delProduct = product;
                }
            }
            if (delProduct != null) {
                productList.remove(delProduct);
            } else {
                System.out.println("Продукта с таким id не существует");
            }

        } catch (Exception e){
            System.out.println("Такого id не существует");
            delProduct();
        }

    }
    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите категорию товара: ");
        for (ProductCategory productCategory: ProductCategory.values()) {
            System.out.println(productCategory);
        }
        try {
            String category = scanner.nextLine();
            int k = 0;
            ProductCategory currentCategory = null;
            for (ProductCategory productCategory: ProductCategory.values()) {
                if (category.equals(productCategory.toString())) {
                    k++;
                    currentCategory = productCategory;
                }
            }
            if (k == 1) {
                try {
                    System.out.println("Введите наименование товара: ");
                    String nameOfProduct = scanner.nextLine();
                    if (!nameOfProduct.matches("^[а-яА-ЯёЁa-zA-Z0-9]{1,20}$")){
                        throw new Exception("Некорректное наименование товара");
                    }
                    try {
                        System.out.println("Введите описание товара: ");
                        String descriptionOfProduct = scanner.nextLine();
                        try {
                            System.out.println("Введите стоимость товара");
                            String price = scanner.nextLine();
                            if (!price.matches("^[0-9]{1,30}$")){
                                throw new Exception("Некорректная стоимость товара");
                            }
                            int newId =  productList.get(productList.size()-1).getId() + 1;
                            productList.add(new Product(newId, currentCategory, nameOfProduct, descriptionOfProduct, new BigDecimal(price)));
                        } catch (Exception e) {
                            System.out.println("Некорректный ввод стоимости товара");
                            addProduct();
                        }
                    } catch (Exception e) {
                        System.out.println("Некорректное писание товара");
                        addProduct();
                    }
                } catch (Exception e){
                    System.out.println("Некорректное наименование товара");
                    addProduct();
                }
            } else {
                throw new Exception("Такой категории не существует");
            }
        } catch (Exception e) {
            System.out.println("Такой категории не существует");
            addProduct();
        }


    }

}
