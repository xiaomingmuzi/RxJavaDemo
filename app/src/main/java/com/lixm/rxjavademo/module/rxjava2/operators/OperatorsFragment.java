package com.lixm.rxjavademo.module.rxjava2.operators;

import android.content.Intent;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.model.OperatorModel;
import com.lixm.rxjavademo.module.rxjava2.CatagoryBaseFragment;
import com.lixm.rxjavademo.module.rxjava2.operators.item.RxBufferActivity;
import com.lixm.rxjavademo.module.rxjava2.operators.item.RxConcatActivity;
import com.lixm.rxjavademo.module.rxjava2.operators.item.RxConcatMapActivity;
import com.lixm.rxjavademo.module.rxjava2.operators.item.RxCreateActivity;
import com.lixm.rxjavademo.module.rxjava2.operators.item.RxDistinctActivity;
import com.lixm.rxjavademo.module.rxjava2.operators.item.RxFilerActivity;
import com.lixm.rxjavademo.module.rxjava2.operators.item.RxFlatMapActivity;
import com.lixm.rxjavademo.module.rxjava2.operators.item.RxMapActivity;
import com.lixm.rxjavademo.module.rxjava2.operators.item.RxTimerActivity;
import com.lixm.rxjavademo.module.rxjava2.operators.item.RxZipActivity;

import java.util.ArrayList;

/**
 * @author Lixm
 * @date 2018/6/21 13:35
 * @detail
 */

public class OperatorsFragment extends CatagoryBaseFragment {
    @Override
    protected void fillData() {
        data=new ArrayList<>();
        data.add(new OperatorModel(getString(R.string.rx_create),"0、可用于获取一个被观察的对象"));
        data.add(new OperatorModel(getString(R.string.rx_zip),"1、合并事件专用，" +
                "分别从两个上有时间中取出一个组合，" +
                "一个事件只能被使用一次，" +
                "顺序严格按照时间发送的顺序，" +
                "最终下游事件收到的是和上游事件最少的数目相同（必须两两配对，多余的舍弃）"));
        data.add(new OperatorModel(getString(R.string.rx_map),"2、基本是RxJava最简单的操作符了，作用是对上游发送的每一个事件应用一个函数，" +
                "使得每一个事件都按照指定的函数去变化"));
        data.add(new OperatorModel(getString(R.string.rx_flatMap),"3、Flatmap将一个发送事件的上游Obervable变换成多个发送事件Observables，" +
                "然后将它们发射的时间合并后放进一个单的Obervable里"));
        data.add(new OperatorModel(getString(R.string.rx_concatMap),"4、concatMap作用和flatMap几乎一模一样，唯一的区别是他能保证事件的顺序"));
        data.add(new OperatorModel(getString(R.string.rx_doOnNext),"5、让订阅者在接收到数据前干点事情的操作符"));
        data.add(new OperatorModel(getString(R.string.rx_filter),"6、过滤操作符，取正确的值"));
        data.add(new OperatorModel(getString(R.string.rx_skip),"7、接受一个long型参数，代表跳过多少个"));
        data.add(new OperatorModel(getString(R.string.rx_take),"8、用于指定订阅者最多接受到多少数据"));
        data.add(new OperatorModel(getString(R.string.rx_timer),"9、在RxJava中timer操作符既可以延迟执行一段逻辑，也可以间隔执行一段逻辑\n" +
                "【注意】但在RxJava 2.x已经过时了，现在用interval操作符来间隔执行，详见RxIntervalActivity\n" +
                "timer和interval都默认执行在一个新线程上。"));
        data.add(new OperatorModel(getString(R.string.rx_interval),"10、间隔执行操作，默认在新线程"));
        data.add(new OperatorModel(getString(R.string.rx_just),"11、just操作符，和RxJava 1.x 没有什么区别，就是接受一个可变参数，依次发送"));
        data.add(new OperatorModel(getString(R.string.rx_single),"12、顾名思义，Single只会接受一个参数," +
                "而SingleOberver只会调用onError或者onSuccess"));
        data.add(new OperatorModel(getString(R.string.rx_concat),"13、连接操作符，可接受Obervable的可变参数，或者Observable的集合"));
        data.add(new OperatorModel(getString(R.string.rx_distinct),"14、去重操作符，其实就是简单的去重"));
        data.add(new OperatorModel(getString(R.string.rx_buffer),"15、buffer(count,skip) 从定义就差不多能看出作用了，将Obervable中的数据" +
                "按skip（步长）分成最长不超过count的buffer，然后生成一个obervable"));
        data.add(new OperatorModel(getString(R.string.rx_debounce),"16、过滤掉发射速率过快的数据项"));
        data.add(new OperatorModel(getString(R.string.rx_defer),"17、就是在每次订阅的时候就会创建一个新的Obervable"));
        data.add(new OperatorModel(getString(R.string.rx_last),"18、取出最后一个值，参数是没有值的时候的默认值"));
        data.add(new OperatorModel(getString(R.string.rx_merge),"19、将多个Obervable合起来，接受可变参数，也支持使用迭代器集合"));
        data.add(new OperatorModel(getString(R.string.rx_reduce),"20、就是一次用一个方法处理一个值，可以有一个seed作为初始值"));
        data.add(new OperatorModel(getString(R.string.rx_scan),"21、和上面的reduce差不多，区别在于reduce()只输出结果，而scan()会将过程中的每一个结果输出"));
        data.add(new OperatorModel(getString(R.string.rx_window),"22、按照时间划分窗口，将数据发送给不同的Obervable"));
        data.add(new OperatorModel(getString(R.string.rx_PublishSubject),"23、onNext() 会通知给每个观察者，仅此而已"));
        data.add(new OperatorModel(getString(R.string.rx_AsyncSubject),"24、在调用onComplete()之前，除了subscribe()其他的操作都会被缓存，在调用onComplete()之后只有最后一个onNext()会生效"));
        data.add(new OperatorModel(getString(R.string.rx_BehaviorSubject),"25、BehaviorSubject的最后一个onNext()操作会被缓存，然后在subscribe()后立刻推给新注册Oberver"));
        data.add(new OperatorModel(getString(R.string.rx_Completable),"26、只关心结果，也就是说Completable是没有onNext的，要么成功要么出错，不关心过程，在subscribe后的某个时间点返回结果"));
        data.add(new OperatorModel(getString(R.string.rx_Flowable),"27、专用于解决背压问题"));

    }

    @Override
    protected void itemClick(int poisition) {
        switch (poisition){
            case 0:
                startActivity(new Intent(getActivity(),RxCreateActivity.class));
                break;
            case 1:
                startActivity(new Intent(getActivity(),RxZipActivity.class));
                break;
            case 2:
                startActivity(new Intent(getActivity(),RxMapActivity.class));
                break;
            case 3:
                startActivity(new Intent(getActivity(),RxFlatMapActivity.class));
                break;
            case 4:
                startActivity(new Intent(getActivity(),RxConcatMapActivity.class));
                break;
            case 6:
                startActivity(new Intent(getActivity(), RxFilerActivity.class));
                break;
            case 9:
                startActivity(new Intent(getActivity(), RxTimerActivity.class));
                break;
            case 13:
                startActivity(new Intent(getActivity(),RxConcatActivity.class));
                break;
            case 14:
                startActivity(new Intent(getActivity(), RxDistinctActivity.class));
                break;
            case 15:
                startActivity(new Intent(getActivity(), RxBufferActivity.class));
                break;
        }
    }
}
