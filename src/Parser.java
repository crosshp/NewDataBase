import Hibernate.Dish;
import Hibernate.DishAndIngridient;
import Hibernate.FactoryDAO;
import Hibernate.Ingridient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Andrew on 02.07.2015.
 */
public class Parser {


    static ArrayList systemMassive = new ArrayList<>();
    static String dishName = null;
    static String ingridientName = null;
    static int idIngridient;
    static int idDish;
    static int size = 0;
    static String href = null;
    private String[][] mas = new String[20][2];

    public void parse(int pageNumber) {
        try {
            Document doc = Jsoup
                    .connect(
                            "http://vholodilnike.com/page" + pageNumber)
                    .get();
            Elements elements = doc.select("h2.header_recipe");
            for (int i = 0; i < elements.size(); i++) {
                Parser.dishName = elements.get(i).children().html();
                Parser.href = elements.get(i).children().attr("href");
                mas[i][0] = Parser.dishName;
                mas[i][1] = Parser.href;
            }

            Elements ingridients = doc.select("div.ingridients");
            ArrayList<Element> deleteIndex = new ArrayList();
            int k = 0;
            for (Element element : ingridients) {
                if (element.attr("class").equals("ingridients can-add-product")) {
                    deleteIndex.add(element);
                }
                k++;
                System.out.println(element.attr("class"));
            }

            for (Element o : deleteIndex) {
                ingridients.remove(o);
            }

            String currentString = "";
            String receptIngridients = "";
            System.out.println(ingridients.size());

            for (int i = 0; i < ingridients.size(); i++) {
                try {

                    FactoryDAO.getInstance().getImplementationDAO().addDish(new Dish(mas[i][0], mas[i][1]));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < ingridients.get(i).children().size(); j++) {
                    currentString = ingridients.get(i).children().get(j).children().html();
                    currentString = currentString.substring(33, currentString.length());
                    receptIngridients += currentString + " ";
                    try {
                        long lastDish = FactoryDAO.getInstance().getImplementationDAO().getLastIdFromTable("dish");
                        FactoryDAO.getInstance().getImplementationDAO().addIngridient(new Ingridient(currentString));
                        long lastIngridient = FactoryDAO.getInstance().getImplementationDAO().getLastIdFromTable("ingridient_test");

                        FactoryDAO.getInstance().getImplementationDAO().addDishAndIngridient(new DishAndIngridient(lastDish, lastIngridient));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                systemMassive.add(i, receptIngridients);
                receptIngridients = "";
            }


        } catch (java.net.MalformedURLException e2) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e1) {
        }
    }

    public void clearAllTable() {
        try {
            FactoryDAO.getInstance().getImplementationDAO().deleteFromTable("dish");
            FactoryDAO.getInstance().getImplementationDAO().deleteFromTable("dishingridient");
            FactoryDAO.getInstance().getImplementationDAO().deleteFromTable("ingridient_test");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printArrayList() {
        for (int i = 0; i < systemMassive.size(); i++) {
            System.out.println(systemMassive.get(i));
        }
    }
    ArrayList<ArrayList<String>> mainMassive = null;

    public int containsInMainMassive(String word){
        int i = 0;
        for(ArrayList<String> arrayList: mainMassive){
            if(arrayList.get(0).equals(word)){
                return i;
            }
            i++;
        }
        return -1;
    }
    public void test() {
        List list = FactoryDAO.getInstance().getImplementationDAO().executeQuery("SELECT * FROM table.ingridient_test");
        int i = 1;
        ArrayList<String[]> map = new ArrayList<> ();
        for (Object ingridient : list) {
            String[] mas = new String[2];
            mas[0] = String.valueOf(i);
            mas[1] = ingridient.toString();
            map.add(mas);
            i++;
        }
        mainMassive = new ArrayList<>();

        for(String[] mas : map){
            int current = containsInMainMassive(mas[1]);
            if(current!=-1){
                mainMassive.get(current).add(mas[0]);
            } else {
                ArrayList currentAray = new ArrayList();
                currentAray.add(mas[1]);
                currentAray.add(mas[0]);
                mainMassive.add(currentAray);
            }
        }
    }

    public void soutMainMassive(){
        for(ArrayList<String> arrayList: mainMassive){
            for(String s: arrayList){
                System.out.println(s+" ");
            }
            System.out.println();
        }
    }
}
