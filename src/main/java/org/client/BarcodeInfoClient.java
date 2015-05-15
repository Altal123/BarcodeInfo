package org.client;

import org.apache.commons.io.FileUtils;
import org.barcode.*;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class BarcodeInfoClient {

    private static String filePath = "d:\\Sasha\\parcel_log.txt"; //файл с логами посылок
    private static Map <String,String> currentParcelsInfo = new LinkedHashMap<String, String>(); //key - ID , value - parcel status


    public static void main(String[] args) {

        File parcelFile = new File(filePath); //ссылка на файл c посылками

        try {
          if (!parcelFile.exists()) parcelFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //все строки в файле помещаем в коллекцию строк
        try {
            List<String> infoFromFile = FileUtils.readLines(parcelFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //формируем мап-коллекцию с текущим статусом посылок
        if (args.length > 0){
            for (String d:args){
                barCodeInfo(d);
            }
        } else {
            System.out.println("Please add the required parcel`s ID!");
            System.exit(-1);
        }

        //сравниваем полученную мап-коллекцию с коллекцией строк, полученную из файла

    }

    private static void barCodeInfo(String id) {
        BarcodeStatistic service = new BarcodeStatistic();

        BarcodeStatisticSoap barInfo = service.getBarcodeStatisticSoap();

        BarcodeInfoService response = barInfo.getBarcodeInfo("fcc8d9e1-b6f9-438f-9ac8-b67ab44391dd", id, Culture.UK);

        currentParcelsInfo.put(response.getBarcode(), response.getEventdescription());

        System.out.println("      Parcel Id: " + response.getBarcode());
        System.out.println(response.getEventdescription());

    }
}
