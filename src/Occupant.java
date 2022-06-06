/**
 * This Occupant class holds the information for occupants
 * and also the logic for sorting occupants
 * @author Peter Eang
 * @version 1.0
 */
public class Occupant implements Comparable<Occupant>
{
    private String fName;
    private String lName;
    private String address;
    private String apartment;
    private String city;
    private String state;
    private int age;

    /**
     * @param fName first name of current occupant
     * @param lName  last name of current occupant
     * @param address address of current occupant
     * @param apartment  apartment number of current occupant some occupants do not have one
     * @param city city of current occupant
     * @param state state of current occupant
     * @param age age of current occupant
     */
    public Occupant(String fName, String lName, String address, String apartment, String city, String state, int age)
    {
        this.fName = fName.toUpperCase();
        this.lName = lName.toUpperCase();
        this.address = address.toUpperCase();
        this.apartment = apartment;
        this.city = city;
        this.state = state.toUpperCase();
        this.age = age;
    }

    /**
     * @return current occupants address they reside at
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * @return current occupants state they reside at
     */
    public String getState()
    {
        return state;
    }

    /**
     * @return current occupants age
     */
    public int getAge()
    {
        return age;
    }

    @Override
    public String toString()
    {
        return "Occupant{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", address='" + address + '\'' +
                ", apartment='" + apartment + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", age=" + age + "\n";
    }

    @Override
    public int compareTo(Occupant other)
    {
        int result = address.compareTo(other.address);
        if (result != 0)
        {
            return result;
        }
        result = lName.compareTo(other.lName);
        if (result != 0)
        {
            return result;
        }
        result = fName.compareTo(other.fName);
        if (result != 0)
        {
            return result;
        }
        return state.compareTo(other.state);
    }
}
