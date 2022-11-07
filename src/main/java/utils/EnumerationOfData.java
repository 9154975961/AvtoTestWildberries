package utils;

import model.Example;
import utils.SendMessageFromTelegram;

public class EnumerationOfData {

    public EnumerationOfData (int countNewData, Example example){

        for (int i = 0; i < countNewData; i++) {

            int countName = 0, countBrend = 0, idTest = 0, id = 0, price = 0, brendPrice = 0,
                    averagePrice = 0, averageBrendPrice = 0;
            String brendTest, nameTest, brend, name;

            try {
                brendTest = example.getData().getProducts().get(i).getBrand();
            } catch (NullPointerException e) {
                brendTest = "нет";
            }
            try {
                nameTest = example.getData().getProducts().get(i).getName();
            } catch (NullPointerException e) {
                nameTest = "нет";
            }
            idTest = example.getData().getProducts().get(i).getId();
            price = example.getData().getProducts().get(i).getSalePriceU();

            for (int j = 0; j < example.getData().getProducts().size(); j++) {

                brend = example.getData().getProducts().get(j).getBrand();
                name = example.getData().getProducts().get(j).getName();
                id = example.getData().getProducts().get(j).getId();

                if (nameTest.equals(name) && id != idTest) {
                    countName++;
                    averagePrice += example.getData().getProducts().get(j).getSalePriceU();
                }

                if (brendTest.equals(brend) && id != idTest) {
                    countBrend++;
                    averageBrendPrice += example.getData().getProducts().get(j).getSalePriceU();
                }
            }

            if (countName >= 1) {
                if (((averagePrice / countName) * 0.7) > price)
                    SendMessageFromTelegram.sendMessageFromTelegram("https://www.wildberries.ru/catalog/" +
                            idTest + "/detail.aspx?targetUrl=AB");

                System.out.println("ПРОВЕРЬ!!! -> " + "https://www.wildberries.ru/catalog/" +
                idTest + "/detail.aspx?targetUrl=AB");
            }
        }
    }
}