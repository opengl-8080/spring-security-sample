package sample.servlet;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class Counter implements Serializable {
    
    private long n;
    
    public long get() {
        return this.n;
    }
    
    public void increment() {
        this.n++;
    }
}
