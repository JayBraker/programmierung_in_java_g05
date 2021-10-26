import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


/**
 * @author Martin Albertz, Selina Fiorin, Josha Bartsch
 *
 */
public class EMailAdressBuch
{
    private HashMap<String, String> userList;
    private Scanner sc;

    /**
     * Basic constructor initializes the HashMap.
     */
    public EMailAdressBuch()
    {
        userList = new HashMap<>(); // legt eine neue hasMap An
    }

    /**
     * Copy-constructor copies the originals HashMap storing names and addresses.
     * 
     * @param e the EmailAdressBuch object to be copied
     */
    public EMailAdressBuch(EMailAdressBuch e)
    {
        this.userList = e.userList;
    }

    /**
     * Method einfuegen adds the supplied name, address tuple into the HashMap. if
     * there is already an entry with the same name, it is simply overwritten and
     * only the email is updated.
     * 
     * @param name supplied name String.
     * @param email supplied address String.
     */
    public void einfuegen(String name, String email)
    {
        /*
         * Because of the nature of a HashMap it is not necessary to check whether a
         * name already exists as a Key: If the name does not yet exist as a key in the
         * HashMap, a new key-value entry will be entered. However if the key already
         * exists, the corresponding value will be overwritten by calling userList.put
         * anyway.
         */
        this.userList.put(name, email);
    }

    /**
     * Checks if the supplied entry is already in the list, if so, it will return
     * "true" otherwise it will return "false
     * 
     * @param name
     * @return
     */
    private boolean nameIstVorhanden(String name)
    {
        if (userList.containsKey(name)) // wenn name schon vorhanden ist
        {
            return true;
        } // gib "true" zurueck
        return false; // falls nicht, gib "false" zurueck
    }

    /**
     * Method abfrage returns the address associated to a given name String. Throws
     * a custom exception if the name is not stored in the HashMap.
     * 
     * @param name supplied name String.
     * @return the email associated with the given name as a String.
     */
    public String abfrage(String name)
    {
        if (!nameIstVorhanden(name)) // wenn nicht vorhanden, throw exception
        {
            throw new UnknownNameException(
                    String.format("Kein Eintrag auf den Namen %s", name));
        } else
        {
            return userList.get(name);
        } // wenn Vorhanden, liefert die E-Mail-Adresse zum gegebenen Namen
    }

    /**
     * Custom toString Method joins every key-value entry in the HashMap to the
     * following format: {name1=address1, name2=address2, ...}
     * 
     * @return a String with all the entries in the mentioned Format
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder("");
        builder.append("{");
        if (!userList.isEmpty()) // wenn nicht leer
        {
            for (String s : userList.keySet()) // fuer jeden eintrag mache
            {
                builder.append(s); // hole den namen der person
                builder.append("="); // haenge ein "=" dran
                builder.append(userList.get(s)); // haenge die email dran
                builder.append(", "); // komma und leerzeichen
            }
            builder.delete(builder.length() - 2, builder.length()); // Leerzeichen und komma wird entfernt, wenn am ende.
        }
        builder.append("}"); // "}" dranhaengen
        return builder.toString(); // ausgeben
    }

    /**
     * Method einlesen attempts to read a specified textfile. Expects one
     * name;address tuple per line. Results in a FileNotFoundException if the
     * supplied String was not valid.
     * 
     * @param dateiname supplied String must be an absolute Path to file.
     */
    public void einlesen(String dateiname) throws FileNotFoundException
    {
        sc = new Scanner(new File(dateiname)); // scanner auf datei setzen
        while (sc.hasNextLine() == true) // solange es noch eine naechste zeile gibt
        {
            String s = sc.nextLine(); // hole die naechste zeile
            String[] sa = s.split(";"); // Teile den String um ";" auf
            userList.put(sa[0], sa[1]); // mappe die sachen (sa[0] = name, sa[1]= email)
        }
        sc.close(); // wenn fertig, schließe scanner
    }
}
