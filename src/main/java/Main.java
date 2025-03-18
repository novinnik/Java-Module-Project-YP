import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("24 часа Ле-мана");

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            int numberAuto = i + 1;

            String nameAuto;

            while (true) {
                System.out.println(" - Введите наименование авто №" + numberAuto);
                String nameStr = scanner.next();
                if (!nameStr.isEmpty()) {
                    nameAuto = nameStr;
                    break;
                }
            }

            int speedAuto;

            while (true) {
                System.out.println(" - Введите скорость авто (1-250) №" + numberAuto);

                if (scanner.hasNextInt()){
                    speedAuto = scanner.nextInt();
                    if (speedAuto > 0 && speedAuto <= 250) {
                        break;
                    } else {
                        System.out.println("Указана скорость в неверном диапазоне (1-250)!");
                    }
                } else {
                    scanner.next();
                    System.out.println("Значение скорости должно быть цифровым!");
                }
            }
            Car car = new Car(nameAuto, speedAuto);

            Race.leader(car);
        }
        scanner.close();
        System.out.println("Самая быстрая машина в гонке: " + Race.getName());
    }

}

class Car {
    String name;
    int speed = 0;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}

class Race {
    static String name = "";
    static int distance = 0;

    public static void leader(Car newCar) {
        int newDistance = 24 * newCar.speed;
        if (distance < newDistance) {
            distance = newDistance;
            name = newCar.name;
        } else if (distance == newDistance){
            name = name + "; " + newCar.name;
        }
        //System.out.println("Лидер в гонке: " + name);
    }

    public static String getName() {
        return name;
    }
}
