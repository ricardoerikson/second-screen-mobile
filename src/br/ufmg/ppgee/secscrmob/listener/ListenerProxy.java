package br.ufmg.ppgee.secscrmob.listener;

import java.util.Map;

public interface ListenerProxy {
    
    @InteractionMapping(uri = "/users/evaluation", method = RequestMethod.POST)
    public void captureUserEvaluation(Map<String, Object> payload);

}
