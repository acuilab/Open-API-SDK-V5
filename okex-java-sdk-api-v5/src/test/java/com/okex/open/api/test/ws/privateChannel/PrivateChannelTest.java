package com.okex.open.api.test.ws.privateChannel;


import com.okex.open.api.test.ws.privateChannel.config.WebSocketClient;
import com.okex.open.api.test.ws.privateChannel.config.WebSocketConfig;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrivateChannelTest {
    private static final WebSocketClient webSocketClient = new WebSocketClient();
    private static Logger logger = Logger.getLogger(PrivateChannelTest.class);

    @Before
    public void connect() {
        WebSocketConfig.loginConnect(webSocketClient);

    }


    @After
    public void close() {
        System.out.println(Instant.now().toString() + "Private channels close connect!");
        WebSocketClient.closeConnection();
    }

    /**
     * 账户频道
     * Account Channel
     */
    @Test
    public void privateAccountChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map accountMap =new HashMap();

           accountMap.put("channel","account");
           accountMap.put("ccy","USDT");

        channelList.add(accountMap);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 持仓频道
     * Positions Channel
     */
    @Test
    public void privatePositionsChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map positionsMap =new HashMap();

        positionsMap.put("channel","positions");
        positionsMap.put("instType","SWAP");
        positionsMap.put("uly","XRP-USDT");
        positionsMap.put("instId","XRP-USDT-SWAP");

        channelList.add(positionsMap);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 账户余额和持仓频道
     * Balance and Position Channel
     */
    @Test
    public void privateBalanceAndPositionChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map orderMap =new HashMap();

        orderMap.put("channel","balance_and_position");

        channelList.add(orderMap);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 订单频道
     * Order Channel
     */
    @Test
    public void privateOrderChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map orderMap =new HashMap();

        orderMap.put("channel","orders");
        orderMap.put("instType","SWAP");
        orderMap.put("uly","XRP-USDT");
        orderMap.put("instId","XRP-USDT-SWAP");

        channelList.add(orderMap);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 策略委托订单频道
     * Algo Orders Channel
     */
    @Test
    public void privateAlgoOrdersChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map algoOrders =new HashMap();

        algoOrders.put("channel","orders-algo");
        algoOrders.put("instType","FUTURES");
        algoOrders.put("uly","BTC-USDT");
        algoOrders.put("instId","BTC-USDT-210625");

        channelList.add(algoOrders);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 高级策略委托订单频道
     * Advance Algo Orders Channel
     */
    @Test
    public void privateAlgoAdvanceOrdersChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map algoOrders =new HashMap();

        algoOrders.put("channel","algo-advance");
        algoOrders.put("instType","SWAP");
        algoOrders.put("instId","BTC-USDT-SWAP");
//        algoOrders.put("algoId","");

        channelList.add(algoOrders);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 爆仓风险预警推送频道
     * Position risk warning
     */
    @Test
    public void positionRiskWarningChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map liquidationWarning =new HashMap();

        liquidationWarning.put("channel","liquidation-warning");
        liquidationWarning.put("instType","SWAP");
        liquidationWarning.put("uly","BTC-USDT");
        liquidationWarning.put("instId","BTC-USDT-SWAP");

        channelList.add(liquidationWarning);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 账户greeks频道
     * account-greeks
     * 获取账户资产的greeks信息，首次订阅按照订阅维度推送数据，此外，当增加或者减少币种余额、持仓数量等事件触发时，推送数据以及按照订阅维度定时推送数据
     */
    @Test
    public void accountGreeks() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map accountGreeks =new HashMap();

        accountGreeks.put("channel","account-greeks");
        accountGreeks.put("ccy","USDT");


        channelList.add(accountGreeks);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //取消订阅
    @Test
    public void unsubscribeChannel() {
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","balance_and_position");
        map.put("instId","BTC-USD-210924");
        channelList.add(map);
        WebSocketClient.unsubscribe(channelList);
        //为保证收到服务端返回的消息，需要让线程延迟
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
