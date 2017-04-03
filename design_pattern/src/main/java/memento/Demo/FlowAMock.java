package memento.Demo;

import lombok.Getter;

/**
 * Created by wjk on 16/7/8.
 */
public class FlowAMock {
    private String flowName;
    private int tempResult;
    private String tempState;

    public FlowAMock(String flowName) {
        this.flowName = flowName;
    }

    public void runPhaseOne(){
        tempResult = 3;
        tempState = "phaseOne";
    }
    public void schema1(){
        this.tempState += ",Schema1";
        System.out.println(this.tempState+":now run " + tempResult);
        this.tempResult += 11;
    }

    public void schema2(){
        this.tempState += ",Schema2";
        System.out.println(this.tempState+":now run " + tempResult);
        this.tempResult += 22;
    }

    public FlowAMockMemento createMemento(){
        return new MementoImpl(this.tempResult,this.tempState);
    }

    public void setMemento(FlowAMockMemento memento){
        MementoImpl mementoImpl = (MementoImpl) memento;
        this.tempResult = mementoImpl.getTempResult();
        this.tempState = mementoImpl.getTempState();
    }

    /**
     * 真正的备忘录对象,实现备忘录窄接口
     * 实现成为私有内部类
     */
    private static class MementoImpl implements FlowAMockMemento{
        @Getter
        private int tempResult;
        @Getter
        private String tempState;

        public MementoImpl(int tempResult, String tempState) {
            this.tempResult = tempResult;
            this.tempState = tempState;
        }
    }
}
