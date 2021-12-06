/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.ktepin.expertjava.app.presenter;

import clara.rules.engine.ISession;

/**
 *
 * @author ktepin
 */
public class MainDialogPresenter{ 
    
    private IMainScreenView mainScreenView;
    private ISession claraSession;
    private String state;
    
    public MainDialogPresenter(IMainScreenView mainView) {
        this.mainScreenView = mainView;
        
        mainView.addStartListener(() -> {
            onClickStart();
        });
        
        mainView.addAnswerListener(new IMainScreenView.OnAnswerEventHandler() {
            @Override
            public void handleAnswer(Boolean ans) {
                onAnswer(ans);
            }
        });
    }
    
    private void onClickStart(){
        this.claraSession = (ISession) clojure_expert_kt.core.createsession();
        String newQuestion = clojure_expert_kt.core.getnextquestion(this.claraSession);
        this.mainScreenView.displayDialogText(newQuestion);
        System.out.println("Session created");
    }
    
    private void onAnswer(Boolean answer){
        if(this.claraSession != null){
            String status = clojure_expert_kt.core.checkstate(this.claraSession);
            if(status == "ANSWER_MORE"){
                this.claraSession = (ISession) clojure_expert_kt.core.answernextquestion(this.claraSession, answer);
                String statusNext = clojure_expert_kt.core.checkstate(this.claraSession);
                switch(statusNext){
                    case ("ANSWER_MORE"):
                        String newQuestion = clojure_expert_kt.core.getnextquestion(this.claraSession);
                        this.mainScreenView.displayDialogText(newQuestion);
                        break;
                    case ("NOT_FOUND"):
                        this.mainScreenView.displayNotFound();
                        break;
                    default:
                        this.mainScreenView.displayResult(statusNext);
                }
           
            }
          
        }
    }
}
