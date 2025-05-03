
interface Employee {

    double hourlyRate = 5.5;
    double getSalary();
}

class Manager implements Employee{
    String name;
    String surname;
    int workedDays;
    final int numOfHours = 10;

    public Manager() {
        this.name = "";
        this.surname = "";
        this.workedDays = 0;
    }

    public Manager(String name, String surname, int workedDays) {
        this.name = name;
        this.surname = surname;
        this.workedDays = workedDays;
    }

    @Override
    public double getSalary(){
        return workedDays * hourlyRate * numOfHours;
    }

    public static void showManagers(Manager[] managers){
        System.out.println("The managers are");
        for (Manager i : managers)
            System.out.println("Nume: " + i.name + ", Prenume: " + i.surname + ", Days worked: " + i.workedDays + ", Salary : " + i.getSalary());
    }

}

class Cashier implements Employee{

    String name;
    String surname;
    int numOfHours;

    public Cashier() {
        this.name = "";
        this.surname = "";
        this.numOfHours = 0;
    }

    public Cashier(String name, String surname, int numOfHours) {
        this.name = name;
        this.surname = surname;
        this.numOfHours = numOfHours;
    }

    @Override
    public double getSalary(){
        return numOfHours * hourlyRate;
    }

    public static void showCashier(Cashier[] cashiers){
        System.out.println("The cashiers are");
        for (Cashier i : cashiers)
            System.out.println("Nume: " + i.name + ", Prenume: " + i.surname + ", Hours worked: " + i.numOfHours + ", Salary : " + i.getSalary());
    }
}

public class Ex5 {
    public static void main(String[] args) {

        Cashier cashier1 = new Cashier("Ion", "Pop", 15);
        Cashier cashier2 = new Cashier("Valeriu", "Grigore", 10);
        Cashier cashier3 = new Cashier("Eugen", "Ghenadie", 12);
        Cashier cashier4 = new Cashier("Dumitru", "Ghita", 25);

        Cashier[] cashiers = {cashier1, cashier2, cashier3, cashier4};

        Cashier.showCashier(cashiers);

        Manager manager1 = new Manager("Ion", "Pop", 15);
        Manager manager2 = new Manager("Valeriu", "Grigore", 10);
        Manager manager3 = new Manager("Eugen", "Ghenadie", 12);
        Manager manager4 = new Manager("Dumitru", "Ghita", 25);

        Manager[] managers = {manager1, manager2, manager3, manager4};

        Manager.showManagers(managers);


    }
}