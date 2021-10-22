package abgabe3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Martin Albertz, Selina Fiorin, Josha Bartsch
 *
 */

public class EMailAdressBuch
{
    private final HashMap<String, String> userList;

    /**
     * 
     * 
     * 
     */
    public EMailAdressBuch()
    {
        this.userList = new HashMap<>();
    }

    public EMailAdressBuch(EMailAdressBuch e)
    {
        this.userList = e.userList;
    }

    /**
     * @param name
     * @param email
     */
    public void einfügen(String name, String email)
    {
        this.userList.put(name, email);
    }

    /**
     * @param name
     * @return
     */
    public String abfrage(String name)
    {
        if (!this.userList.containsKey(name))
        {
            throw new UnknownNameException(
                    String.format("Kein Eintrag auf den Namen %s", name));
        }
        return this.userList.get(name);
    }

    /**
     *
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder("");
        builder.append("{");
        if (!userList.isEmpty())
        {
            for (String s : userList.keySet())
            {
                builder.append(s);
                builder.append("=");
                builder.append(userList.get(s));
                builder.append(", ");
            }
            builder.delete(builder.length() - 2, builder.length());
        }
        builder.append("}");
        return builder.toString();
    }

    /**
     * @param dateiname
     * @throws FileNotFoundException
     */
    public void einlesen(String dateiname) throws FileNotFoundException
    {
        File source = new File(dateiname);
        Scanner sc = new Scanner(source);

        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            if (!line.isBlank())
            {
                String[] entry = line.split(";");
                this.einfügen(entry[0], entry[1]);
            }
        }
        sc.close();
    }
}
