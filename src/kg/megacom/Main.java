package kg.megacom;

import kg.megacom.enums.PhoneColor;
import kg.megacom.enums.PhoneType;
import kg.megacom.models.Gift;
import kg.megacom.models.Phone;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println("FLatMap Method ");
        Stream<Phone> phoneOfStream = Stream.of(
                new Phone( PhoneType.IPHONE_X, PhoneColor.BLACK,43000),
                new Phone(PhoneType.IPHONE_XS,PhoneColor.BLUE,51000),
                new Phone(PhoneType.IPHONE_XS_MAX,PhoneColor.GOLD,65000),
                new Phone(PhoneType.IPHONE_S,PhoneColor.GREEN,30000),
                new Phone(PhoneType.SAMSUNG_S10,PhoneColor.WHITE,35000),
                new Phone(PhoneType.SAMSUNG_S10ULTRA,PhoneColor.BLACK,46000),
                new Phone(PhoneType.SAMSUNG_S20EDGE,PhoneColor.GOLD,62000),
                new Phone(PhoneType.SAMSUNG_S20ULTRA,PhoneColor.SPACE_GRAY,64000)
        );
        System.out.println("Марки телефонов на которых действует скидка: \n");
        phoneOfStream
                .flatMap(p->Stream.of(
                        String.format("Марка: %s --> цена без скидки: %d\n", p.getPhoneType(), p.getPrice()),
                        String.format("Марка: %s --> цена со скидкой: %d\n", p.getPhoneType(), p.getPrice() - (int)(p.getPrice()*0.1))
                ))
                .forEach(p->System.out.println(p));

        List<Phone> phones = new ArrayList<>();

        phones.add(new Phone(PhoneType.IPHONE_X, PhoneColor.BLACK,43000));
        phones.add(new Phone(PhoneType.IPHONE_XS,PhoneColor.BLUE,51000));
        phones.add(new Phone(PhoneType.IPHONE_XS_MAX,PhoneColor.GOLD,65000));
        phones.add(new Phone(PhoneType.IPHONE_S,PhoneColor.GREEN,30000));
        phones.add(new Phone(PhoneType.SAMSUNG_S10,PhoneColor.WHITE,35000));
        phones.add(new Phone(PhoneType.SAMSUNG_S10ULTRA,PhoneColor.BLACK,46000));
        phones.add(new Phone(PhoneType.SAMSUNG_S20ULTRA,PhoneColor.SPACE_GRAY,64000));

        Gift cheap = new Gift("Зашитное стекло - 5D",500);
        Gift middle = new Gift("PowerBank",2000);
        Gift expensive = new Gift("Airpods",8000);

        System.out.println("Map Method gifts");
        List<Gift> gifts = phones.stream()
                .map(phone -> {
                    if (phone.getPrice() <= 30000) {
                        return cheap;
                    } else if (phone.getPrice() <= 43000) {
                        return middle;
                    } else return expensive;

                }
    ).collect(Collectors.toList());
        System.out.println(gifts);



        Map<Phone, String> phoneGift = new LinkedHashMap<>();
        for(int i = 0; i < gifts.size(); i++){
            phoneGift.put(phones.get(i), gifts.get(i).getName());
        }
        for(Map.Entry entry: phoneGift.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println("Filter Method --- find PhoneCollectFrom where length's == 10 ");
        List<String> PhoneCollectedFrom = Arrays.asList("TayWan","Сalifornia","India","China","Singapore","Japan","Switzerland");

        PhoneCollectedFrom.stream().filter(s -> s.length()==10).forEach(s -> System.out.println(s));
        //phoneOfStream.map(Phone::getPhoneType).forEach(System.out::println);

        //phoneOfStream.map(phone ->" Марка : " + phone.getPhoneType() + " Цвет :"
         //+ phone.getPhoneColor() + " Цена : " + phone.getPrice()).forEach(System.out::println);












    }
}
