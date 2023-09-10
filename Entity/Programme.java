/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author acerc
 */
import ADT.LinkedList;
import ADT.ListIterator;

public class Programme implements Comparable<Programme>{
    private String progName;
    private String eduLvl;
    private String eduName;
    private String progID;
    private LinkedList<TutorialGrp> tutGrp;
    private ListIterator<TutorialGrp> iterator;
    
    public Programme(String progName, String eduLvl) {
        this.progName = progName;
        this.eduLvl = eduLvl;
        this.tutGrp = new LinkedList<>();
    }
    
    public Programme(String progName, String eduLvl, String progID) {
        this.progName = progName;
        this.eduLvl = eduLvl;
        this.progID = progID;
        this.tutGrp = new LinkedList<>();
    }
    
    public Programme(String progID){
        this.progID = progID;
    }
    
    
    
    public String getProgName() {
        return progName;
    }

    public void setProgName(String progName) {
        this.progName = progName;
    }

    public String getEduLvl() {
        return eduLvl;
    }

    public void setEduLvl(String eduLvl) {
        this.eduLvl = eduLvl;
    }

    public String getEduName() {
        return eduName;
    }

    public void setEduName(String eduName) {
        this.eduName = eduName;
    }
    
    public String getProgID() {
        return progID;
    }

    public void setProgID(String progID) {
        this.progID = progID;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Programme that = (Programme) o;
        return progID.equals(that.progID);
    }
    
    @Override
    public int compareTo(Programme A){
        return (this.progID).compareTo(A.progID);
    }
    public int compareEdu(Programme A){
        return (this.eduName).compareTo(A.eduName);
    }
    
    @Override
    public String toString() {
        return progID; // + ", " + eduName + " in " + progName;
    }
    public void addTutorialGroup(TutorialGrp tutGrp){
        this.tutGrp.addFirst(tutGrp);
    }
    public void removeTutorialGroup(TutorialGrp tutGrp){
        this.tutGrp.remove(tutGrp);
    }
}


