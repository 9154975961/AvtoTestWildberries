package service;

import com.google.gson.Gson;
import model.Example;
import org.openqa.selenium.WebDriver;
import utils.EnumerationOfData;
import utils.setFile.SetComparedFile;

import java.io.FileReader;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class ServiceGetNewData {

    public Example serviceGetNewData(WebDriver driver, Gson gson, Example example, String nameUrl) throws IOException {
        //***************Вторая часть (получение новых данных)*****************
            //-----------------------------Парсим новые данные ---------------------
            try {driver.get(nameUrl);
            } catch (Exception e){
                System.out.println("-------> Сервер сверг правителя");
            }
            String dataNew=driver.getPageSource();

        // при выполнении программы происходит блокировка сайтом моего IP. Данным циклом буду выкидывать на проверку
        // следующей позиции, чтоб эта пока отдохнула
            boolean forFlag = true;
            while (forFlag) {
                forFlag = false;
        // и собственно сама проверка длинны полученной строки
                if (dataNew.length()<50){break;}
                //-----------------------------Убираем из спарсенной строки лишние данные ---------------------
                dataNew = dataNew.substring(dataNew.indexOf('{'), dataNew.lastIndexOf(']'));

                //-----------------------------Запись полученнных данных в файл---------------------
                SetComparedFile setComparedFile = new SetComparedFile(dataNew, "ComparedFile.txt");

                //-----------------------------Читаем сохраненные данные и переносим в новый объект ---------------------
                Example comparedExample = null;
                try (FileReader reader = new FileReader("ComparedFile.txt")) {
                    comparedExample = gson.fromJson(reader, Example.class);
                } catch (Exception e) {
                    System.out.println("Parsing error" + e.toString());
                }

                //-----------------------------Ищем на какой позиции находится id в старых данных ---------------------
                //-----------------------------И ищем на какой позиции этот id в новых данных---------------------
                //-----------------------------В общих данных найти первый элемент id---------------------
                int firstId = example.getData().getProducts().get(0).getId();
                //-----------------------------В новых данных ищем на какой позиции этот id---------------------
                //-----------------------------И записываем данные в общий файл если не на этой---------------------
                int countNewData = 0; // счетчик для подсчета новых данных вошедших в общий список
                for (int i = 0; i < comparedExample.getData().getProducts().size(); i++) {
                    if (comparedExample.getData().getProducts().get(i).getId() == null) {
                        break;
                    }
                    if (comparedExample.getData().getProducts().get(i).getId() != firstId) {
                        //example.getData().setProducts((List<Product>) comparedExample.getData().getProducts().get(i));
                        //добавляем новые данные в старый example
                        example.getData().getProducts().add(i, comparedExample.getData().getProducts().get(i));
                        countNewData++;//количество новых данных вошедших в общий список
                    } else break;
                }

                //Вызвать Enumeration of data для перебора списков данных и нахождения цен меньше 30 процентов
                EnumerationOfData enumerationOfDataTwo = new EnumerationOfData(countNewData, example);

            }
        return example;
    }
}