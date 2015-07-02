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

    public void parse(int pageNumber) {
        try {
            Document doc = Jsoup
                    .connect(
                            "http://vholodilnike.com/page" + pageNumber)
                    .get();
            Elements elements = doc.select("div.recipe");
            for (int i = 0; i < elements.size(); i++) {
                Parser.dishName = elements.get(i).children().get(0).children().get(0).children().get(0).children().get(0).children().get(0).html();
                Parser.size++;
            }
            Elements ingridients = doc.select("div.ingridients");
            String currentString = "";
            for (int i = 0; i < ingridients.size(); i++) {
                currentString = ingridients.get(i).children().get(0).child(0).html();
                Parser.ingridientName = currentString.substring(33, currentString.length());
                System.out.println(Parser.ingridientName);
                Parser.size++;
            }

        } catch (java.net.MalformedURLException e2) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e1) {
        }
    }
}
