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
     * Basic constructor initializes the HashMap.
     * 
     */
    public EMailAdressBuch()
    {
        this.userList = new HashMap<>();
    }

    /**
     * Copy-constructor copies the originals HashMap storing names and addresses.
     * 
     * @param the original object to be copied
     */
    public EMailAdressBuch(EMailAdressBuch e)
    {
        this.userList = e.userList;
    }

    /**
     * Method einfuegen enters a supplied name, address tuple into the HashMap.
     * Because of the nature of a HashMap it is not necessary to check whether a name already exists as a Key:
     * If the name does not yet exist as a key in the HashMap, a new key-value entry will be entered.
     * However if the key already exists, the corresponding value will be overwritten by calling userList.put anyway.
     * 
     * @param name supplied name String.
     * @param email supplied address String.
     */
    public void einfuegen(String name, String email)
    {
        /* 
        * Because of the nature of a HashMap it is not necessary to check whether a name already exists as a Key:
        * If the name does not yet exist as a key in the HashMap, a new key-value entry will be entered.
        * However if the key already exists, the corresponding value will be overwritten by calling userList.put anyway.
        */
        this.userList.put(name, email);
    }

    /**
     * Method abfrage returns the address associated to a given name String. Throws
     * a custom exception if the name is not stored in the HashMap.
     * 
     * @param name supplied name String.
     * @return address String.
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
     * Custom toString Method joins every key-value entry in the HashMap to the
     * following format: {name1=address1, name2=address2, ...}
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
     * Method einlesen attempts to read a specified textfile. Expects one
     * name;address tuple per line.
     * 
     * @param dateiname supplied String must be absolute Path to file.
     * @throws FileNotFoundException if supplied String was not valid.
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
                this.einfuegen(entry[0], entry[1]);
            }
        }
        sc.close();
    }
}
