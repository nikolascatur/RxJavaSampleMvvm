package phone.nikolas.com.rxjavasamplemvvm.model;

/**
 * Created by Pleret on 3/22/2017.
 */

public class Note {
    private int Id;
    private String noteDetail;

    public Note(int id,String noteDetail){
        this.Id = id;
        this.noteDetail = noteDetail;

    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNoteDetail() {
        return noteDetail;
    }

    public void setNoteDetail(String noteDetail) {
        this.noteDetail = noteDetail;
    }
}
