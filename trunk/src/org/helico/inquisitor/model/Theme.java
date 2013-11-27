package org.helico.inquisitor.model;

/**
 * Created with IntelliJ IDEA.
 * User: ddreval
 * Date: 27.11.13
 * Time: 17:18
 * To change this template use File | Settings | File Templates.
 */
public class Theme {

    private long id;

    private String name;

    public Theme(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
