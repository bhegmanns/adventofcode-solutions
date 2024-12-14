package de.hegmanns.training.aoc2022;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;

//@AInputData(year = 2022, day = 12)
public class ReaderTestForDay12 {

    public static void main(String[] args) throws IOException {
        System.out.println(">>>" + System.getenv("aoc_token"));//AOC_TOKEN

        CookieManager manager = new CookieManager();
        manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieStore store = manager.getCookieStore();

        System.out.println("COOKIES:");
        for (HttpCookie cookie : store.getCookies()) {
            System.out.println("" + cookie.getName() + " = " + cookie.getValue());
        }
        System.out.println("====");
        //AInputData annotation = ReaderTestForDay12.class.getAnnotation(AInputData.class);
        //InputHelper inputHelper = new InputHelper(annotation);
        //BufferedReader input1 = inputHelper.getInput();
        String line = null;
/*
        while ((line = input1.readLine()) != null) {
            System.out.println(line);
        }

 */

    }
}
