/*
package com.jisen.rws;

import com.jisen.rws.entity.KeyValueEntity;
import com.jisen.rws.mapper.KeyValueMapper;
import com.jisen.rws.utils.NanoTimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringbootMycatApplicationTests {

    @Autowired
    KeyValueMapper keyValueMapper;

    private static AtomicInteger count = new AtomicInteger(0);

    @Test
    public void insertData(){

        long currentTimeMillis = System.currentTimeMillis();


        CountDownLatch countDownLatch = new CountDownLatch(3);
        Random rand = new Random(47);
        new Thread(()->{
            ArrayList<KeyValueEntity> keyValueEntitys = new ArrayList<>();
            for (int i = 0; i<100; i++){
                KeyValueEntity keyValueEntity = new KeyValueEntity();
                keyValueEntity.setId(NanoTimeUtils.getNanoTime());
                int c=rand.nextInt(26)+'a';
                keyValueEntity.setFldKey(c+"");
                keyValueEntity.setFldValue((char)c+"");
                keyValueEntitys.add(keyValueEntity);
            }
            keyValueMapper.insertBatch(keyValueEntitys);
            countDownLatch.countDown();
        }).start();

        new Thread(()->{
            ArrayList<KeyValueEntity> keyValueEntitys = new ArrayList<>();
            for (int i = 0; i<100; i++){
                KeyValueEntity keyValueEntity = new KeyValueEntity();
                keyValueEntity.setId(NanoTimeUtils.getNanoTime());
                int c=rand.nextInt(26)+'a';
                keyValueEntity.setFldKey(c+"");
                keyValueEntity.setFldValue((char)c+"");
                keyValueEntitys.add(keyValueEntity);
            }
            keyValueMapper.insertBatch(keyValueEntitys);
            countDownLatch.countDown();
        }).start();
//
        new Thread(()->{
            ArrayList<KeyValueEntity> keyValueEntitys = new ArrayList<>();
            for (int i = 0; i<100; i++){
                KeyValueEntity keyValueEntity = new KeyValueEntity();
                keyValueEntity.setId(NanoTimeUtils.getNanoTime());
                int c=rand.nextInt(26)+'a';
                keyValueEntity.setFldKey(c+"");
                keyValueEntity.setFldValue((char)c+"");
                keyValueEntitys.add(keyValueEntity);
            }
            keyValueMapper.insertBatch(keyValueEntitys);
            countDownLatch.countDown();
        }).start();

        try {
            countDownLatch.await();
            System.out.println(System.currentTimeMillis()-currentTimeMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

//    public static void main(String[] args) {
//        Timestamp timestamp;
////        for (int i = 0; i < 10; i++) {
////            timestamp=new Timestamp(System.currentTimeMillis());
////            timestamp.setNanos(new Long(System.nanoTime() % 1000000000).intValue());
////            int ms = (timestamp.getNanos()%1000000000)/1000000;
////            int us = (timestamp.getNanos()%1000000)/1000;
////            int ns = (timestamp.getNanos()%1000);
////            System.out.println(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp)+"."+ms+"."+us+"."+ns);
////            try {
////                Thread.sleep(1);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////        }
//        long currentnanotime = System.nanoTime();
//        System.out.println("currentnanotime:"+currentnanotime);
//
//        long currentTimeMillis = System.currentTimeMillis();
//        System.out.println("currentTimeMillis:"+currentTimeMillis);
//
//        long nanosplit = new Long(currentnanotime/100 % 1000000000).intValue();
//        System.out.println("nanosplit:"+nanosplit);
//
//        timestamp=new Timestamp(currentTimeMillis);
//        timestamp.setNanos(new Long(nanosplit).intValue());
//
//        System.out.println("纳秒时间戳："+(currentTimeMillis * 1000000L + currentnanotime/100 % 1000000L));
//
//        System.out.println("timestamp: "+timestamp);
//
////        long start = System.nanoTime();;
////        for (int i = 0;i<2000;i++){
////            System.out.println(System.nanoTime());
////        }
////        System.out.println(System.nanoTime() - start);
//
//    }


    public static void main(String[] args) {


        long l = System.nanoTime();
        long count = 0;
        for (int i =0;i<1000000;i++){
            count=+System.nanoTime();
        }
        System.out.println(count);
        System.out.println(System.nanoTime()-l);

    }

}
*/
