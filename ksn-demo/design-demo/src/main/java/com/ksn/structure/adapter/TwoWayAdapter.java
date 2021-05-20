package com.ksn.structure.adapter;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/20 9:54
 */
public class TwoWayAdapter implements TwoWayTarget,TwoWayAdaptee{
    private TwoWayTarget target;
    private TwoWayAdaptee adaptee;
    public TwoWayAdapter(TwoWayTarget target)
    {
        this.target=target;
    }
    public TwoWayAdapter(TwoWayAdaptee adaptee)
    {
        this.adaptee=adaptee;
    }
    @Override
    public void request()
    {
        adaptee.specificRequest();
    }
    @Override
    public void specificRequest()
    {
        target.request();
    }

    public static void main(String[] args)
    {
        System.out.println("目标通过双向适配器访问适配者：");
        TwoWayAdaptee adaptee=new AdapteeRealize();
        TwoWayTarget target=new TwoWayAdapter(adaptee);
        target.request();
        System.out.println("-------------------");
        System.out.println("适配者通过双向适配器访问目标：");
        target=new TargetRealize();
        adaptee=new TwoWayAdapter(target);
        adaptee.specificRequest();
    }
}
