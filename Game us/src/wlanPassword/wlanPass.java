package wlanPassword;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class wlanPass {
    public static void main(String[] args) throws IOException {
        Process c = Runtime.getRuntime().exec("netsh wlan show profile");
        InputStream in = c.getInputStream();
        String sb = getResultInputStream(in);
        ArrayList<String> name = getTheNameWlan(sb);
        Wlan wlan = getWlan(name.get(0));
        ArrayList<Wlan> wlans = new ArrayList<>();
        for (String n : name) {
            wlans.add(getWlan(n));
        }
        File x = new File("C:\\Users\\pc\\Desktop\\wlanPass.txt");
        FileWriter cc = new FileWriter(x);
        StringBuilder wlansPass = new StringBuilder();
        for (Wlan w : wlans) {
            wlansPass.append(w.toString());
            cc.write(w.toString() + "\n");
        }
        cc.close();
       


    }

    private static Wlan getWlan(String name) throws IOException {
        Process c2 = Runtime.getRuntime().exec("netsh wlan show profile \"" + name + "\" key=clear");
        String sb2 = getResultInputStream(c2.getInputStream());
        String pass = "";
        String[] temp = sb2.split("\n");
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].contains("Key Content")) {
                pass = temp[i].split(":")[1].trim();
            }
        }
        Wlan wlan = new Wlan(name, pass);
        return wlan;
    }

    private static ArrayList<String> getTheNameWlan(String sb) {
        ArrayList<String> nameWlan = new ArrayList<>();
        String[] temp = sb.split("\n");
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].contains("All User Profile")) {
                String x = temp[i].split(":")[1].trim();
                nameWlan.add(x);
            }
        }
        return nameWlan;
    }

    private static String getResultInputStream(InputStream in) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int ch; (ch = in.read()) != -1; ) {
            sb.append((char) ch);
        }
        return sb.toString();
    }
}

class Wlan {
    String name;
    String pass;

    public Wlan(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "wlan{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
