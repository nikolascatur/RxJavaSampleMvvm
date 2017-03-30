package phone.nikolas.com.rxjavasamplemvvm.model;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Pleret on 3/27/2017.
 */

public class Notes {
//    @Inject
    private List<Note> noteList;

    public Notes(){
        noteList = new ArrayList<Note>();
    }


    public void addNote(String text){
        int id = noteList.size();
        noteList.add(new Note(id,text));
    }

//    @Inject
    public List<Note> getNoteList(){
        return noteList;
    }

}
