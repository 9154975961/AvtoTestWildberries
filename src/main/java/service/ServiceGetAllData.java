package service;

import com.google.gson.Gson;
import model.Example;
import org.openqa.selenium.WebDriver;
import utils.EnumerationOfData;
import utils.GetAndParseJson;

import java.io.*;
import java.io.FileReader;

public class ServiceGetAllData {

    public Example serviceGetAllData(WebDriver driver, Gson gson, Example example, String nameFile,
                                              String nameUrlForPageStart, String nameUrlForPageFinish) throws IOException, InterruptedException {
        //***************Первая часть (получение общих данных для Гарнитур)*****************

        //-----------------------------Удалить файл с данными созданный при прошлом использовании программы---------------------
        File file = new File(nameFile);
        file.delete();

        //-----------------------------Цикл для получения записей и переноса в файл NewListGarnitury---------------------
        GetAndParseJson getAndParseJson = new GetAndParseJson(driver, nameFile,
                nameUrlForPageStart, nameUrlForPageFinish);

        //-----------------------------Читаем сохраненные данные и переносим в объект ---------------------
        try (
                FileReader reader = new FileReader(nameFile)) {
            example = gson.fromJson(reader, Example.class);
        } catch (Exception e) {
            System.out.println("Parsing error" + e.toString());
        }

        //-----------------------------Перебираем данные для получения названия товара и его цены для проверки ---------------------
        EnumerationOfData enumerationOfDataOne = new EnumerationOfData(10, example);
 //***************Первая часть (получение общих данных для Гарнитур)*****************
        return example;
    }
}