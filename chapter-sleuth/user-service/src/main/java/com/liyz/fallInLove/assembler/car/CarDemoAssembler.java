package com.liyz.fallInLove.assembler.car;

import com.liyz.fallInLove.core.CarDemo;
import com.liyz.fallInLove.dto.CarDemoDTO;
import com.yixin.common.system.util.BaseAssembler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CarDemoAssembler extends BaseAssembler
{

    public static CarDemoDTO toDto(CarDemo carDemo) {
        if (carDemo == null) {
            return null;
        }
        CarDemoDTO carDemoDTO = new CarDemoDTO();
        mapObj(carDemo, carDemoDTO);
        return carDemoDTO;
    }

  
    public static List<CarDemoDTO> toDtos(List<CarDemo> carDemos) {
        if (carDemos == null) {
            return Collections.emptyList();
        }
        List<CarDemoDTO> CarDemoDTOs = new ArrayList<>();
        for (CarDemo carDemo : carDemos) {
            CarDemoDTOs.add(toDto(carDemo));
        }
        return CarDemoDTOs;
    }

    
    public static CarDemo toEntity(CarDemoDTO CarDemoDTO) {
        if (CarDemoDTO == null) {
            return null;
        }
        CarDemo carDemo = new CarDemo();
        mapObj(CarDemoDTO, carDemo);
        return carDemo;
    }

    /**
    *@param  CarDemoDTOs
    *@return List<CarDemo>
    *@author code generator
    */
    public static List<CarDemo> toEntitys(List<CarDemoDTO> CarDemoDTOs) {
        if (CarDemoDTOs == null) {
            return Collections.emptyList();
        }
        List<CarDemo> carDemos = new ArrayList<>();
        for (CarDemoDTO CarDemoDTO : CarDemoDTOs) {
        	carDemos.add(toEntity(CarDemoDTO));
        }
        return carDemos;
    }
}