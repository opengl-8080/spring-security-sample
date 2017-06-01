package sample.servlet;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class Values implements Serializable {
    
    private List<String> list = new ArrayList<>();
    
    public void add(String value) {
        this.list.add(value);
    }
    
    public List<String> get() {
        return new ArrayList<>(this.list);
    }
}
