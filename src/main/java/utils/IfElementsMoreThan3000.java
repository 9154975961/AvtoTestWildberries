package utils;

import model.Example;

public class IfElementsMoreThan3000 {

    //Удаляем элементы если example стал больше 3000 наименований

    public Example ifElementsMoreThan3000 (Example example){
        if (example.getData().getProducts().size()>2000){
            for (int i = example.getData().getProducts().size()-1; i > 2000; i--) {
                example.getData().getProducts().remove(i);
            }
        }
        return example;
    }
}
