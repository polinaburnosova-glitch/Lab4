import java.util.List;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        City zeleniyGorod = new City("Зелёный город", 85);
        City dolina = new City("Долина", 20);
        Dragon realDragon = new Dragon(true, 90);


        Znayka znayka = new Znayka("Знайка", CharacterType.BRAVE, 85, 90);
        Malyshka malyshka = new Malyshka("Малышка", CharacterType.SCARED, 20);
        Zhitely shpuntik = new Zhitely("Шпунтик", CharacterType.TRUSTFUL, 30, "Долина");
        Gvozdik gvozdik = new Gvozdik("Гвоздик", CharacterType.CURIOUS, 60);


        Friend tubik = new Friend("Тюбик", CharacterType.BRAVE, 70);
        Friend guslya = new Friend("Гусля", CharacterType.CURIOUS, 40);
        List<Friend> friendList = Arrays.asList(tubik, guslya);
        System.out.println("Друзей в списке: " + friendList.size());


        System.out.println("ГВОЗДИК:");
        System.out.println(gvozdik.goToGreenCity());
        System.out.println(gvozdik.doAction());
        System.out.println();


        System.out.println("МАЛЫШКА:");
        System.out.println(malyshka.reactToDragon(realDragon));
        System.out.println(malyshka.beSaved());
        System.out.println("В опасности? " + malyshka.isInDanger());
        System.out.println("Напугана? " + malyshka.isScared());
        System.out.println();


        System.out.println("ЖИТЕЛЬ:");
        System.out.println(shpuntik.reactToDragon(realDragon));
        System.out.println(shpuntik.doAction());
        System.out.println("Напуган? " + shpuntik.isScared());
        System.out.println("Попытка пойти в Зелёный город: " + shpuntik.toGoToZeleniyGorod());
        System.out.println("Встреча с незнакомцем: " + shpuntik.meetStranger());
        System.out.println();


        System.out.println("ЗНАЙКА:");
        System.out.println("Принимает решение искать: " + znayka.decideToSearch());
        System.out.println(znayka.getLost());
        System.out.println(znayka.searchForFriends());
        System.out.println(znayka.foundFriends());
        System.out.println(znayka.doAction());
        System.out.println("Статус: потерян? " + znayka.isLost() + ", друзья найдены? " + znayka.isFoundFriends());
        System.out.println();


        System.out.println("ДРУЗЬЯ:");
        System.out.println(guslya.doAction());
        System.out.println(guslya.getFound());

        System.out.println(tubik.doAction());
        System.out.println( tubik.getFound());
        System.out.println();


        System.out.println("ПУТЕШЕСТВИЯ:");
        try {
            System.out.println(znayka.goToCity(zeleniyGorod));
        } catch (TravelException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();


        System.out.println("ОПИСАНИЕ ГОРОДА:");
        System.out.println(zeleniyGorod.description());
        System.out.println();


        Item map = new Item("Карта");
        System.out.println("ПРЕДМЕТ:");
        System.out.println(map.use());
    }
}