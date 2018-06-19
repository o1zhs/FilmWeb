package Bean;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

public class Firm {
    private Boolean isNull = true;
    private String firmID;
    private String firmName;
    private String city;
    private List<String> filmNamelist = new ArrayList<>();

    public Firm(String firmID, String firmName, String city,List<String> filmNamelist){
        this.firmID = firmID;
        this.firmName = firmName;
        this.city = city;
        this.filmNamelist = filmNamelist;
        this.isNull = false;
    }

    public String getFirmID() {
        return firmID;
    }

    public String getFirmName() {
        return firmName;
    }

    public String getCity() {
        return city;
    }

    public List<String> getFilmNamelist() {
        return filmNamelist;
    }

    public Boolean getNull() {
        return isNull;
    }
}
