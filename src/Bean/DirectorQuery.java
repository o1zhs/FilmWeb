package Bean;

public class DirectorQuery {
    private String PersonName;
    private String PersonBirth;
    private String FilmName;

    public DirectorQuery(String PersonName, String PersonBirth, String FilmName) {
        this.PersonName = PersonName;
        this.PersonBirth = PersonBirth;
        this.FilmName = FilmName;
    }

    public String getPersonName() {
        return this.PersonName;
    }
}
