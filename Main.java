public class Main {
    public static void main(String[] args) {
        Account a1 = new Account("001","Saud", 10000);
        Account a2 = new Account("002", "Mohammed");

        System.out.println(a1.toString());
        System.out.println(a2.toString());

        a1.transferTo(a2,1000);

        System.out.println(a1.toString());
        System.out.println(a2.toString());

        Employee e1 = new Employee("011","Sam", 10000);
        System.out.println(e1.toString());
        e1.raisedSalary(33);
        System.out.println(e1.toString());
    }
}