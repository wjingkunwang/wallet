package memento.prototype;

/**
 * 在原发器对象创建备忘录对象的时候，
 * 如果原发器对象中全部或者大部分的状态都需要保存，
 * 一个简洁的方式就是直接克隆一个原发器对象。也就是说，
 * 这个时候备忘录对象里面存放的是一个原发器对象的实例。
 */
public class FlowAMockPrototype implements Cloneable {
    private String flowName;
    private int tempResult;
    private String tempState;

    public FlowAMockPrototype(String flowName) {
        this.flowName = flowName;
    }

    public void runPhaseOne() {
        //在这个阶段，可能产生了中间结果，示意一下
        tempResult = 3;
        tempState = "PhaseOne";
    }

    public void schema1() {
        //示意，需要使用第一个阶段产生的数据
        this.tempState += ",Schema1";
        System.out.println(this.tempState
                + " : now run " + tempResult);
        this.tempResult += 11;
    }

    public void schema2() {
        //示意，需要使用第一个阶段产生的数据
        this.tempState += ",Schema2";
        System.out.println(this.tempState
                + " : now run " + tempResult);
        this.tempResult += 22;
    }

    /**
     * 创建保存原发器对象的状态的备忘录对象
     *
     * @return 创建好的备忘录对象
     */
    public FlowAMockMemento createMemento() {
        try {
            return new MementoImplPrototype(
                    (FlowAMockPrototype) this.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 重新设置原发器对象的状态，让其回到备忘录对象记录的状态
     *
     * @param memento 记录有原发器状态的备忘录对象
     */
    public void setMemento(FlowAMockMemento memento) {
        MementoImplPrototype mementoImpl =
                (MementoImplPrototype) memento;
        this.tempResult = mementoImpl.getFlowAMock().tempResult;
        this.tempState = mementoImpl.getFlowAMock().tempState;
    }

    /**
     * 真正的备忘录对象，实现备忘录窄接口，实现成私有的内部类，不让外部访问
     */
    private static class MementoImplPrototype
            implements FlowAMockMemento {
        private FlowAMockPrototype flowAMock = null;

        public MementoImplPrototype(FlowAMockPrototype f) {
            this.flowAMock = f;
        }

        public FlowAMockPrototype getFlowAMock() {
            return flowAMock;
        }
    }
}