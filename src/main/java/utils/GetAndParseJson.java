package utils;

import com.google.gson.Gson;
import model.Example;
import org.openqa.selenium.WebDriver;

import java.io.FileWriter;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class GetAndParseJson {

    public GetAndParseJson(WebDriver driver, String nameFile, String nameUrlForPageStart, String nameUrlForPageFinish) throws InterruptedException, IOException {

        int countMain = 0;
        boolean flag = false;

        for (int i = 0; i < 6; i++) {
            if (countMain != 7) {
                countMain++;
            }

            driver.get(nameUrlForPageStart + countMain + nameUrlForPageFinish);
            sleep(1500);

            //-----------------------------Передаем полученные данные в строку для форматирования ---------------------
            String dataOut = driver.getPageSource();

            //-----------------------------Проверяем что получили из страницы все 100 элементов ---------------------
            Gson checkData = new Gson();
            Example exampleCheck = new Example();

            //-----------------------------Убираем из строки лишние данные ---------------------
            dataOut = dataOut.substring(dataOut.indexOf('{'), dataOut.lastIndexOf(']'));

            dataOut = dataOut+"]}}";
            exampleCheck = checkData.fromJson(dataOut, Example.class);
            if (exampleCheck.getData().getProducts().size()<99) flag = true;
            dataOut = dataOut.substring(0,dataOut.lastIndexOf(']'));

            if (i>=1) dataOut = dataOut.substring(dataOut.indexOf('[') + 1);



            //-----------------------------Запись полученнных данных в файл и добавляю "," ---------------------
            try (FileWriter writer = new FileWriter(nameFile, true)) {
                writer.append(dataOut);
                if (i == 5 || flag) {
                    writer.append("]}}");
                    break;
                } else {
                    writer.append(",");
                }
            }
        }
    }
}