package Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 电影类
 *
 */

public class Film {
    private String filmID;          //电影编号
    private String filmName;        //电影名称
    private String publishYear;     //发行年份
    private String publishFirm;     //发行公司
    private String firmID;          //发行公司ID
    private String length;          //电影时长
    private List<String> categoryList = new ArrayList<>();      //电影类别
    private List<Person> director;      //导演
    private List<Person> actor;         //演员
    private List<Person> voice;         //旁白
    private String plot;            //电影情节


    public Film(String filmID, String filmName, String publishYear, String publishFirm, String length, List<String> categoryList,
                List<Person> director, List<Person> actor, List<Person> voice, String plot){
        this.filmID = filmID;
        this.filmName = filmName;
        this.publishYear = publishYear;
        this.publishFirm = publishFirm;
        this.length = length;
        this.categoryList = categoryList;
        this.director = director;
        this.actor = actor;
        this.voice = voice;
        this.plot = plot;
    }

    public String getFilmID() {

        return filmID;
    }

    public String getFilmName() {
        return filmName;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public String getPublishFirm() {
        return publishFirm;
    }

    public String getLength() {
        return length;
    }


    public String getPlot() {
        return plot;
    }

    public List<String> getCategoryList() {
        return categoryList;
    }

    public List<Person> getDirector() {
        return director;
    }

    public List<Person> getActor() {
        return actor;
    }

    public List<Person> getVoice() {
        return voice;
    }
}
