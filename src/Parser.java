import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Andrew on 02.07.2015.
 */
public class Parser {
    static ArrayList<ArrayList<String>> systemMassive = new ArrayList<>();
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
            for(int i = 0; i < ingridients.size(); i++){
                for(int j = 0; j < ingridients.get(i).children().size(); j++){
            System.out.println(ingridients.get(i).children().get(j).children().html());
                }
                System.out.println("\n new recept!!!!");
            }
            /*String currentString = "";
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < ingridients.size(); i++) {
                currentString = ingridients.get(i).children().html();
                Parser.ingridientName = currentString.substring(33, currentString.length());

                mas[i][0] =  Parser.ingridientName;
            }*/

        } catch (java.net.MalformedURLException e2) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e1) {
        }
    }
    public void printMas(){
        for (int i = 0; i < mas.length; i++){
            for (int j = 0; j < mas[i].length; j++){
                System.out.print(mas[i][j]+" ");
            }
            System.out.println();
        }
    }
}
