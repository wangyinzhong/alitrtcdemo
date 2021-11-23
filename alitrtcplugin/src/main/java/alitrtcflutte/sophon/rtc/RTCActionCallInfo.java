package alitrtcflutte.sophon.rtc;


import alitrtcflutte.sophon.listener.ActionControlPanelListener;

public class RTCActionCallInfo {
    private ActionControlPanelListener controlPane;

    public RTCActionCallInfo(ActionControlPanelListener controlPane){
        this.controlPane=controlPane;
    }

    public void callWithdraw(){
        controlPane.onWithdraw();
    }
}
