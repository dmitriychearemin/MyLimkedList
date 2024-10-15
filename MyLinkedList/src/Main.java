import Classes.MyList;

public class Main {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.add("dfghfgh");
        list.add("fdghfd");
        list.add("dfghfdgh");
        list.add(3,"aaaa");

        System.out.println("-----------------------");
        System.out.println("Ваш лист");
        for (var value : list) {
            System.out.println(value);
        }
        System.out.println("-----------------------");

        System.out.println("-----------------------");
        System.out.println("Удалён - " + list.remove(1));
        System.out.println("-----------------------");

        System.out.println("-----------------------");
        System.out.println("Лист после удаления");
        for (var value : list) {
            System.out.println(value);
        }
        System.out.println("-----------------------");

        System.out.println("Элемент найден - " + list.get(1));
    }
}


