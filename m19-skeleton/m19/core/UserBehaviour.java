package m19.core;

import java.io.Serializable;

public enum UserBehaviour implements Serializable {
    NORMAL("NORMAL"),
    CUMPRIDOR("CUMPRIDOR"),
    FALTOSO("FALTOSO");

    private static final long serialVersionUID = 201901101348L;

    private String _behaviour;

     UserBehaviour(String behaviour){
        _behaviour = behaviour;
    }

    String getBehaviour(){
         return _behaviour;
    }
}
