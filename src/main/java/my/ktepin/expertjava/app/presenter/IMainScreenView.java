/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.ktepin.expertjava.app.presenter;

/**
 *
 * @author ktepin
 */
public interface IMainScreenView {        
    public interface OnClickStartEventHandler{
        void handleClick();
    }
    
    public interface OnAnswerEventHandler{
        void handleAnswer(Boolean ans);
    }
    
    public void addStartListener(OnClickStartEventHandler handler);
    public void addAnswerListener(OnAnswerEventHandler handler);
    
    public void displayDialogText(String text);
    public void displayNotFound();
    public void displayResult(String result);
}