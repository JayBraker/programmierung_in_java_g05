public class Test
{
    public static void main(String[] args)
    {
        try {
            EMailAdressBuch extern = new EMailAdressBuch();
            EMailAdressBuch intern = new EMailAdressBuch();
        
            extern.einlesen("mitarbeiter_matse_extern.txt");
            intern.einlesen("mitarbeiter_matse_intern.txt");
            System.out.println(extern.toString());
            System.out.println(intern.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
