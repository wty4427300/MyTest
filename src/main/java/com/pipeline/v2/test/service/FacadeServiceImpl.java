package com.pipeline.v2.test.service;

import com.pipeline.v2.test.pojo.Car;
import org.springframework.stereotype.Service;

@Service
public class FacadeServiceImpl implements IFacadeService {

    @Override
    public Car getCarInfoByCarNO(String carNo) {
        Car car = new Car();
        car.setCarNo("32343");
        return car;
    }
}