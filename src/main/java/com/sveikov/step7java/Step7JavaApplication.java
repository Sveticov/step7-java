package com.sveikov.step7java;

//import io.rudin.s7connector.bean.S7Serializer;
//import io.rudin.s7connector.impl.S7Connector;
//import io.rudin.s7connector.impl.S7TCPConnection;
//import io.rudin.s7connector.impl.nodave.DaveArea;
import com.sourceforge.snap7.moka7.S7;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import si.trina.moka7.live.PLC;
import si.trina.moka7.live.PLCListener;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.stream.IntStream;

@Slf4j
@SpringBootApplication
public class Step7JavaApplication implements CommandLineRunner{

    @Autowired
    Comp7Interface comp7Interface;
    @Autowired
    BeanComponent beanComponent;

    public static void main(String[] args) {
        SpringApplication.run(Step7JavaApplication.class, args);
    }




    @Override
    public void run(String... args) throws Exception {
        System.out.println("start");
        PLC plc=new PLC("plc1","192.168.0.190",
                8,
                32,
                1,
                0,
                new double[]{4.0,4.1},0,2,S7.S7AreaDB,S7.S7AreaDB
        );


        PLCListenerImpl plcListener=new PLCListenerImpl();
plc.listeners.add(plcListener);

Thread t=new Thread(plc);
t.start();
while (true) {
    System.out.println("connected  "+plc.connected);

    System.out.println(plc.getDInt(true, 0) + "ut ");
 double v=  beanComponent.convertIEEE().convertToIEEE(plc.getDInt(true, 0));

    comp7Interface.setValue(v);
    log.info("real value: "+v);


    System.out.println(plc.getInt(true, 6) + "utf ");
    Thread.sleep(500);

}

    }
}
