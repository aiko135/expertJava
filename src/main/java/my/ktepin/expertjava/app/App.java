/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.ktepin.expertjava.app;

import java.util.concurrent.Callable;
import my.ktepin.expertjava.app.presenter.MainDialogPresenter;
import my.ktepin.expertjava.app.view.MainForm;

/**
 *
 * @author ktepin
 */
public class App {
    
    private static MainForm form;
    private static MainDialogPresenter mainPresenter;
    
    public static void main(String args[]) {
        
         App.form = new Callable<MainForm>(){
            public MainForm call() {
                MainForm form = new MainForm();
                form.setVisible(true);
                return form;
            }
        }.call();
        
        App.mainPresenter = new MainDialogPresenter(form);
        
        clojure_expert_kt.core.main(args);
  
    }
    
}
