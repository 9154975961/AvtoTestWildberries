import com.google.gson.Gson;
import model.Example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import service.ServiceGetAllData;
import service.ServiceGetNewData;
import utils.EchoWorkingBot;
import utils.IfElementsMoreThan3000;

import java.io.*;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, TelegramApiException {

        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

        //-----------------------------Настройки для хрома в силениум---------------------
        //System.setProperty("webdriver.chrome.driver", "driver/chromedriver"); для Linux
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\selenium\\chromedriver107.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        IfElementsMoreThan3000 ifElementsMoreThan3000 = new IfElementsMoreThan3000();

//для гарнитур
        Example exampleGarnitury = null;
        Gson gson = new Gson();
        String fileNameGarnitury = "NewListGarnitury.txt";
        String nameUrlGarnitury = "https://catalog.wb.ru/catalog/electronic2/catalog?appType=1&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-2162196,-1257786&emp=0&lang=ru&locale=ru&page=1&pricemarginCoeff=1.0&reg=0&regions=68,64,83,4,38,80,33,70,82,86,75,30,69,1,48,22,66,31,40,71&sort=newly&spp=0&subject=518;593;924;1407;2913;3001;6817";
        String nameUrlForPageStartGarnitury = "https://catalog.wb.ru/catalog/electronic2/catalog?appType=1&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-2162196,-1257786&emp=0&lang=ru&locale=ru&page=";
        String nameUrlForPageFinishGarnitury = "&pricemarginCoeff=1.0&reg=0&regions=68,64,83,4,38,80,33,70,82,86,75,30,69,1,48,22,66,31,40,71&sort=newly&spp=0&subject=518;593;924;1407;2913;3001;6817";
        ServiceGetNewData garnituryServiceGetNewData = new ServiceGetNewData();
        ServiceGetAllData garnituryServiceGetAllData = new ServiceGetAllData();

//для Смартфонов
        Example exampleSmartfony = null;
        Gson gsonSmartfony = new Gson();
        String fileNameSmartfony = "NewListSmartfony.txt";
        String nameUrlSmartfony = "https://catalog.wb.ru/catalog/electronic3/catalog?appType=1&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-2162196,-1257786&emp=0&lang=ru&locale=ru&page=1&pricemarginCoeff=1.0&reg=0&regions=68,64,83,4,38,80,33,70,82,86,75,30,69,1,48,22,66,31,40,71&sort=newly&spp=0&subject=515";
        String nameUrlForPageStartSmartfony = "https://catalog.wb.ru/catalog/electronic3/catalog?appType=1&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-2162196,-1257786&emp=0&lang=ru&locale=ru&page=";
        String nameUrlForPageFinishSmartfony = "&pricemarginCoeff=1.0&reg=0&regions=68,64,83,4,38,80,33,70,82,86,75,30,69,1,48,22,66,31,40,71&sort=newly&spp=0&subject=515";
        ServiceGetNewData smartfonyServiceGetNewData = new ServiceGetNewData();
        ServiceGetAllData smartfonyServiceGetAllData = new ServiceGetAllData();

//для Ноутбуков
        Example exampleNoutbuki = null;
        Gson gsonNoutbuki = new Gson();
        String fileNameNoutbuki = "NewListNoutbuki.txt";
        String nameUrlNoutbuki = "https://catalog.wb.ru/catalog/electronic6/catalog?appType=1&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-1304596,-1292286&emp=0&lang=ru&locale=ru&page=1&pricemarginCoeff=1.0&reg=1&regions=68,64,83,4,38,80,33,70,82,86,75,30,69,1,48,22,66,31,40,71&sort=newly&spp=27&subject=2290";
        String nameUrlForPageStartNoutbuki = "https://catalog.wb.ru/catalog/electronic6/catalog?appType=1&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-1304596,-1292286&emp=0&lang=ru&locale=ru&page=";
        String nameUrlForPageFinishNoutbuki = "&pricemarginCoeff=1.0&reg=1&regions=68,64,83,4,38,80,33,70,82,86,75,30,69,1,48,22,66,31,40,71&sort=newly&spp=27&subject=2290";
        ServiceGetNewData noutbukiServiceGetNewData = new ServiceGetNewData();
        ServiceGetAllData noutbukiServiceGetAllData = new ServiceGetAllData();

//для Планшетов apple
        Example exampleApple = null;
        Gson gsonApple = new Gson();
        String fileNameApple = "NewListApple.txt";
        String nameUrlApple = "https://catalog.wb.ru/catalog/electronic3/catalog?appType=1&brand=6049&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-1304596,-1292286&emp=0&lang=ru&locale=ru&page=1&pricemarginCoeff=1.0&reg=1&regions=68,64,83,4,38,80,33,70,82,86,75,30,69,1,48,22,66,31,40,71&sort=newly&spp=25&subject=517";
        String nameUrlForPageStartApple = "https://catalog.wb.ru/catalog/electronic3/catalog?appType=1&brand=6049&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-1304596,-1292286&emp=0&lang=ru&locale=ru&page=";
        String nameUrlForPageFinishApple = "&pricemarginCoeff=1.0&reg=1&regions=68,64,83,4,38,80,33,70,82,86,75,30,69,1,48,22,66,31,40,71&sort=newly&spp=25&subject=517";
        ServiceGetNewData appleServiceGetNewData = new ServiceGetNewData();
        ServiceGetAllData appleServiceGetAllData = new ServiceGetAllData();

//для Планшетов Samsung
        Example exampleSamsung = null;
        Gson gsonSamsung = new Gson();
        String fileNameSamsung = "NewListSamsung.txt";
        String nameUrlSamsung = "https://catalog.wb.ru/catalog/electronic3/catalog?appType=1&brand=5772&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-1304596,-1292286&emp=0&lang=ru&locale=ru&pricemarginCoeff=1.0&reg=1&regions=68,64,83,4,38,80,33,70,82,86,75,30,69,1,48,22,66,31,40,71&sort=newly&spp=25&subject=517";
        String nameUrlForPageStartSamsung = "https://catalog.wb.ru/catalog/electronic3/catalog?appType=1&brand=5772&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-1304596,-1292286&emp=0&lang=ru&locale=ru&page=";
        String nameUrlForPageFinishSamsung = "&pricemarginCoeff=1.0&reg=1&regions=68,64,83,4,38,80,33,70,82,86,75,30,69,1,48,22,66,31,40,71&sort=newly&spp=25&subject=517";
        ServiceGetNewData samsungServiceGetNewData = new ServiceGetNewData();
        ServiceGetAllData samsungServiceGetAllData = new ServiceGetAllData();

//для Планшетов android
        Example exampleAndroid = null;
        Gson gsonAndroid = new Gson();
        String fileNameAndroid = "NewListAndroid.txt";
        String nameUrlAndroid = "https://catalog.wb.ru/catalog/electronic3/catalog?appType=1&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-1304596,-1292286&emp=0&ext=12787;12823;12824;12825;12826;12827;12828;12829;12830;18142;78360;81122;94647;94649;100358;119029;119165;124719;179354;356021;364520&lang=ru&locale=ru&pricemarginCoeff=1.0&reg=1&regions=68,64,83,4,38,80,33,70,82,86,75,30,69,1,48,22,66,31,40,71&sort=newly&spp=25&subject=517";
        String nameUrlForPageStartAndroid = "https://catalog.wb.ru/catalog/electronic3/catalog?appType=1&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-1304596,-1292286&emp=0&ext=12787;12823;12824;12825;12826;12827;12828;12829;12830;18142;78360;81122;94647;94649;100358;119029;119165;124719;179354;356021;364520&lang=ru&locale=ru&page=";
        String nameUrlForPageFinishAndroid = "&pricemarginCoeff=1.0&reg=1&regions=68,64,83,4,38,80,33,70,82,86,75,30,69,1,48,22,66,31,40,71&sort=newly&spp=25&subject=517";
        ServiceGetNewData androidServiceGetNewData = new ServiceGetNewData();
        ServiceGetAllData androidServiceGetAllData = new ServiceGetAllData();

//для televizory
        Example exampleTelevizory = null;
        Gson gsonTelevizory = new Gson();
        String fileNameTelevizory = "NewListTelevizory.txt";
        String nameUrlTelevizory = "https://catalog.wb.ru/catalog/electronic1/catalog?appType=1&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-1304596,-1292286&emp=0&lang=ru&locale=ru&pricemarginCoeff=1.0&reg=1&regions=68,64,83,4,38,80,33,70,82,86,75,30,69,1,48,22,66,31,40,71&sort=newly&spp=25&subject=2819";
        String nameUrlForPageStartTelevizory = "https://catalog.wb.ru/catalog/electronic1/catalog?appType=1&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-1304596,-1292286&emp=0&lang=ru&locale=ru&page=";
        String nameUrlForPageFinishTelevizory = "&pricemarginCoeff=1.0&reg=1&regions=68,64,83,4,38,80,33,70,82,86,75,30,69,1,48,22,66,31,40,71&sort=newly&spp=25&subject=2819";
        ServiceGetNewData televizoryServiceGetNewData = new ServiceGetNewData();
        ServiceGetAllData televizoryServiceGetAllData = new ServiceGetAllData();

//для videokamery
        Example exampleVideokamery = null;
        Gson gsonVideokamery = new Gson();
        String fileNameVideokamery = "NewListVideokamery.txt";
        String nameUrlVideokamery = "https://catalog.wb.ru/catalog/electronic1/catalog?appType=1&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-1304596,-1292286&emp=0&lang=ru&locale=ru&pricemarginCoeff=1.0&reg=1&regions=68,64,83,4,38,80,33,70,82,86,75,30,69,1,48,22,66,31,40,71&sort=newly&spp=25&subject=549;3152;547";
        String nameUrlForPageStartVideokamery = "https://catalog.wb.ru/catalog/electronic1/catalog?appType=1&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-1304596,-1292286&emp=0&lang=ru&locale=ru&page=";
        String nameUrlForPageFinishVideokamery = "&pricemarginCoeff=1.0&reg=1&regions=68,64,83,4,38,80,33,70,82,86,75,30,69,1,48,22,66,31,40,71&sort=newly&spp=25&subject=549;3152;547";
        ServiceGetNewData videokameryServiceGetNewData = new ServiceGetNewData();
        ServiceGetAllData videokameryServiceGetAllData = new ServiceGetAllData();

//для fotoapparaty
        Example exampleFotoapparaty = null;
        Gson gsonFotoapparaty = new Gson();
        String fileNameFotoapparaty = "NewListFotoapparaty.txt";
        String nameUrlFotoapparaty = "https://catalog.wb.ru/catalog/electronic1/catalog?appType=1&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-1304596,-1292286&emp=0&lang=ru&locale=ru&pricemarginCoeff=1.0&reg=1&regions=80,68,64,83,4,38,33,70,82,69,86,75,30,40,48,1,22,66,31,71&sort=newly&spp=26&subject=790;6104;6106";
        String nameUrlForPageStartFotoapparaty = "https://catalog.wb.ru/catalog/electronic1/catalog?appType=1&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-1304596,-1292286&emp=0&lang=ru&locale=ru&page=";
        String nameUrlForPageFinishFotoapparaty = "&pricemarginCoeff=1.0&reg=1&regions=80,68,64,83,4,38,33,70,82,69,86,75,30,40,48,1,22,66,31,71&sort=newly&spp=26&subject=790;6104;6106";
        ServiceGetNewData fotoapparatyServiceGetNewData = new ServiceGetNewData();
        ServiceGetAllData fotoapparatyServiceGetAllData = new ServiceGetAllData();

//для vozduhootchistiteli
        Example exampleVozduhootchistiteli = null;
        Gson gsonVozduhootchistiteli = new Gson();
        String fileNameVozduhootchistiteli = "NewListVozduhootchistiteli.txt";
        String nameUrlVozduhootchistiteli = "https://catalog.wb.ru/catalog/appliances/catalog?appType=1&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-1304596,-1292286&emp=0&lang=ru&locale=ru&pricemarginCoeff=1.0&reg=1&regions=80,68,64,83,4,38,33,70,82,69,86,75,30,40,48,1,22,66,31,71&sort=newly&spp=26&subject=624;639;939;1192;1275;1537;1999;2000;2001;2473;2541;2542;2543;2550;2590;3559;3687;4334;4400;5454;5973;6194;6205;6206;6488;6544;6546";
        String nameUrlForPageStartVozduhootchistiteli = "https://catalog.wb.ru/catalog/appliances/catalog?appType=1&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-1304596,-1292286&emp=0&lang=ru&locale=ru&page=";
        String nameUrlForPageFinishVozduhootchistiteli = "&pricemarginCoeff=1.0&reg=1&regions=80,68,64,83,4,38,33,70,82,69,86,75,30,40,48,1,22,66,31,71&sort=newly&spp=26&subject=624;639;939;1192;1275;1537;1999;2000;2001;2473;2541;2542;2543;2550;2590;3559;3687;4334;4400;5454;5973;6194;6205;6206;6488;6544;6546";
        ServiceGetNewData vozduhootchistiteliServiceGetNewData = new ServiceGetNewData();
        ServiceGetAllData vozduhootchistiteliServiceGetAllData = new ServiceGetAllData();

//для sadovaya-tehnika
        Example exampleSadovayaTehnika = null;
        Gson gsonSadovayaTehnika = new Gson();
        String fileNameSadovayaTehnika = "NewListSadovayaTehnika.txt";
        String nameUrlSadovayaTehnika = "https://catalog.wb.ru/catalog/appliances/catalog?appType=1&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-1304596,-1292286&emp=0&lang=ru&locale=ru&pricemarginCoeff=1.0&reg=1&regions=80,68,64,83,4,38,33,70,82,69,86,75,30,40,48,1,22,66,31,71&sort=newly&spp=26&subject=2240";
        String nameUrlForPageStartSadovayaTehnika = "https://catalog.wb.ru/catalog/appliances/catalog?appType=1&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-1304596,-1292286&emp=0&lang=ru&locale=ru&page=";
        String nameUrlForPageFinishSadovayaTehnika = "&pricemarginCoeff=1.0&reg=1&regions=80,68,64,83,4,38,33,70,82,69,86,75,30,40,48,1,22,66,31,71&sort=newly&spp=26&subject=2240";
        ServiceGetNewData sadovayaTehnikaServiceGetNewData = new ServiceGetNewData();
        ServiceGetAllData sadovayaTehnikaServiceGetAllData = new ServiceGetAllData();

//для vodonagrevateli
        Example exampleVodonagrevateli = null;
        Gson gsonVodonagrevateli = new Gson();
        String fileNameVodonagrevateli = "NewListVodonagrevateli.txt";
        String nameUrlVodonagrevateli = "https://catalog.wb.ru/catalog/appliances/catalog?appType=1&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-1304596,-1292286&emp=0&lang=ru&locale=ru&pricemarginCoeff=1.0&reg=1&regions=80,68,64,83,4,38,33,70,82,69,86,75,30,40,48,1,22,66,31,71&sort=newly&spp=26&subject=1414;5935";
        String nameUrlForPageStartVodonagrevateli = "https://catalog.wb.ru/catalog/appliances/catalog?appType=1&couponsGeo=12,3,18,15,21&curr=rub&dest=-1029256,-102269,-1304596,-1292286&emp=0&lang=ru&locale=ru&page=";
        String nameUrlForPageFinishVodonagrevateli = "&pricemarginCoeff=1.0&reg=1&regions=80,68,64,83,4,38,33,70,82,69,86,75,30,40,48,1,22,66,31,71&sort=newly&spp=26&subject=1414;5935";
        ServiceGetNewData vodonagrevateliServiceGetNewData = new ServiceGetNewData();
        ServiceGetAllData vodonagrevateliServiceGetAllData = new ServiceGetAllData();

//получаем 600 данных по гарнитурам
        exampleGarnitury = garnituryServiceGetAllData.serviceGetAllData(driver, gson, exampleGarnitury,
                fileNameGarnitury, nameUrlForPageStartGarnitury, nameUrlForPageFinishGarnitury);
//получаем 600 данных по Смартфонам
        exampleSmartfony = smartfonyServiceGetAllData.serviceGetAllData(driver, gsonSmartfony, exampleSmartfony,
                 fileNameSmartfony, nameUrlForPageStartSmartfony, nameUrlForPageFinishSmartfony);
//получаем 600 данных по ноутбукам
        exampleNoutbuki = noutbukiServiceGetAllData.serviceGetAllData(driver, gsonSmartfony, exampleNoutbuki,
                fileNameNoutbuki,nameUrlForPageStartNoutbuki, nameUrlForPageFinishNoutbuki);
//получаем 600 данных по планшетам апл
        exampleApple = appleServiceGetAllData.serviceGetAllData(driver, gsonApple, exampleApple,
                fileNameApple,nameUrlForPageStartApple, nameUrlForPageFinishApple);
//получаем 600 данных по планшетам samsung
        exampleSamsung = samsungServiceGetAllData.serviceGetAllData(driver, gsonSamsung, exampleSamsung,
                fileNameSamsung,nameUrlForPageStartSamsung, nameUrlForPageFinishSamsung);
//получаем 600 данных по планшетам Android
        exampleAndroid = androidServiceGetAllData.serviceGetAllData(driver, gsonAndroid, exampleAndroid,
                fileNameAndroid,nameUrlForPageStartAndroid, nameUrlForPageFinishAndroid);
//получаем 600 данных по телевизорам
        exampleTelevizory = televizoryServiceGetAllData.serviceGetAllData(driver, gsonTelevizory, exampleTelevizory,
                fileNameTelevizory,nameUrlForPageStartTelevizory, nameUrlForPageFinishTelevizory);
//получаем 600 данных по видеокамеры
        exampleVideokamery = videokameryServiceGetAllData.serviceGetAllData(driver, gsonVideokamery, exampleVideokamery,
                fileNameVideokamery,nameUrlForPageStartVideokamery, nameUrlForPageFinishVideokamery);
//получаем 600 данных по фотоаппаратам
        exampleFotoapparaty = fotoapparatyServiceGetAllData.serviceGetAllData(driver, gsonFotoapparaty, exampleFotoapparaty,
                fileNameFotoapparaty,nameUrlForPageStartFotoapparaty, nameUrlForPageFinishFotoapparaty);
//получаем 600 данных по воздухоотчистители
        exampleVozduhootchistiteli = vozduhootchistiteliServiceGetAllData.serviceGetAllData(driver, gsonVozduhootchistiteli, exampleVozduhootchistiteli,
                fileNameVozduhootchistiteli,nameUrlForPageStartVozduhootchistiteli, nameUrlForPageFinishVozduhootchistiteli);
//получаем 600 данных по садовая техника
        exampleSadovayaTehnika = sadovayaTehnikaServiceGetAllData.serviceGetAllData(driver, gsonSadovayaTehnika, exampleSadovayaTehnika,
                fileNameSadovayaTehnika,nameUrlForPageStartSadovayaTehnika, nameUrlForPageFinishSadovayaTehnika);
//получаем 600 данных по Водонагреватели
        exampleVodonagrevateli = vodonagrevateliServiceGetAllData.serviceGetAllData(driver, gsonVodonagrevateli, exampleVodonagrevateli,
                fileNameVodonagrevateli,nameUrlForPageStartVodonagrevateli, nameUrlForPageFinishVodonagrevateli);

 //получаем обновленные данные
        while (true) {

            try {
                exampleGarnitury = garnituryServiceGetNewData.serviceGetNewData(driver, gson, exampleGarnitury, nameUrlGarnitury);
            }catch (Exception e){
                System.out.println("-------> Сервер сверг правителя, но игра продолжается");
            }
            ifElementsMoreThan3000.ifElementsMoreThan3000(exampleGarnitury);
            sleep(1350);
            try {
            exampleSmartfony = smartfonyServiceGetNewData.serviceGetNewData(driver, gsonSmartfony, exampleSmartfony, nameUrlSmartfony);
            }catch (Exception e){
                System.out.println("-------> Сервер сверг правителя, но игра продолжается");
            }
            ifElementsMoreThan3000.ifElementsMoreThan3000(exampleSmartfony);
            sleep(1525);
            try {
            exampleNoutbuki = noutbukiServiceGetNewData.serviceGetNewData(driver, gsonNoutbuki, exampleNoutbuki, nameUrlNoutbuki);
            }catch (Exception e){
                    System.out.println("-------> Сервер сверг правителя, но игра продолжается");
            }
            ifElementsMoreThan3000.ifElementsMoreThan3000(exampleNoutbuki);
            sleep(1240);
            try {
            exampleApple = appleServiceGetNewData.serviceGetNewData(driver, gsonApple, exampleApple, nameUrlApple);
            }catch (Exception e){
                    System.out.println("-------> Сервер сверг правителя, но игра продолжается");
            }
            ifElementsMoreThan3000.ifElementsMoreThan3000(exampleApple);
            sleep(1250);
            try {
            exampleSamsung = samsungServiceGetNewData.serviceGetNewData(driver, gsonSamsung, exampleSamsung, nameUrlSamsung);
            }catch (Exception e){
                    System.out.println("-------> Сервер сверг правителя, но игра продолжается");
            }
            ifElementsMoreThan3000.ifElementsMoreThan3000(exampleSamsung);
            sleep(1150);
            try {
            exampleAndroid = androidServiceGetNewData.serviceGetNewData(driver, gsonAndroid, exampleAndroid, nameUrlAndroid);
            }catch (Exception e){
                    System.out.println("-------> Сервер сверг правителя, но игра продолжается");
            }
            ifElementsMoreThan3000.ifElementsMoreThan3000(exampleAndroid);
            sleep(1070);
            try {
            exampleTelevizory = televizoryServiceGetNewData.serviceGetNewData(driver, gsonTelevizory, exampleTelevizory, nameUrlTelevizory);
            }catch (Exception e){
                    System.out.println("-------> Сервер сверг правителя, но игра продолжается");
            }
            ifElementsMoreThan3000.ifElementsMoreThan3000(exampleTelevizory);
            sleep(1000);
            try {
            exampleVideokamery = videokameryServiceGetNewData.serviceGetNewData(driver, gsonVideokamery, exampleVideokamery, nameUrlVideokamery);
            }catch (Exception e){
                    System.out.println("-------> Сервер сверг правителя, но игра продолжается");
            }
            ifElementsMoreThan3000.ifElementsMoreThan3000(exampleVideokamery);
            sleep(1050);
            try {
            exampleFotoapparaty = fotoapparatyServiceGetNewData.serviceGetNewData(driver, gsonFotoapparaty, exampleFotoapparaty, nameUrlFotoapparaty);
            }catch (Exception e){
                    System.out.println("-------> Сервер сверг правителя, но игра продолжается");
            }
            ifElementsMoreThan3000.ifElementsMoreThan3000(exampleFotoapparaty);
            sleep(1025);
            try {
            exampleVozduhootchistiteli = vozduhootchistiteliServiceGetNewData.serviceGetNewData(driver, gsonVozduhootchistiteli, exampleVozduhootchistiteli, nameUrlVozduhootchistiteli);
            }catch (Exception e){
                    System.out.println("-------> Сервер сверг правителя, но игра продолжается");
            }
            ifElementsMoreThan3000.ifElementsMoreThan3000(exampleVozduhootchistiteli);
            sleep(1000);
            try {
            exampleSadovayaTehnika = sadovayaTehnikaServiceGetNewData.serviceGetNewData(driver, gsonSadovayaTehnika, exampleSadovayaTehnika, nameUrlSadovayaTehnika);
            }catch (Exception e){
                    System.out.println("-------> Сервер сверг правителя, но игра продолжается");
            }
            ifElementsMoreThan3000.ifElementsMoreThan3000(exampleSadovayaTehnika);
            sleep(1075);
            try {
            exampleVodonagrevateli = vodonagrevateliServiceGetNewData.serviceGetNewData(driver, gsonVodonagrevateli, exampleVodonagrevateli, nameUrlVodonagrevateli);
            }catch (Exception e){
                    System.out.println("-------> Сервер сверг правителя, но игра продолжается");
            }
            ifElementsMoreThan3000.ifElementsMoreThan3000(exampleVodonagrevateli);
            sleep(1075);

            botsApi.registerBot(new EchoWorkingBot());
        }
    }
}