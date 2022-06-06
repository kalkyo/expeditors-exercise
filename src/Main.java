import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This is the main driver class that takes in the input.csv containing occupant information
 * The information is taking through an input stream scanner and converted into an occupant object
 * @author Peter Eang
 * @version 1.0
 */
public class Main
{

    // Age check field is used to check the age of an occupant
    public static final int AGE_CHECK = 13;

    /**
     * This method takes in a new file containing the csv
     * then creating an array list of occupant objects
     * there are currently 4 households and their fields are
     * initialized
     *
     * a try catch is done for file exceptions searching for the csv file
     * if found the input stream goes through each line occupying a new
     * string array adding in the parts for a new Occupant object
     *
     * A call to collections to compare the results are done to provide the output
     * result being sorted by this order of household address, state, last name,
     * and first name
     *
     * counting the household occupants are then done in a call
     * to the method houseHoldCount passing in the list of occupants
     * and the 4 address fields
     *
     * an ageCheck call is done with the passed in occupants
     * this is done so any occupant under 13 is not shown in the results
     * @param args test input.csv
     */
    public static void main(String[] args)
    {
        File file = new File("input.csv");
        ArrayList<Occupant> occupants = new ArrayList<>();

        //Below are zeroed out fields for the addresses in the csv file
        //There being four start out zero and go up as counted
        int address123WA = 0;
        int address2342NDWA = 0;
        int address2342NDFL = 0;
        int address3453RD = 0;

        try
        {
            Scanner inputStream = new Scanner(file);

            while (inputStream.hasNext())
            {
                String line = inputStream.nextLine();
                String[] occupantInfo = line.split(",");
                occupants.add(new Occupant(occupantInfo[0], occupantInfo[1],
                        occupantInfo[2].replace(".", ""), occupantInfo[3], occupantInfo[4], occupantInfo[5],
                        Integer.parseInt(occupantInfo[6])));
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        Collections.sort(occupants);
        houseHoldCount(occupants, address123WA, address2342NDWA, address2342NDFL, address3453RD);

        ageCheck(occupants);

        System.out.println(occupants);


    }

    /*
     * Check the age of all occupants and remove them
     * from the array if they are under 13
     */
    private static void ageCheck(ArrayList<Occupant> occupants)
    {
        for (int i = 0; i < occupants.size(); i++)
        {
            if (occupants.get(i).getAge() <= AGE_CHECK)
            {
                occupants.remove(i);
            }
        }
    }

    /*
     * Check the address of all occupants and remove increased
     * the count for their respected addresses fields if they match
     * Then an output of the household including how many occupants
     * are there currently
     */
    private static void houseHoldCount(ArrayList<Occupant> occupants, int address123WA,
                                       int address2342NDWA, int address2342NDFL, int address3453RD)
    {
        for (Occupant occupant : occupants)
        {
            if (occupant.getAddress().contains(("123 MAIN")) && occupant.getState().equals("WA"))
            {
                address123WA++;
            }
            if (occupant.getAddress().contains(("234 2ND")) && occupant.getState().equals("WA"))
            {
                address2342NDWA++;
            }
            if (occupant.getAddress().contains(("234 2ND")) && occupant.getState().equals("FL"))
            {
                address2342NDFL++;
            }
            if (occupant.getAddress().contains(("345 3RD BLVD")) && occupant.getState().equals("WA"))
            {
                address3453RD++;
            }
        }
        System.out.println("123 MAIN ST, WA Household number of occupants :" + address123WA);
        System.out.println("234 2ND AVE, WA Household number of occupants :" + address2342NDWA);
        System.out.println("234 2ND AVE, FL Household number of occupants :" + address2342NDFL);
        System.out.println("345 3RD BLVD, WA Household number of occupants :" + address3453RD);
    }

}
